package core.org.akaza.openclinica.service;

import core.org.akaza.openclinica.bean.login.UserAccountBean;
import core.org.akaza.openclinica.dao.hibernate.*;
import core.org.akaza.openclinica.domain.datamap.*;
import core.org.akaza.openclinica.domain.user.UserAccount;
import core.org.akaza.openclinica.service.crfdata.ErrorObj;
import core.org.akaza.openclinica.service.managestudy.StudySubjectService;
import org.akaza.openclinica.controller.dto.FormRequestDTO;
import org.akaza.openclinica.controller.dto.FormResponseDTO;
import org.akaza.openclinica.domain.enumsupport.EventCrfWorkflowStatusEnum;
import org.akaza.openclinica.web.restful.errors.ErrorConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service("EventCRFService")
public class EventCRFServiceImpl implements EventCRFService {

    public static final String FAILED = "Failed";
    protected final Logger logger = LoggerFactory.getLogger(getClass().getName());
    @Autowired
    StudySubjectService studySubjectService;
    @Autowired
    StudyEventService studyEventService;
    @Autowired
    StudyAndSiteService studyAndSiteService;
    @Autowired
    EventCrfDao eventCrfDao;
    @Autowired
    UserAccountDao userAccountDao;

    @Autowired
    CrfVersionDao crfVersionDao;
    @Autowired
    CompletionStatusDao completionStatusDao;

    final String DEFAULT_EVENT_REPEAT_KEY = "1";

    @Override
    public FormResponseDTO createEventCrf(FormRequestDTO formRequestDTO, String studyOid, String siteOid, UserAccountBean userAccountBean) {
        CustomRuntimeException validationErrors = new CustomRuntimeException("Validation error while creating eventCRF.");

        validateFormRequestDTO(studyOid, siteOid, formRequestDTO, validationErrors);
        if (validationErrors.hasErrors()) { throw validationErrors; }

        Study study = studyAndSiteService.validateSiteExists(siteOid, validationErrors);
        if (study == null) { throw validationErrors; }

        StudySubject studySubject = studySubjectService.validateStudySubjectExists(study, formRequestDTO.getSubjectKey(), validationErrors);
        if (studySubject == null) { throw validationErrors; }

        StudyEvent studyEvent = studyEventService.validateStudyEventExists(studySubject, formRequestDTO.getStudyEventOID(), formRequestDTO.getStudyEventRepeatKey(), validationErrors);
        if (studyEvent == null) { throw validationErrors; }

        EventCrf eventCrf = validateCreatingEventCrf(formRequestDTO, studyEvent, userAccountBean, validationErrors);

        if (!validationErrors.hasErrors()) {
            eventCrf = addEventCrfToStudyEvent(eventCrf, formRequestDTO, studySubject, studyEvent);
            return createFormResponseDTO(formRequestDTO, eventCrf);
        } else {
            throw validationErrors;
        }
    }

    @Override
    public FormResponseDTO updateEventCrf(FormRequestDTO formRequestDTO, String studyOid, String siteOid, UserAccountBean userAccountBean) {
        CustomRuntimeException validationErrors = new CustomRuntimeException("Validation error while updating eventCRF.");

        validateFormRequestDTO(studyOid, siteOid, formRequestDTO, validationErrors);
        if (validationErrors.hasErrors()) { throw validationErrors; }

        Study study = studyAndSiteService.validateSiteExists(siteOid, validationErrors);
        if (study == null) { throw validationErrors; }

        StudySubject studySubject = studySubjectService.validateStudySubjectExists(study, formRequestDTO.getSubjectKey(), validationErrors);
        if (studySubject == null) { throw validationErrors; }

        StudyEvent studyEvent = studyEventService.validateStudyEventExists(studySubject, formRequestDTO.getStudyEventOID(), formRequestDTO.getStudyEventRepeatKey(), validationErrors);
        if (studyEvent == null) { throw validationErrors; }

        EventCrf eventCrf = validateUpdatingEventCrf(formRequestDTO, studyEvent, validationErrors, userAccountBean);

        //TODO Update user account bean info, check create method for other stuff.
        if (!validationErrors.hasErrors()) {
            eventCrf = updateEventCrfInStudyEvent(formRequestDTO, eventCrf);
            return createFormResponseDTO(formRequestDTO, eventCrf);
        } else {
            throw validationErrors;
        }
    }

    private EventCrf validateCreatingEventCrf(FormRequestDTO formRequestDTO, StudyEvent studyEvent, UserAccountBean userAccountBean, CustomRuntimeException validationErrors) {

        EventCrf existingEventCrf = eventCrfDao.findByStudyEventOIdStudySubjectOIdCrfOId(formRequestDTO.getStudyEventOID(), formRequestDTO.getSubjectKey(), formRequestDTO.getFormOID(), Integer.parseInt(formRequestDTO.getStudyEventRepeatKey()));
        if (existingEventCrf != null) {
            validationErrors.addError(new ErrorObj(FAILED, ErrorConstants.ERR_FORM_ALREADY_EXISTS));
            return null;
        }

        //TODO What status syntax does the user use?
        if (formRequestDTO.getFormWorkflowStatus() == null){
            formRequestDTO.setFormWorkflowStatus(EventCrfWorkflowStatusEnum.NOT_STARTED.name());
        } else if (formRequestDTO.getFormWorkflowStatus().equals(EventCrfWorkflowStatusEnum.COMPLETED)){
            validationErrors.addError(new ErrorObj(FAILED, ErrorConstants.ERR_NEW_FORM_CANNOT_BE_MARKED_COMPLETE));
        }

        EventCrf eventCrf = new EventCrf();
        EventDefinitionCrf eventDefinitionCrf = getEventDefinitionCrf(studyEvent, formRequestDTO.getFormOID());
        if (eventDefinitionCrf == null){
            validationErrors.addError(new ErrorObj(FAILED, ErrorConstants.ERR_FORM_NOT_FOUND));
            return null;
        }
        FormLayout formLayout = eventDefinitionCrf.getFormLayout();
        CrfVersion crfVersion = crfVersionDao.findAllByCrfId(formLayout.getCrf().getCrfId()).get(0);
        eventCrf.setCrfVersion(crfVersion);
        eventCrf.setFormLayout(formLayout);

        UserAccount userAccount = userAccountDao.findById(userAccountBean.getId());
        eventCrf.setUserAccount(userAccount);
        eventCrf.setUpdateId(userAccount.getUserId());

        return eventCrf;
    }

    private EventCrf addEventCrfToStudyEvent(EventCrf eventCrf, FormRequestDTO formRequestDTO, StudySubject studySubject, StudyEvent studyEvent) {

        Date currentDate = new Date();
        eventCrf.setDateCreated(currentDate);
        eventCrf.setAnnotations("");
        eventCrf.setInterviewerName("");
        eventCrf.setDateInterviewed(null);
        eventCrf.setCompletionStatus(completionStatusDao.findByCompletionStatusId(1));// setCompletionStatusId(1);
        eventCrf.setStudySubject(studySubject);
        eventCrf.setStudyEvent(studyEvent);
        eventCrf.setValidateString("");
        eventCrf.setValidatorAnnotations("");
        eventCrf.setDateUpdated(new Date());
        eventCrf.setValidatorId(0);
        eventCrf.setOldStatusId(0);
        eventCrf.setSdvUpdateId(0);
        eventCrf.setSdvStatus(null);

        eventCrf.setWorkflowStatus(EventCrfWorkflowStatusEnum.valueOf(formRequestDTO.getFormWorkflowStatus()));

        if (formRequestDTO.getRequired() != null ){
            eventCrf.setRequired(Boolean.valueOf(formRequestDTO.getRequired()));
        }
        if (formRequestDTO.getRelevant() != null ){
            eventCrf.setRelevant(Boolean.valueOf(formRequestDTO.getRelevant()));
        }
        if (formRequestDTO.getEditable() != null ){
            eventCrf.setEditable(Boolean.valueOf(formRequestDTO.getEditable()));
        }

        logger.info("Creating new Event Crf");
        eventCrfDao.saveOrUpdate(eventCrf);

        return eventCrf;
    }

    private EventDefinitionCrf getEventDefinitionCrf(StudyEvent studyEvent, String formOID) {
        for (EventDefinitionCrf eventDefCrf : studyEvent.getStudyEventDefinition().getEventDefinitionCrfs()){
            if (eventDefCrf.getCrf().getOcOid().equals(formOID)){
                return eventDefCrf;
            }
        }
        return null;
    }

    private EventCrf validateUpdatingEventCrf(FormRequestDTO formRequestDTO, StudyEvent studyEvent, CustomRuntimeException validationErrors, UserAccountBean userAccountBean) {
        EventCrf eventCrf = eventCrfDao.findByStudyEventOIdStudySubjectOIdCrfOId(formRequestDTO.getStudyEventOID(), formRequestDTO.getSubjectKey(), formRequestDTO.getFormOID(), Integer.parseInt(formRequestDTO.getStudyEventRepeatKey()));
        if (eventCrf == null) {
            validationErrors.addError(new ErrorObj(FAILED, ErrorConstants.ERR_FORM_NOT_FOUND));
            return null;
        }
        if (formRequestDTO.getFormWorkflowStatus() != null && formRequestDTO.getFormWorkflowStatus().equals(EventCrfWorkflowStatusEnum.NOT_STARTED)){
            validationErrors.addError(new ErrorObj(FAILED, ErrorConstants.ERR_FORM_WITH_DATA_CANNOT_BE_SET_NOT_STARTED));
        }

        UserAccount userAccount = userAccountDao.findById(userAccountBean.getId());
        eventCrf.setUserAccount(userAccount);
        eventCrf.setUpdateId(userAccount.getUserId());

        return eventCrf;
    }

    private EventCrf updateEventCrfInStudyEvent(FormRequestDTO formRequestDTO, EventCrf eventCrf) {

        if (formRequestDTO.getFormWorkflowStatus() != null ){
            eventCrf.setWorkflowStatus(EventCrfWorkflowStatusEnum.valueOf(formRequestDTO.getFormWorkflowStatus()));
        }

        if (formRequestDTO.getRequired() != null ){
            eventCrf.setRequired(Boolean.valueOf(formRequestDTO.getRequired()));
        }
        if (formRequestDTO.getRelevant() != null ){
            eventCrf.setRelevant(Boolean.valueOf(formRequestDTO.getRelevant()));
        }
        if (formRequestDTO.getEditable() != null ){
            eventCrf.setEditable(Boolean.valueOf(formRequestDTO.getEditable()));
        }

        eventCrfDao.saveOrUpdate(eventCrf);

        return eventCrf;
    }

    private void validateFormRequestDTO(String studyOid, String siteOid, FormRequestDTO formRequestDTO, CustomRuntimeException validationErrors){
        if (studyOid == null){
            validationErrors.addError(new ErrorObj(FAILED, ErrorConstants.ERR_STUDY_OID_MISSING));
        }
        if (siteOid == null){
            validationErrors.addError(new ErrorObj(FAILED, ErrorConstants.ERR_SITE_OID_MISSING));
        }
        if (formRequestDTO.getSubjectKey() == null){
            validationErrors.addError(new ErrorObj(FAILED, ErrorConstants.ERR_MISSING_PARTICIPANT_ID));
        }
        if (formRequestDTO.getStudyEventOID() == null){
            validationErrors.addError(new ErrorObj(FAILED, ErrorConstants.ERR_MISSING_STUDYEVENTOID));
        }
        if (formRequestDTO.getFormOID() == null){
            validationErrors.addError(new ErrorObj(FAILED, ErrorConstants.ERR_MISSING_FORMOID));
        }

        List<EventCrfWorkflowStatusEnum> enumValues = Arrays.asList(EventCrfWorkflowStatusEnum.values());
        if (formRequestDTO.getFormWorkflowStatus() != null && !enumValues.contains(formRequestDTO.getFormWorkflowStatus())){
            validationErrors.addError(new ErrorObj(FAILED, ErrorConstants.ERR_FORM_STATUS_NOT_VALID));
        }

        if (formRequestDTO.getStudyEventRepeatKey() == null){
            formRequestDTO.setStudyEventRepeatKey(DEFAULT_EVENT_REPEAT_KEY);
        }

        if (!isValidBoolean(formRequestDTO.getRequired())){
            validationErrors.addError(new ErrorObj(FAILED, ErrorConstants.ERR_FORM_REQUIRED_FLAG_NOT_VALID));
        }
        if (!isValidBoolean(formRequestDTO.getRelevant())){
            validationErrors.addError(new ErrorObj(FAILED, ErrorConstants.ERR_FORM_RELEVANT_FLAG_NOT_VALID));
        }
        if (!isValidBoolean(formRequestDTO.getEditable())){
            validationErrors.addError(new ErrorObj(FAILED, ErrorConstants.ERR_FORM_EDITABLE_FLAG_NOT_VALID));
        }
    }

    private boolean isValidBoolean(String booleanString){
        if (booleanString == null){
            return false;
        }
        booleanString = booleanString.toLowerCase();
        if (booleanString.equals("true") || booleanString.equals("false")){
            return true;
        }
        return false;
    }

    private FormResponseDTO createFormResponseDTO(FormRequestDTO formRequestDTO, EventCrf eventCrf) {
        FormResponseDTO formResponseDTO = new FormResponseDTO();
        formResponseDTO.setSubjectKey(formRequestDTO.getSubjectKey());
        formResponseDTO.setStudyEventOID(formRequestDTO.getStudyEventOID());
        formResponseDTO.setStudyEventRepeatKey(formRequestDTO.getStudyEventRepeatKey());
        formResponseDTO.setFormOID(formRequestDTO.getFormOID());

        if (formRequestDTO.getFormWorkflowStatus() != null ){
            formResponseDTO.setFormWorkflowStatus(eventCrf.getWorkflowStatus().getDisplayValue());
        }
        if (eventCrf.getRequired() != null ){
            formResponseDTO.setRequired(eventCrf.getRequired().toString());
        }
        if (eventCrf.getRelevant() != null ){
            formResponseDTO.setRelevant(eventCrf.getRelevant().toString());
        }
        if (eventCrf.getEditable() != null ){
            formResponseDTO.setEditable(eventCrf.getEditable().toString());
        }

        return formResponseDTO;
    }

}




