package funix.huutt.springcv.view;

import funix.huutt.springcv.entity.User;
import funix.huutt.springcv.validation.IsDuplicating;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@IsDuplicating(
        value="password",
        fieldMatch = "rePassword",
        message = "Mật khẩu không giống nhau."
)
public class Registering {

    @NotNull(message = "Bạn phải nhập trường này.")
    @Size(min = 1, message = "Bạn phải nhập trường này.")
    @Email(message = "Email bạn nhập không đúng định dạng.")
    private String email;

    @NotNull(message = "Bạn phải nhập trường này.")
    @Size(min = 1, message = "Bạn phải nhập trường này.")
    private String fullName;

    @NotNull(message = "Bạn phải nhập trường này.")
    @Size(min = 1, message = "Bạn phải nhập trường này.")
    private String password;

    @NotNull(message = "Bạn phải nhập trường này.")
    @Size(min = 1, message = "Bạn phải nhập trường này.")
    private String rePassword;

    @Min(value=2, message = "Vui lòng chọn chức năng!")
    private int roleId;

    public Registering() {
    }

    public Registering(String email, String fullName, String password, String rePassword) {
        this.email = email;
        this.fullName = fullName;
        this.password = password;
        this.rePassword = rePassword;
    }

    public Registering(String email, String fullName, String password, String rePassword, int roleId) {
        this.email = email;
        this.fullName = fullName;
        this.password = password;
        this.rePassword = rePassword;
        this.roleId = roleId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;

    }

    public String getRePassword() {
        return rePassword;
    }

    public void setRePassword(String rePassword) {
        this.rePassword = rePassword;

    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }


    @Override
    public String toString() {
        return "Registering{" +
                "\n email='" + email + '\'' +
                ",\n fullName='" + fullName + '\'' +
                ",\n password='" + password + '\'' +
                ",\n rePassword='" + rePassword + '\'' +
                ",\n roleId=" + roleId +
                '}';
    }
}
