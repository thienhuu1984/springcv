package funix.huutt.springcv.entity;

import jakarta.persistence.*;

@Entity
@Table(name="job_portfolio")
public class JobPortfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="project_name")
    private String projectName;

    @Column(name = "project_size")
    private int projectSize;

    @Column(name="description")
    private String description;

    @Column(name="image")
    private String image;

    @ManyToOne(
            cascade = {
                    CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.PERSIST,
                    CascadeType.REFRESH
            })
    @JoinColumn(name = "online_cv_id")
    private OnlineCV onlineCV;

    public JobPortfolio() {
    }

    public JobPortfolio(String projectName, int projectSize) {
        this.projectName = projectName;
        this.projectSize = projectSize;
    }

    public JobPortfolio(String projectName, int projectSize, String description) {
        this.projectName = projectName;
        this.projectSize = projectSize;
        this.description = description;
    }

    public JobPortfolio(String projectName, int projectSize, String description, String image) {
        this.projectName = projectName;
        this.projectSize = projectSize;
        this.description = description;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public int getProjectSize() {
        return projectSize;
    }

    public void setProjectSize(int projectSize) {
        this.projectSize = projectSize;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public OnlineCV getOnlineCV() {
        return onlineCV;
    }

    public void setOnlineCV(OnlineCV onlineCV) {
        this.onlineCV = onlineCV;
    }

    @Override
    public String toString() {
        return "jobPortfolio{" +
                "id=" + id +
                ", projectName='" + projectName + '\'' +
                ", projectSize=" + projectSize +
                ", description='" + description + '\'' +
                '}';
    }
}

/*

-- 19
CREATE TABLE `job_portfolio` (
	`id` INT(18) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `online_cv_id` INT(18) NOT NULL,
	`project_name` NVARCHAR(1000) NOT NULL,
	`project_size` INT(18) DEFAULT NULL,
	`description` NVARCHAR(1000) DEFAULT NULL,
	`image` varchar(255) DEFAULT NULL
);
 */