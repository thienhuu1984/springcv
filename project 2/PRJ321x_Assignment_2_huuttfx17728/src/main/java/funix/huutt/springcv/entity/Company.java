package funix.huutt.springcv.entity;

import funix.huutt.springcv.validation.IsNumber;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.springframework.lang.NonNull;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="company_name")
    @NotNull(message = "Tên công ty không được để trống")
    @Size(min = 1, message = "Tên công ty không được để trống")
    private String companyName;

    @Column(name="logo")
    private String logo;

    @Column (name="address")
    private String address;

    @Column(name="phone_number")
    @Pattern(regexp = "^[0-9]{10}", message = "Định dạng số điện thoại không đúng.")
    @IsNumber(message = "Định dạng số điện thoại phải là số")
    @NotNull(message = "Bạn phải nhập số điện thoại")
    @Size(min = 1, message = "Bạn phải nhập số điện thoại")
    private String phoneNumber;

    @Column(name="email")
    @Email(message = "Email bạn nhập sai định dạng.")
    @NotNull(message = "Email không được bỏ trống")
    @Size(min = 1,message = "Email không được bỏ trống")
    private String email;

    @Column(name="about")
    private String about;

    @Column(name="company_size")
    private Integer companySize;

    @Column(name="created_date")
    private Date createdDate;

    @Column(name="status")
    private Integer status;

    @OneToOne(cascade = {
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
            mappedBy = "company"
    )
    private List<Follow> follows;

    @ManyToMany (
            fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.PERSIST,
                    CascadeType.REFRESH
            })
    @JoinTable(
            name = "company_location",
            joinColumns = @JoinColumn(name = "company_id"),
            inverseJoinColumns = @JoinColumn(name = "location_id")
    )
    private List<Location> locations;

    @OneToMany(
            fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.PERSIST,
                    CascadeType.REFRESH
            },
            mappedBy = "company"
    )
    private List<Recruitment> recruitments;


    public Company() {
        this.status = 1;
        this.createdDate = new Date(System.currentTimeMillis());
    }

    public Company(String companyName, String address) {
        this.companyName = companyName;
        this.address = address;
        this.status = 1;
        this.createdDate = new Date(System.currentTimeMillis());
    }

    public Company(String companyName, String logo, String address, String phoneNumber, String email, String about, int companySize) {
        this.companyName = companyName;
        this.logo = logo;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.about = about;
        this.companySize = companySize;
        this.status = 1;
        this.createdDate = new Date(System.currentTimeMillis());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public int getCompanySize() {
        return companySize;
    }

    public void setCompanySize(int companySize) {
        this.companySize = companySize;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
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

    public void setLocations(List<Location> locations) {
        this.locations = locations;
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

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCompanySize(Integer companySize) {
        this.companySize = companySize;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<Follow> getFollows() {
        return follows;
    }

    public void setFollows(List<Follow> follows) {
        this.follows = follows;
    }

    public void add(Follow follow) {
        if(this.follows == null) this.follows = new ArrayList<>();
        this.follows.add(follow);
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}














