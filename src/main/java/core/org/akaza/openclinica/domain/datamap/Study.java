// default package
// Generated Jul 31, 2013 2:03:33 PM by Hibernate Tools 3.4.0.CR1
package core.org.akaza.openclinica.domain.datamap;

import static javax.persistence.EnumType.STRING;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import core.org.akaza.openclinica.bean.login.UserAccountBean;
import core.org.akaza.openclinica.bean.service.StudyParameterValueBean;
import core.org.akaza.openclinica.bean.service.StudyParamsConfig;
import core.org.akaza.openclinica.core.SessionManager;
import core.org.akaza.openclinica.dao.core.CoreResources;
import core.org.akaza.openclinica.dao.login.UserAccountDAO;
import core.org.akaza.openclinica.domain.DataMapDomainObject;
import core.org.akaza.openclinica.domain.Status;
import core.org.akaza.openclinica.domain.enumsupport.ModuleStatus;
import core.org.akaza.openclinica.domain.user.UserAccount;
import org.akaza.openclinica.config.StudyParamNames;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;


/**
 * Study generated by hbm2java
 */
@Entity
@Table(name = "study", uniqueConstraints = @UniqueConstraint(columnNames = "oc_oid"))
@GenericGenerator(name = "id-generator", strategy = "native", parameters = { @Parameter(name = "sequence_name", value = "study_study_id_seq") })
public class Study extends DataMapDomainObject {

    private int studyId;
    private UserAccount userAccount;
    private StudyType studyType;
    private Study study;
    private Status status;
    private String uniqueIdentifier;
    private String secondaryIdentifier;
    private String name;
    private String summary;
    private Date datePlannedStart;
    private Date datePlannedEnd;
    private Date dateCreated;
    private Date dateUpdated;
    private Integer updateId;
    private String principalInvestigator;
    private String facilityName;
    private String facilityCity;
    private String facilityState;
    private String facilityZip;
    private String facilityCountry;
    private String facilityRecruitmentStatus;
    private String facilityContactName;
    private String facilityContactDegree;
    private String facilityContactPhone;
    private String facilityContactEmail;
    private String protocolType;
    private String protocolDescription;
    private Date protocolDateVerification;
    private String phase;
    private Integer expectedTotalEnrollment;
    private String sponsor;
    private String collaborators;
    private String medlineIdentifier;
    private String url;
    private String urlDescription;
    private String conditions;
    private String keywords;
    private String eligibility;
    private String gender = "both";
    private String ageMax;
    private String ageMin;
    private Boolean healthyVolunteerAccepted = false;
    private String purpose;
    private String allocation;
    private String masking;
    private String control;
    private String assignment;
    private String endpoint;
    private String interventions;
    private String duration;
    private String selection;
    private String timing;
    private String officialTitle;
    private Boolean resultsReference = false;
    private String oc_oid;
    private Integer oldStatusId;
    private List<CrfBean> crfs;
    private List<StudyEventDefinition> studyEventDefinitions;
    private List<Study> studies;
    private List<StudyUserRole> studyUserRoles;
    // private Set datasets = new HashSet(0);
    private List<StudyParameterValue> studyParameterValues;
    private List<StudySubject> studySubjects;
    private List<EventDefinitionCrf> eventDefinitionCrfs;
    private List<DiscrepancyNote> discrepancyNotes;
    private List<StudyModuleStatus> studyModuleStatuses;
    private Integer version;
    private String schemaName;
    private String studyEnvSiteUuid;
    private StudyEnvEnum envType;
    private boolean published;
    private int filePath;
    private String studyUuid;
    private int subjectCount;
    private String boardUrl;
    
    @Column(name = "study_env_uuid", unique = false)
    public String getStudyEnvUuid() {
        return studyEnvUuid;
    }

    public void setStudyEnvUuid(String studyEnvUuid) {
        this.studyEnvUuid = studyEnvUuid;
    }

    private String studyEnvUuid;

    public Study() {
    }

    public Study(int studyId, String ocOid) {
        this.studyId = studyId;
        this.oc_oid = ocOid;
    }

    public Study(int studyId, UserAccount userAccount, StudyType studyType, Study study, Status status, String uniqueIdentifier, String secondaryIdentifier,
            String name, String summary, Date datePlannedStart, Date datePlannedEnd, Date dateCreated, Date dateUpdated, Integer updateId,
            String principalInvestigator, String facilityName, String facilityCity, String facilityState, String facilityZip, String facilityCountry,
            String facilityRecruitmentStatus, String facilityContactName, String facilityContactDegree, String facilityContactPhone,
            String facilityContactEmail, String protocolType, String protocolDescription, Date protocolDateVerification, String phase,
            Integer expectedTotalEnrollment, String sponsor, String collaborators, String medlineIdentifier, String url, String urlDescription,
            String conditions, String keywords, String eligibility, String gender, String ageMax, String ageMin, Boolean healthyVolunteerAccepted,
            String purpose, String allocation, String masking, String control, String assignment, String endpoint, String interventions, String duration,
            String selection, String timing, String officialTitle, Boolean resultsReference, String ocOid, Integer oldStatusId, List<CrfBean> crfs,
            List<StudyEventDefinition> studyEventDefinitions, List<Study> studies, List<StudyUserRole> studyUserRoles, Set datasets,
            List<StudyParameterValue> studyParameterValues, List<StudySubject> studySubjects, List<EventDefinitionCrf> eventDefinitionCrfs,
            List<DiscrepancyNote> discrepancyNotes, List<StudyModuleStatus> studyModuleStatuses) {
        this.studyId = studyId;
        this.userAccount = userAccount;
        this.studyType = studyType;
        this.study = study;
        this.status = status;
        this.uniqueIdentifier = uniqueIdentifier;
        this.secondaryIdentifier = secondaryIdentifier;
        this.name = name;
        this.summary = summary;
        this.datePlannedStart = datePlannedStart;
        this.datePlannedEnd = datePlannedEnd;
        this.dateCreated = dateCreated;
        this.dateUpdated = dateUpdated;
        this.updateId = updateId;
        this.principalInvestigator = principalInvestigator;
        this.facilityName = facilityName;
        this.facilityCity = facilityCity;
        this.facilityState = facilityState;
        this.facilityZip = facilityZip;
        this.facilityCountry = facilityCountry;
        this.facilityRecruitmentStatus = facilityRecruitmentStatus;
        this.facilityContactName = facilityContactName;
        this.facilityContactDegree = facilityContactDegree;
        this.facilityContactPhone = facilityContactPhone;
        this.facilityContactEmail = facilityContactEmail;
        this.protocolType = protocolType;
        this.protocolDescription = protocolDescription;
        this.protocolDateVerification = protocolDateVerification;
        this.phase = phase;
        this.expectedTotalEnrollment = expectedTotalEnrollment;
        this.sponsor = sponsor;
        this.collaborators = collaborators;
        this.medlineIdentifier = medlineIdentifier;
        this.url = url;
        this.urlDescription = urlDescription;
        this.conditions = conditions;
        this.keywords = keywords;
        this.eligibility = eligibility;
        this.gender = gender;
        this.ageMax = ageMax;
        this.ageMin = ageMin;
        this.healthyVolunteerAccepted = healthyVolunteerAccepted;
        this.purpose = purpose;
        this.allocation = allocation;
        this.masking = masking;
        this.control = control;
        this.assignment = assignment;
        this.endpoint = endpoint;
        this.interventions = interventions;
        this.duration = duration;
        this.selection = selection;
        this.timing = timing;
        this.officialTitle = officialTitle;
        this.resultsReference = resultsReference;
        this.oc_oid = ocOid;
        this.oldStatusId = oldStatusId;
        this.crfs = crfs;
        this.studyEventDefinitions = studyEventDefinitions;
        this.studies = studies;
        this.studyUserRoles = studyUserRoles;
        // this.datasets = datasets;
        this.studyParameterValues = studyParameterValues;
        this.studySubjects = studySubjects;
        this.eventDefinitionCrfs = eventDefinitionCrfs;
        this.discrepancyNotes = discrepancyNotes;
        this.studyModuleStatuses = studyModuleStatuses;
    }

    @Id
    @GeneratedValue(generator = "study-id-generator", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "study-id-generator", sequenceName = "public.study_study_id_seq", initialValue = 1, allocationSize = 1)
    @Column(name = "study_id", unique = true, nullable = false)
    public int getStudyId() {
        return this.studyId;
    }

    public void setStudyId(int studyId) {
        this.studyId = studyId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
    public UserAccount getUserAccount() {
        return this.userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }

    // @JoinColumn(name = "type_id")
    // @JoinColumn(name = "type_id")
    // public StudyType getStudyType() {
    // return this.studyType;
    // }
    //
    // public void setStudyType(StudyType studyType) {
    // this.studyType = studyType;
    // }

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "parent_study_id")
	public Study getStudy() {
		return this.study;
	}

    public void setStudy(Study study) {
        this.study = study;
    }

    @Type(type = "status")
    @Column(name = "status_id")
    public Status getStatus() {
        return this.status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Column(name = "unique_identifier", length = 30)
    public String getUniqueIdentifier() {
        return this.uniqueIdentifier;
    }

    public void setUniqueIdentifier(String uniqueIdentifier) {
        this.uniqueIdentifier = uniqueIdentifier;
    }

    @Column(name = "secondary_identifier")
    public String getSecondaryIdentifier() {
        return this.secondaryIdentifier;
    }

    public void setSecondaryIdentifier(String secondaryIdentifier) {
        this.secondaryIdentifier = secondaryIdentifier;
    }

    @Column(name = "name")
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "summary")
    public String getSummary() {
        return this.summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "date_planned_start", length = 4)
    public Date getDatePlannedStart() {
        return this.datePlannedStart;
    }

    public void setDatePlannedStart(Date datePlannedStart) {
        this.datePlannedStart = datePlannedStart;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "date_planned_end", length = 4)
    public Date getDatePlannedEnd() {
        return this.datePlannedEnd;
    }

    public void setDatePlannedEnd(Date datePlannedEnd) {
        this.datePlannedEnd = datePlannedEnd;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "date_created", length = 4)
    public Date getDateCreated() {
        return this.dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "date_updated", length = 4)
    public Date getDateUpdated() {
        return this.dateUpdated;
    }

    public void setDateUpdated(Date dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    @Column(name = "update_id")
    public Integer getUpdateId() {
        return this.updateId;
    }

    public void setUpdateId(Integer updateId) {
        this.updateId = updateId;
    }

    @Column(name = "principal_investigator")
    public String getPrincipalInvestigator() {
        return this.principalInvestigator;
    }

    public void setPrincipalInvestigator(String principalInvestigator) {
        this.principalInvestigator = principalInvestigator;
    }

    @Column(name = "facility_name")
    public String getFacilityName() {
        return this.facilityName;
    }

    public void setFacilityName(String facilityName) {
        this.facilityName = facilityName;
    }

    @Column(name = "facility_city")
    public String getFacilityCity() {
        return this.facilityCity;
    }

    public void setFacilityCity(String facilityCity) {
        this.facilityCity = facilityCity;
    }

    @Column(name = "facility_state", length = 20)
    public String getFacilityState() {
        return this.facilityState;
    }

    public void setFacilityState(String facilityState) {
        this.facilityState = facilityState;
    }

    @Column(name = "facility_zip", length = 64)
    public String getFacilityZip() {
        return this.facilityZip;
    }

    public void setFacilityZip(String facilityZip) {
        this.facilityZip = facilityZip;
    }

    @Column(name = "facility_country", length = 64)
    public String getFacilityCountry() {
        return this.facilityCountry;
    }

    public void setFacilityCountry(String facilityCountry) {
        this.facilityCountry = facilityCountry;
    }

    @Column(name = "facility_recruitment_status", length = 60)
    public String getFacilityRecruitmentStatus() {
        return this.facilityRecruitmentStatus;
    }

    public void setFacilityRecruitmentStatus(String facilityRecruitmentStatus) {
        this.facilityRecruitmentStatus = facilityRecruitmentStatus;
    }

    @Column(name = "facility_contact_name")
    public String getFacilityContactName() {
        return this.facilityContactName;
    }

    public void setFacilityContactName(String facilityContactName) {
        this.facilityContactName = facilityContactName;
    }

    @Column(name = "facility_contact_degree")
    public String getFacilityContactDegree() {
        return this.facilityContactDegree;
    }

    public void setFacilityContactDegree(String facilityContactDegree) {
        this.facilityContactDegree = facilityContactDegree;
    }

    @Column(name = "facility_contact_phone")
    public String getFacilityContactPhone() {
        return this.facilityContactPhone;
    }

    public void setFacilityContactPhone(String facilityContactPhone) {
        this.facilityContactPhone = facilityContactPhone;
    }

    @Column(name = "facility_contact_email")
    public String getFacilityContactEmail() {
        return this.facilityContactEmail;
    }

    public void setFacilityContactEmail(String facilityContactEmail) {
        this.facilityContactEmail = facilityContactEmail;
    }

    @Column(name = "protocol_type", length = 30)
    public String getProtocolType() {
        return this.protocolType;
    }

    public void setProtocolType(String protocolType) {
        this.protocolType = protocolType;
    }

    @Column(name = "protocol_description", length = 1000)
    public String getProtocolDescription() {
        return this.protocolDescription;
    }

    public void setProtocolDescription(String protocolDescription) {
        this.protocolDescription = protocolDescription;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "protocol_date_verification", length = 4)
    public Date getProtocolDateVerification() {
        return this.protocolDateVerification;
    }

    public void setProtocolDateVerification(Date protocolDateVerification) {
        this.protocolDateVerification = protocolDateVerification;
    }

    @Column(name = "phase", length = 30)
    public String getPhase() {
        return this.phase;
    }

    public void setPhase(String phase) {
        this.phase = phase;
    }

    @Column(name = "expected_total_enrollment")
    public Integer getExpectedTotalEnrollment() {
        return this.expectedTotalEnrollment;
    }

    public void setExpectedTotalEnrollment(Integer expectedTotalEnrollment) {
        this.expectedTotalEnrollment = expectedTotalEnrollment;
    }

    @Column(name = "sponsor")
    public String getSponsor() {
        return this.sponsor;
    }

    public void setSponsor(String sponsor) {
        this.sponsor = sponsor;
    }

    @Column(name = "collaborators", length = 1000)
    public String getCollaborators() {
        return this.collaborators;
    }

    public void setCollaborators(String collaborators) {
        this.collaborators = collaborators;
    }

    @Column(name = "medline_identifier")
    public String getMedlineIdentifier() {
        return this.medlineIdentifier;
    }

    public void setMedlineIdentifier(String medlineIdentifier) {
        this.medlineIdentifier = medlineIdentifier;
    }

    @Column(name = "url")
    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Column(name = "url_description")
    public String getUrlDescription() {
        return this.urlDescription;
    }

    public void setUrlDescription(String urlDescription) {
        this.urlDescription = urlDescription;
    }

    @Column(name = "conditions", length = 500)
    public String getConditions() {
        return this.conditions;
    }

    public void setConditions(String conditions) {
        this.conditions = conditions;
    }

    @Column(name = "keywords")
    public String getKeywords() {
        return this.keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    @Column(name = "eligibility", length = 500)
    public String getEligibility() {
        return this.eligibility;
    }

    public void setEligibility(String eligibility) {
        this.eligibility = eligibility;
    }

    @Column(name = "gender", length = 30)
    public String getGender() {
        if(this.gender == null)
            this.gender = "both";
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Column(name = "age_max", length = 3)
    public String getAgeMax() {
        return this.ageMax;
    }

    public void setAgeMax(String ageMax) {
        this.ageMax = ageMax;
    }

    @Column(name = "age_min", length = 3)
    public String getAgeMin() {
        return this.ageMin;
    }

    public void setAgeMin(String ageMin) {
        this.ageMin = ageMin;
    }

    @Column(name = "healthy_volunteer_accepted")
    public Boolean getHealthyVolunteerAccepted() {
        if(healthyVolunteerAccepted == null)
            healthyVolunteerAccepted = false;
        return this.healthyVolunteerAccepted;
    }

    public void setHealthyVolunteerAccepted(Boolean healthyVolunteerAccepted) {
        this.healthyVolunteerAccepted = healthyVolunteerAccepted;
    }

    @Column(name = "purpose", length = 64)
    public String getPurpose() {
        return this.purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    @Column(name = "allocation", length = 64)
    public String getAllocation() {
        return this.allocation;
    }

    public void setAllocation(String allocation) {
        this.allocation = allocation;
    }

    @Column(name = "masking", length = 30)
    public String getMasking() {
        return this.masking;
    }

    public void setMasking(String masking) {
        this.masking = masking;
    }

    @Column(name = "control", length = 30)
    public String getControl() {
        return this.control;
    }

    public void setControl(String control) {
        this.control = control;
    }

    @Column(name = "assignment", length = 30)
    public String getAssignment() {
        return this.assignment;
    }

    public void setAssignment(String assignment) {
        this.assignment = assignment;
    }

    @Column(name = "endpoint", length = 64)
    public String getEndpoint() {
        return this.endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    @Column(name = "interventions", length = 1000)
    public String getInterventions() {
        return this.interventions;
    }

    public void setInterventions(String interventions) {
        this.interventions = interventions;
    }

    @Column(name = "duration", length = 30)
    public String getDuration() {
        return this.duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    @Column(name = "selection", length = 30)
    public String getSelection() {
        return this.selection;
    }

    public void setSelection(String selection) {
        this.selection = selection;
    }

    @Column(name = "timing", length = 30)
    public String getTiming() {
        return this.timing;
    }

    public void setTiming(String timing) {
        this.timing = timing;
    }

    @Column(name = "official_title")
    public String getOfficialTitle() {
        return this.officialTitle;
    }

    public void setOfficialTitle(String officialTitle) {
        this.officialTitle = officialTitle;
    }

    @Column(name = "results_reference")
    public Boolean getResultsReference() {
        if(resultsReference == null)
            this.resultsReference = false;
        return this.resultsReference;
    }

    public void setResultsReference(Boolean resultsReference) {
        this.resultsReference = resultsReference;
    }

    @Column(name = "oc_oid", nullable = false, length = 40)
    public String getOc_oid() {
        return this.oc_oid;
    }

    public void setOc_oid(String ocOid) {
        this.oc_oid = ocOid;
    }

    @Column(name = "old_status_id")
    public Integer getOldStatusId() {
        return this.oldStatusId;
    }

    public void setOldStatusId(Integer oldStatusId) {
        this.oldStatusId = oldStatusId;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "study")
    public List<CrfBean> getCrfs() {
        return this.crfs;
    }

    public void setCrfs(List<CrfBean> crfs) {
        this.crfs = crfs;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "study")
    public List<StudyEventDefinition> getStudyEventDefinitions() {
        return this.studyEventDefinitions;
    }

    public void setStudyEventDefinitions(List<StudyEventDefinition> studyEventDefinitions) {
        this.studyEventDefinitions = studyEventDefinitions;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "study")
    public List<Study> getStudies() {
        return this.studies;
    }

    public void setStudies(List<Study> studies) {
        this.studies = studies;
    }

    // @OneToMany(fetch = FetchType.LAZY, mappedBy = "study")
    // public List<StudyUserRole> getStudyUserRoles() {
    // return this.studyUserRoles;
    // }
    //
    // public void setStudyUserRoles(List<StudyUserRole> studyUserRoles) {
    // this.studyUserRoles = studyUserRoles;
    // }

    /*
     * @OneToMany(fetch = FetchType.LAZY, mappedBy = "study")
     * public Set getDatasets() {
     * return this.datasets;
     * }
     *
     * public void setDatasets(Set datasets) {
     * this.datasets = datasets;
     * }
     */

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "study")
    public List<StudyParameterValue> getStudyParameterValues() {
        return this.studyParameterValues;
    }

    public void setStudyParameterValues(List<StudyParameterValue> studyParameterValues) {
        this.studyParameterValues = studyParameterValues;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "study")
    public List<StudySubject> getStudySubjects() {
        return this.studySubjects;
    }

    public void setStudySubjects(List<StudySubject> studySubjects) {
        this.studySubjects = studySubjects;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "study")
    public List<EventDefinitionCrf> getEventDefinitionCrfs() {
        return this.eventDefinitionCrfs;
    }

    public void setEventDefinitionCrfs(List<EventDefinitionCrf> eventDefinitionCrfs) {
        this.eventDefinitionCrfs = eventDefinitionCrfs;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "study")
    public List<DiscrepancyNote> getDiscrepancyNotes() {
        return this.discrepancyNotes;
    }

    public void setDiscrepancyNotes(List<DiscrepancyNote> discrepancyNotes) {
        this.discrepancyNotes = discrepancyNotes;
    }

    @Column(name = "schema_name", length = 64)
    public String getSchemaName() {
        return this.schemaName;
    }

    public void setSchemaName(String schemaName) {
        this.schemaName = schemaName;
    }

    @Column(name = "env_type")
    @Enumerated(STRING)
    public StudyEnvEnum getEnvType() {
        return envType;
    }

    public void setEnvType(StudyEnvEnum envType) {
        this.envType = envType;
    }

    @Column(name = "studyEnvSiteUuid", length = 64)
    public String getStudyEnvSiteUuid() {
        return this.studyEnvSiteUuid;
    }

    public void setStudyEnvSiteUuid(String studyEnvSiteUuid) {
        this.studyEnvSiteUuid = studyEnvSiteUuid;
    }

    @Column(name = "published")
    public boolean isPublished() {
        return published;
    }

    public void setPublished(boolean published) {
        this.published = published;
    }

    @Column(name = "file_path")
    public int getFilePath() {
        return filePath;
    }

    public void setFilePath(int filePath) {
        this.filePath = filePath;
    }

    @Column(name = "study_uuid", unique = false)
    public String getStudyUuid() {
        return studyUuid;
    }

    public void setStudyUuid(String studyUuid) {
        this.studyUuid = studyUuid;
    }

    public int getSubjectCount() {
        return subjectCount;
    }
    @Column(name = "subject_count")
    public void setSubjectCount(int subjectCount) {
        this.subjectCount = subjectCount;
    }

    @Column(name = "board_url", unique = false)
    public String getBoardUrl() {
        return boardUrl;
    }

    public void setBoardUrl(String boardUrl) {
        this.boardUrl = boardUrl;
    }

    @Transient
    public boolean isSite() {
        return getStudy() != null && getStudy().getStudyId() > 0 ? true : false;
    }

    //Parent Study is set to 0 if not present,This is done to use the same functionality of the getParentStudyId() in StudyDAO previously and 0 is handled in other places
    public int checkAndGetParentStudyId(){
        return isSite() ? this.getStudy().getStudyId() : 0;
    }

    public void setIndividualStudyParameterValue(String parameterName, String value){
        for(StudyParameterValue spv: getStudyParameterValues()){
            if(spv.getStudyParameter().getHandle().equalsIgnoreCase(parameterName)) {
                spv.setValue(value);
                return;
            }
        }
        if(this.isSite())
            this.getStudy().setIndividualStudyParameterValue(parameterName, value);
    }
    @Transient
    public String getIndividualStudyParameterValueOutput(String parameterName){
        if(this.isSite())
            return this.getStudy().getIndividualStudyParameterValueOutput(parameterName);

        for(StudyParameterValue spv : getStudyParameterValues()) {
            if (spv.getStudyParameter().getHandle().equalsIgnoreCase(parameterName))
                return spv.getValue();
    }
        return StudyParamNames.getDefaultValues(parameterName);
    }

    @Transient
    public StudyParameterValue getIndividualStudyParameterValue(String paramName){
        for(StudyParameterValue spv : getStudyParameterValues()) {
            if (spv.getStudyParameter().getHandle().equalsIgnoreCase(paramName))
                return spv;
        }
        return null;
    }
    /**
     * @return Returns the updater.
     */
    @Transient
    public UserAccountBean getUpdater() {
        UserAccountBean updater;
        UserAccountDAO udao;
        try {
                udao = new UserAccountDAO(SessionManager.getStaticDataSource());
                updater = (UserAccountBean) udao.findByPK(getUpdateId());
        } catch (Exception e) {
            updater = null;
        }
        return updater;
    }
    public void setUpdater(UserAccountBean updater){
        updateId = updater.getId();
    }

    @Transient
    public String getManager() {
        return CoreResources.getStudyManager();
    }

    @Transient
    public String getAbbreviatedParentStudyName() {
        String parentStudyName = getStudy().getName();
        if (parentStudyName != null && parentStudyName.length() > 30) {
            parentStudyName = parentStudyName.substring(0, 27) + "...";
        }
        return parentStudyName;
    }

    @Transient
    public String getAbbreviatedIdentifier() {
        String identifier = getUniqueIdentifier();
        if (identifier != null && identifier.length() > 25) {
            identifier = identifier.substring(0, 22) + "...";
        }
        return identifier;
    }
    @Transient
    public String getAbbreviatedName() {
        String name = getName();
        if (name != null && name.length() > 30) {
            name = name.substring(0, 27) + "...";
        }
        return name;
    }
    /**
     * @return Returns the collectDob.
     */
    @Transient
    public String getCollectDob() {
        return getIndividualStudyParameterValueOutput(StudyParamNames.COLLECT_DOB);
    }

    /**
     * @param collectDob
     *            The collectDob to set.
     */
    public void setCollectDob(String collectDob) {
        setIndividualStudyParameterValue(StudyParamNames.COLLECT_DOB, collectDob);
    }

    /**
     * @return Returns the discrepancyManagement.
     */
    @Transient
    public String getDiscrepancyManagement() {
        return getIndividualStudyParameterValueOutput(StudyParamNames.DISCREPANCY_MANAGEMENT);
    }

    /**
     * @param discrepancyManagement
     *            The discrepancyManagement to set.
     */
    public void setDiscrepancyManagement(String discrepancyManagement) {
        setIndividualStudyParameterValue(StudyParamNames.DISCREPANCY_MANAGEMENT, discrepancyManagement);
    }

    /**
     * @return Returns the genderRequired.
     */
    @Transient
    public String getGenderRequired() {
        return getIndividualStudyParameterValueOutput(StudyParamNames.GENDER_REQUIRED);
    }

    /**
     * @param genderRequired
     *            The genderRequired to set.
     */
    public void setGenderRequired(String genderRequired) {
        setIndividualStudyParameterValue(StudyParamNames.GENDER_REQUIRED, genderRequired);
    }

    /**
     * @return Returns the interviewDateDefault.
     */
    @Transient
    public String getInterviewDateDefault() {
        return getIndividualStudyParameterValueOutput(StudyParamNames.INTERVIEW_DATE_DEFAULT);
    }

    /**
     * @param interviewDateDefault
     *            The interviewDateDefault to set.
     */
    public void setInterviewDateDefault(String interviewDateDefault) {
        setIndividualStudyParameterValue(StudyParamNames.INTERVIEW_DATE_DEFAULT, interviewDateDefault);
    }

    /**
     * @return Returns the interviewDateEditable.
     */
    @Transient
    public String getInterviewDateEditable() {
        return getIndividualStudyParameterValueOutput(StudyParamNames.INTERVIEW_DATE_EDITABLE);
    }

    /**
     * @param interviewDateEditable
     *            The interviewDateEditable to set.
     */
    public void setInterviewDateEditable(String interviewDateEditable) {
        setIndividualStudyParameterValue(StudyParamNames.INTERVIEW_DATE_EDITABLE, interviewDateEditable);
    }

    /**
     * @return Returns the interviewDateRequired.
     */
    @Transient
    public String getInterviewDateRequired() {
        return getIndividualStudyParameterValueOutput(StudyParamNames.INTERVIEW_DATE_REQUIRED);
    }

    /**
     * @param interviewDateRequired
     *            The interviewDateRequired to set.
     */
    public void setInterviewDateRequired(String interviewDateRequired) {
        setIndividualStudyParameterValue(StudyParamNames.INTERVIEW_DATE_REQUIRED, interviewDateRequired);
    }

    /**
     * @return Returns the interviewerNameDefault.
     */
    @Transient
    public String getInterviewerNameDefault() {
        return getIndividualStudyParameterValueOutput(StudyParamNames.INTERVIEWER_NAME_DEFAULT);
    }

    /**
     * @param interviewerNameDefault
     *            The interviewerNameDefault to set.
     */
    public void setInterviewerNameDefault(String interviewerNameDefault) {
        setIndividualStudyParameterValue(StudyParamNames.INTERVIEWER_NAME_DEFAULT, interviewerNameDefault);
    }

    /**
     * @return Returns the interviewerNameEditable.
     */
    @Transient
    public String getInterviewerNameEditable() {
        return getIndividualStudyParameterValueOutput(StudyParamNames.INTERVIEWER_NAME_EDITABLE);
    }

    /**
     * @param interviewerNameEditable
     *            The interviewerNameEditable to set.
     */
    public void setInterviewerNameEditable(String interviewerNameEditable) {
        setIndividualStudyParameterValue(StudyParamNames.INTERVIEWER_NAME_EDITABLE, interviewerNameEditable);
    }

    /**
     * @return Returns the interviewerNameRequired.
     */
    @Transient
    public String getInterviewerNameRequired() {
        return getIndividualStudyParameterValueOutput(StudyParamNames.INTERVIEWER_NAME_REQUIRED);
    }

    /**
     * @param interviewerNameRequired
     *            The interviewerNameRequired to set.
     */
    public void setInterviewerNameRequired(String interviewerNameRequired) {
        setIndividualStudyParameterValue(StudyParamNames.INTERVIEWER_NAME_REQUIRED, interviewerNameRequired);
    }

    /**
     * @return Returns the subjectIdGeneration.
     */
    @Transient
    public String getSubjectIdGeneration() {
        return getIndividualStudyParameterValueOutput(StudyParamNames.SUBJECT_ID_GENERATION);
    }

    /**
     * @param subjectIdGeneration
     *            The subjectIdGeneration to set.
     */
    public void setSubjectIdGeneration(String subjectIdGeneration) {
        setIndividualStudyParameterValue(StudyParamNames.SUBJECT_ID_GENERATION, subjectIdGeneration);
    }

    /**
     * @return Returns the subjectIdPrefixSuffix.
     */
    @Transient
    public String getSubjectIdPrefixSuffix() {
        return getIndividualStudyParameterValueOutput(StudyParamNames.SUBJECT_ID_PREFIX_SUFFIX);
    }

    /**
     * @param subjectIdPrefixSuffix
     *            The subjectIdPrefixSuffix to set.
     */
    public void setSubjectIdPrefixSuffix(String subjectIdPrefixSuffix) {
        setIndividualStudyParameterValue(StudyParamNames.SUBJECT_ID_PREFIX_SUFFIX, subjectIdPrefixSuffix);
    }

    /**
     * @return Returns the subjectPersonIdRequired.
     */
    @Transient
    public String getSubjectPersonIdRequired() {
        return getIndividualStudyParameterValueOutput(StudyParamNames.SUBJECT_PERSON_ID_REQUIRED);
    }

    /**
     * @param subjectPersonIdRequired
     *            The subjectPersonIdRequired to set.
     */
    public void setSubjectPersonIdRequired(String subjectPersonIdRequired) {
        setIndividualStudyParameterValue(StudyParamNames.SUBJECT_PERSON_ID_REQUIRED, subjectPersonIdRequired);
    }

    /**
     * @return Returns the personIdShownOnCRF.
     */
    @Transient
    public String getPersonIdShownOnCRF() {
        return getIndividualStudyParameterValueOutput(StudyParamNames.PERSON_ID_SHOWN_ON_CRF);
    }

    /**
     * @param personIdShownOnCRF
     *            The personIdShownOnCRF to set.
     */
    public void setPersonIdShownOnCRF(String personIdShownOnCRF) {
        setIndividualStudyParameterValue(StudyParamNames.PERSON_ID_SHOWN_ON_CRF, personIdShownOnCRF);
    }

    @Transient
    public String getSecondaryLabelViewable() {
        return getIndividualStudyParameterValueOutput(StudyParamNames.SECONDARY_LABEL_VIEWABLE);
    }

    public void setSecondaryLabelViewable(String secondaryLabelViewable) {
        setIndividualStudyParameterValue(StudyParamNames.SECONDARY_LABEL_VIEWABLE, secondaryLabelViewable);
    }

    @Transient
    public String getAdminForcedReasonForChange() {
        return getIndividualStudyParameterValueOutput(StudyParamNames.ADMIN_FORCED_REASON_FOR_CHANGE);
    }

    public void setAdminForcedReasonForChange(String adminForcedReasonForChange) {
        setIndividualStudyParameterValue(StudyParamNames.ADMIN_FORCED_REASON_FOR_CHANGE, adminForcedReasonForChange);
    }

    @Transient
    public String getEventLocationRequired() {
        return getIndividualStudyParameterValueOutput(StudyParamNames.EVENT_LOCATION_REQUIRED);
    }

    public void setEventLocationRequired(String eventLocationRequired) {
        setIndividualStudyParameterValue(StudyParamNames.EVENT_LOCATION_REQUIRED, eventLocationRequired);
    }

    @Transient
    public String getEnforceEnrollmentCap() {
        return getIndividualStudyParameterValueOutput(StudyParamNames.ENFORCE_ENROLLMENT_CAP);
    }

    @Transient
    public String getParticipantIdTemplate() {
        return getIndividualStudyParameterValueOutput(StudyParamNames.PARTICIPANT_ID_TEMPLATE);
    }

    public void setEnforceEnrollmentCap(String enforceEnrollmentCap) {
        setIndividualStudyParameterValue(StudyParamNames.ENFORCE_ENROLLMENT_CAP, enforceEnrollmentCap);
    }
    public void setParticipantIdTemplate(String participantIdTemplate) {
        setIndividualStudyParameterValue(StudyParamNames.PARTICIPANT_ID_TEMPLATE, participantIdTemplate);
    }

    @Transient
    public String getContactsModule() {
        return getIndividualStudyParameterValueOutput(StudyParamNames.CONTACTS_MODULE);
    }

    public void setContactsModule(String contactsModule) {
        setIndividualStudyParameterValue(StudyParamNames.CONTACTS_MODULE, contactsModule);
    }

    @Transient
    public String getRandomization() {
        return getIndividualStudyParameterValueOutput(StudyParamNames.RANDOMIZATION);
    }

    public void setRandomization(String randomization) {
        setIndividualStudyParameterValue(StudyParamNames.RANDOMIZATION, randomization);
    }

    @Transient
    public String getParticipateStatus() {
        return getIndividualStudyParameterValueOutput(StudyParamNames.PARTICIPATE);
    }

    public void setParticipateStatus(ModuleStatus moduleStatus) {
        setIndividualStudyParameterValue(StudyParamNames.PARTICIPATE, moduleStatus.name());

    }

    @Transient
    public String getUuid() {
        return isSite() ? study.getStudyUuid() : studyUuid;
    }

    @Transient
    public String getEnvUuid() {
        return isSite() ? study.getStudyEnvUuid() : studyEnvUuid;
    }
}
