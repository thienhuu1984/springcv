package funix.huutt.springcv.entity;

import jakarta.persistence.*;

@Entity
@Table(name="status")
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="description")
    private String description;

    public Status() {
    }

    public Status(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Status{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}

/*

-- 4
CREATE TABLE `status` (
	`id` INT(18) PRIMARY KEY NOT NULL AUTO_INCREMENT,
	`description` NVARCHAR(1000)  NOT NULL
);

 */