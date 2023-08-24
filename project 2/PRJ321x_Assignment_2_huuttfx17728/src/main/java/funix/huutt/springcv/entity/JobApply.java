package funix.huutt.springcv.entity;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name="job_apply")
public class JobApply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private String id;

    @ManyToOne(
            cascade = {
                    CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.PERSIST,
                    CascadeType.REFRESH
            })
    @JoinColumn(name = "username")
    private User user;

    @ManyToOne(
            cascade = {
                    CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.PERSIST,
                    CascadeType.REFRESH
            })
    @JoinColumn(name = "recruitment_id")
    private Recruitment recruitment;

    @Column(name = "cover_letter")
    private String coverLetter;

    public JobApply() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Recruitment getRecruitment() {
        return recruitment;
    }

    public void setRecruitment(Recruitment recruitment) {
        this.recruitment = recruitment;
    }

    public String getCoverLetter() {
        return coverLetter;
    }

    public void setCoverLetter(String coverLetter) {
        this.coverLetter = coverLetter;
    }


}

/*

-- 14
CREATE TABLE `job_apply` (
	`id` INT(18) PRIMARY KEY NOT NULL AUTO_INCREMENT,
	`username` VARCHAR(255) NOT NULL,
	`recruitment_id`  INT(18) NOT NULL,
    `cover_letter` NVARCHAR(1000) NOT NULL

);
 */