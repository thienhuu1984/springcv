package funix.huutt.springcv.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="job_type")
public class JobType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="name")
    private String name;

    @Column(name="description")
    private String description;

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
            joinColumns = @JoinColumn(name = "job_type_id"),
            inverseJoinColumns = @JoinColumn(name = "recruitment_id")
    )
    private List<Recruitment> recruitments;

    public JobType() {
    }

    public JobType(String name) {
        this.name = name;
    }

    public JobType(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Recruitment> getRecruitments() {
        return recruitments;
    }

    public void setRecruitments(List<Recruitment> recruitments) {
        this.recruitments = recruitments;
    }

    public void add(Recruitment recruitment) {
        if(this.recruitments == null) {
            this.recruitments = new ArrayList<>();
        }
        this.recruitments.add(recruitment);
    }

    @Override
    public String toString() {
        return "JopType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

/*

-- 8
CREATE TABLE `job_type` (
	`id` INT(18) PRIMARY KEY NOT NULL AUTO_INCREMENT,
	`name` NVARCHAR(1000) NOT NULL,
	`description` NVARCHAR(1000)  DEFAULT NULL
);

 */



