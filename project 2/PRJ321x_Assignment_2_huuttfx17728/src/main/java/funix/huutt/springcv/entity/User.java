package funix.huutt.springcv.entity;

import funix.huutt.springcv.validation.IsNumber;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="user")
public class User {

    @Id
    @Column(name="email")
    @Email(message = "Email bạn nhập thiếu '@'.")
    @NotNull(message = "Email không được bỏ trống")
    @Size(min = 1,message = "Email không được bỏ trống")
    private String email;

    @Column(name="password")
    private String password;

    @Column(name="full_name")
    @NotNull(message = "Xin vui lòng điền tên đầy đủ.")
    @Size(min = 2, message = "Xin vui lòng điền tên đầy đủ.")
    private String fullName;

    @Column(name="address")
    private String address;

    @Column(name="phone_number")
    @Pattern(regexp = "^[0-9]{10}", message = "Định dạng số điện thoại không đúng.")
    @NotNull(message = "Bạn phải nhập số điện thoại")
    @IsNumber(message = "Định dạng số điện thoại phải là số")
    @Size(min = 1, message = "Bạn phải nhập số điện thoại")
    private String phoneNumber;

    @Column(name="image")
    private String image;

    @Column(name="about")
    private String about;

    @Column(name="create_date")
    private Date createDate;

    @Column(name="status")
    private Integer status;

    @ManyToOne(
            cascade = {
                    CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.PERSIST,
                    CascadeType.REFRESH
            })
    @JoinColumn(name = "role_id")
    private Role role;

    @OneToMany(
            fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.PERSIST,
                    CascadeType.REFRESH
            },
            mappedBy = "user"
    )
    private List<CV> cvs;

    @ManyToMany (
            fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.PERSIST,
                    CascadeType.REFRESH
            })
    @JoinTable(
            name = "follow_company",
            joinColumns = @JoinColumn(name = "username"),
            inverseJoinColumns = @JoinColumn(name = "company_id")
    )
    private List<Company> following;

    @OneToMany(
            fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.PERSIST,
                    CascadeType.REFRESH
            },
            mappedBy = "user"
    )
    private List<JobApply> jobApplies;



    @OneToMany(
            fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.PERSIST,
                    CascadeType.REFRESH
            },
            mappedBy = "user"
    )
    private List<OnlineCV> onlineCVs;

    public User() {
        this.status = 1;
        this.createDate = new Date(System.currentTimeMillis());
    }

    public User(String email, String fullName) {
        this.email = email;
        this.fullName = fullName;

        this.status = 1;
        this.createDate = new Date(System.currentTimeMillis());
    }

    public User(String email, String password, String fullName, String address, String phoneNumber,  String image, String about) {
        this.password = this.encodingPassword(password);
        this.fullName = fullName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.image = image;
        this.about = about;
        this.status = 1;
        this.createDate = new Date(System.currentTimeMillis());
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {

        this.password = this.encodingPassword(password);
        System.out.println(this.password);
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<CV> getCvs() {
        return cvs;
    }

    public void setCvs(List<CV> cvs) {
        this.cvs = cvs;
    }

    public void add(CV cv) {

        if(this.cvs == null) {
            cvs = new ArrayList<>();
        }

        this.cvs.add(cv);
    }

    public List<OnlineCV> getOnlineCVs() {
        return onlineCVs;
    }

    public void setOnlineCVs(List<OnlineCV> onlineCVs) {
        this.onlineCVs = onlineCVs;
    }

    public void add(OnlineCV onlineCV) {

        if(this.onlineCVs == null) {
            this.onlineCVs = new ArrayList<>();
        }

        this.onlineCVs.add(onlineCV);
    }

    public List<Company> getFollowing() {
        return following;
    }

    public void setFollowing(List<Company> following) {
        this.following = following;
    }

    public void add(Company company) {
        if(this.following == null) {
            this.following = new ArrayList<>();
        }
        this.following.add(company);
    }

    public List<JobApply> getJobApplieds() {
        return jobApplies;
    }

    public void setJobApplieds(List<JobApply> jobApplies) {
        this.jobApplies = jobApplies;
    }

    public void add(JobApply jobApply) {

        if(this.jobApplies == null) this.jobApplies = new ArrayList<>();

        this.jobApplies.add(jobApply);

    }

    private String encodingPassword(String password) {

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        return "{bcrypt}" + encoder.encode(password);
//        return password;

    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", fullName='" + fullName + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}



















