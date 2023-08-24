package funix.huutt.springcv.entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="recruitment")
public class Recruitment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name="job_title")
    private String jobTitle;

    @Column(name="job_description")
    private String jobDescription;

    @Column(name="job_requirement")
    private String jobRequirement;

    @Column(name="created_date")
    private Date createdDate;

    @Column(name="modified_date")
    private Date modifiedDate;

    @Column(name="expired_date")
    private Date expiredDate;

    @Column(name="status")
    private int status;

    @ManyToOne(
            cascade = {
                    CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.PERSIST,
                    CascadeType.REFRESH
            })
    @JoinColumn(name = "company_id")
    private Company company;

    @ManyToMany (
            fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.PERSIST,
                    CascadeType.REFRESH
            })
    @JoinTable(
            name = "recruitment_location",
            joinColumns = @JoinColumn(name = "recruitment_id"),
            inverseJoinColumns = @JoinColumn(name = "location_id")
    )
    private List<Location> locations;

    @ManyToMany (
            fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.PERSIST,
                    CascadeType.REFRESH
            })
    @JoinTable(
            name = "recruitment_category",
            joinColumns = @JoinColumn(name = "recruitment_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private List<Category> categories;

    @ManyToMany (
            fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.PERSIST,
                    CascadeType.REFRESH
            })
    @JoinTable(
            name = "recruitment_type",
            joinColumns = @JoinColumn(name = "recruitment_id"),
            inverseJoinColumns = @JoinColumn(name = "job_type_id")
    )
    private List<JobType> jobTypes;

    @OneToMany(
            fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.PERSIST,
                    CascadeType.REFRESH
            },
            mappedBy = "recruitment"
    )
    private List<JobApply> jobApplies;

    public Recruitment() {
        this.status = 1;
        this.createdDate = new Date(System.currentTimeMillis());
    }

    public Recruitment(String jobTitle, String jobDescription, String jobRequirement) {
        this.jobTitle = jobTitle;
        this.jobDescription = jobDescription;
        this.jobRequirement = jobRequirement;
        this.status = 1;
        this.createdDate = new Date(System.currentTimeMillis());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public String getJobRequirement() {
        return jobRequirement;
    }

    public void setJobRequirement(String jobRequirement) {
        this.jobRequirement = jobRequirement;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public Date getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(Date expiredDate) {
        this.expiredDate = expiredDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public void add(Location location) {

        if(this.locations == null) {
            this.locations = new ArrayList<>();
        }

        this.locations.add(location);
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

    public List<JobType> getJopTypes() {
        return jobTypes;
    }

    public void setJopTypes(List<JobType> jobTypes) {
        this.jobTypes = jobTypes;
    }

    public void add(JobType jobType) {
        if(this.jobTypes == null) {
            this.jobTypes = new ArrayList<>();
        }
        this.jobTypes.add(jobType);
    }

    public void add(JobApply jobApply) {

        if(this.jobApplies == null) this.jobApplies = new ArrayList<>();

        this.jobApplies.add(jobApply);

    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public void add(Category category) {
        if(this.categories == null) this.categories = new ArrayList<>();
        this.categories.add(category);
    }

    public List<JobType> getJobTypes() {
        return jobTypes;
    }

    public void setJobTypes(List<JobType> jobTypes) {
        this.jobTypes = jobTypes;
    }


    public List<JobApply> getJobApplies() {
        return jobApplies;
    }

    public void setJobApplies(List<JobApply> jobApplies) {
        this.jobApplies = jobApplies;
    }

    @Override
    public String toString() {
        return "Recruitment{" +
                "jobTitle='" + jobTitle + '\'' +
                ", jobDescription='" + jobDescription + '\'' +
                ", jobRequirement='" + jobRequirement + '\'' +
                '}';
    }
}

/*

-- 6
CREATE TABLE `recruitment` (
	`id` INT(18) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `company_id` INT(18) NOT NULL,
    `job_title`  NVARCHAR(1000) NOT NULL,
	`job_description` NVARCHAR(1000) DEFAULT NULL,
	`job_requirement` NVARCHAR(1000) DEFAULT NULL,
	`created_date` datetime DEFAULT NULL,
	`modified_date` datetime DEFAULT NULL,
	`expired_date` datetime DEFAULT NULL,
	`status` INT(18) DEFAULT NULL
);
 */
