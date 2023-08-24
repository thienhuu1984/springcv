package funix.huutt.springcv.entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="online_cv")
public class OnlineCV {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="title")
    private String title;

    @Column(name = "created_date")
    private Date createdDate;

    @Column(name="modified_date")
    private Date modifiedDate;

    @Column(name="status")
    private Integer status;

    @ManyToOne(
            cascade = {
                    CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.PERSIST,
                    CascadeType.REFRESH
            })
    @JoinColumn(name = "username")
    private User user;

    @OneToMany(
            fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.PERSIST,
                    CascadeType.REFRESH
            },
            mappedBy = "onlineCV"
    )
    private List<JobExperience> jobExperiences;

    @OneToMany(
            fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.PERSIST,
                    CascadeType.REFRESH
            },
            mappedBy = "onlineCV"
    )
    private List<JobEducation> jobEducations;

    @OneToOne(
            mappedBy = "onlineCV",
            cascade = {
                CascadeType.DETACH,
                CascadeType.MERGE,
                CascadeType.PERSIST,
                CascadeType.REFRESH
    })
    private JobSkill jobSkill;

    @OneToMany(
            fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.PERSIST,
                    CascadeType.REFRESH
            },
            mappedBy = "onlineCV"
    )
    private List<JobPortfolio> jobPortfolios;

    public OnlineCV() {
        this.status = 1;
        this.createdDate = this.modifiedDate = new Date(System.currentTimeMillis());
    }

    public OnlineCV(String title) {
        this.title = title;
        this.status = 1;
        this.createdDate = this.modifiedDate = new Date(System.currentTimeMillis());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<JobExperience> getJobExperiences() {
        return jobExperiences;
    }

    public void setJobExperiences(List<JobExperience> jobExperiences) {
        this.jobExperiences = jobExperiences;
    }

    public void add(JobExperience jobExperience) {
        if(this.jobExperiences == null) {
            this.jobExperiences = new ArrayList<>();
        }
        this.jobExperiences.add(jobExperience);
    }

    public List<JobEducation> getJobEducations() {
        return jobEducations;
    }

    public void setJobEducations(List<JobEducation> jobEducations) {
        this.jobEducations = jobEducations;
    }

    public void add(JobEducation jobEducation) {
        if(this.jobEducations == null) {
            this.jobEducations = new ArrayList<>();
        }
        this.jobEducations.add(jobEducation);
    }

    public JobSkill getJobSkill() {
        return jobSkill;
    }

    public void setJobSkill(JobSkill jobSkill) {
        this.jobSkill = jobSkill;
    }

    public List<JobPortfolio> getJobPortfolios() {
        return jobPortfolios;
    }

    public void setJobPortfolios(List<JobPortfolio> jobPortfolios) {
        this.jobPortfolios = jobPortfolios;
    }

    public void add(JobPortfolio jobPortfolio) {
        if(this.jobPortfolios == null) {
            this.jobPortfolios = new ArrayList<>();
        }

        this.jobPortfolios.add(jobPortfolio);
    }

    @Override
    public String toString() {
        return "OnlineCV{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", createdDate=" + createdDate +
                '}';
    }
}

/*

-- 16
CREATE TABLE `online_cv` (
	`id` INT(18) PRIMARY KEY NOT NULL AUTO_INCREMENT,
	`title` NVARCHAR(1000) NOT NULL,
	`username` VARCHAR(255) NOT NULL,
	`created_date` datetime DEFAULT NULL,
	`modified_date` datetime DEFAULT NULL,
	`status` INT(18) DEFAULT NULL

);

 */