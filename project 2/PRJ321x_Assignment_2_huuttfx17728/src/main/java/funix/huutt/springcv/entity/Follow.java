package funix.huutt.springcv.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "follow")
public class Follow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "is_user_follow")
    private int isUserFollow;

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
    @JoinColumn(name = "company_id")
    private Company company;

    public Follow() {
    }

    public Follow(Integer id, User user, Company company, boolean isUserFollow) {
        this.id = id;
        this.isUserFollow = isUserFollow?1:0;
        this.user = user;
        this.company = company;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getIsUserFollow() {
        return isUserFollow;
    }

    public void setIsUserFollow(int isUserFollow) {
        this.isUserFollow = isUserFollow;
    }

    public boolean isUserFollow() {
        return this.isUserFollow == 1;
    }

    public boolean isCompanyFollow() {
        return this.isUserFollow == 0;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}

/*
-- 9
CREATE TABLE `follow` (
	`id` INT(18) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `username` VARCHAR(255) NOT NULL,
    `company_id` INT(18) NOT NULL,
    `is_user_follow` TINYINT
);

 */