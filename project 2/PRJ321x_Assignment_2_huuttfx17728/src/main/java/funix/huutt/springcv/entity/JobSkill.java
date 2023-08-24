package funix.huutt.springcv.entity;

import jakarta.persistence.*;

@Entity
@Table(name="job_skill")
public class JobSkill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="technical_skill")
    private String technicalSkill;

    @Column(name="soft_skill")
    private String softSkill;

    @OneToOne(cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH
    })
    @JoinColumn(name = "online_cv_id")
    private OnlineCV onlineCV;

    public JobSkill() {
    }

    public JobSkill(String technicalSkill, String softSkill) {
        this.technicalSkill = technicalSkill;
        this.softSkill = softSkill;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTechnicalSkill() {
        return technicalSkill;
    }

    public void setTechnicalSkill(String technicalSkill) {
        this.technicalSkill = technicalSkill;
    }

    public String getSoftSkill() {
        return softSkill;
    }

    public void setSoftSkill(String softSkill) {
        this.softSkill = softSkill;
    }

    public OnlineCV getOnlineCV() {
        return onlineCV;
    }

    public void setOnlineCV(OnlineCV onlineCV) {
        this.onlineCV = onlineCV;
    }

    @Override
    public String toString() {
        return "JobSkill{" +
                "id=" + id +
                ", technicalSkill='" + technicalSkill + '\'' +
                ", softSkill='" + softSkill + '\'' +
                '}';
    }
}

/*

-- 20
CREATE TABLE `job_skill` (
	`id` INT(18) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `online_cv_id` INT(18) NOT NULL,
	`technical_skill`  NVARCHAR(1000) DEFAULT NULL,
	`soft_skill`  NVARCHAR(1000) DEFAULT NULL

);
 */