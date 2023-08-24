package funix.huutt.springcv.entity;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name="job_experience")
public class JobExperience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name="company_name")
    private String companyName;

    @Column(name = "salary")
    private String salary;

    @Column(name = "start_date")
    private Date startDate;

    @Column (name = "end_date")
    private Date endDate;

    @Column(name="still_work")
    private int stillWork;

    @Column(name="leave_reason")
    private String leaveReason;

    @ManyToOne(
            cascade = {
                    CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.PERSIST,
                    CascadeType.REFRESH
            })
    @JoinColumn(name = "online_cv_id")
    private OnlineCV onlineCV;

    public JobExperience() {
    }

    public JobExperience(String title, String companyName, String salary, Date startDate, Date endDate, int stillWork, String leaveReason) {
        this.title = title;
        this.companyName = companyName;
        this.salary = salary;
        this.startDate = startDate;
        this.endDate = endDate;
        this.stillWork = stillWork;
        this.leaveReason = leaveReason;
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

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
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

    public int getStillWork() {
        return stillWork;
    }

    public void setStillWork(int stillWork) {
        this.stillWork = stillWork;
    }

    public String getLeaveReason() {
        return leaveReason;
    }

    public void setLeaveReason(String leaveReason) {
        this.leaveReason = leaveReason;
    }

    public OnlineCV getOnlineCV() {
        return onlineCV;
    }

    public void setOnlineCV(OnlineCV onlineCV) {
        this.onlineCV = onlineCV;
    }

    @Override
    public String toString() {
        return "JobExperience{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", companyName='" + companyName + '\'' +
                ", salary='" + salary + '\'' +
                '}';
    }
}


/*

-- 18
CREATE TABLE `job_experience` (
	`id` INT(18) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `online_cv_id` INT(18) NOT NULL,
	`title` NVARCHAR(1000) NOT NULL,
	`company_name` NVARCHAR(1000) NOT NULL,
	`salary` NVARCHAR(1000) NOT NULL,
	`start_date` date DEFAULT NULL,
	`end_date` date DEFAULT NULL,
	`still_work` tinyint DEFAULT NULL,
	`leave_reason` NVARCHAR(1000) DEFAULT NULL
);
 */
















