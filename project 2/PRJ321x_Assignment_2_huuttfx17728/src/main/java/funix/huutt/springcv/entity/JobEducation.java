package funix.huutt.springcv.entity;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name="job_education")
public class JobEducation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="major")
    private String major;

    @Column(name="school_name")
    private String schoolName;

    @Column(name="start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @Column(name="description")
    private String description;

    @ManyToOne(
            cascade = {
                    CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.PERSIST,
                    CascadeType.REFRESH
            })
    @JoinColumn(name = "online_cv_id")
    private OnlineCV onlineCV;

    public JobEducation() {
    }

    public JobEducation(String major, String schoolName, Date startDate, Date endDate, String description) {
        this.major = major;
        this.schoolName = schoolName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public OnlineCV getOnlineCV() {
        return onlineCV;
    }

    public void setOnlineCV(OnlineCV onlineCV) {
        this.onlineCV = onlineCV;
    }
}

/*

-- 17
CREATE TABLE `job_education` (
	`id` INT(18) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `online_cv_id` INT(18) NOT NULL,
	`major` NVARCHAR(1000) NOT NULL,
	`school_name` NVARCHAR(1000) NOT NULL,
	`start_date` date DEFAULT NULL,
	`end_date` date DEFAULT NULL,
	`description` NVARCHAR(1000) DEFAULT NULL
);

 */