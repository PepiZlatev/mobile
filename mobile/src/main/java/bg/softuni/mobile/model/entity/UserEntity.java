package bg.softuni.mobile.model.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity{

    @Column(name = "user_name", nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "is_active", nullable = false)
    private boolean isActive;

    @Column(name = "image_url", nullable = false)
    private String imageURL;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<UserRoleEntity> userRoleEntities = new ArrayList<>();


    public String getUsername() {
        return username;
    }

    public UserEntity setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserEntity setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public UserEntity setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserEntity setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public boolean isActive() {
        return isActive;
    }

    public UserEntity setActive(boolean active) {
        isActive = active;
        return this;
    }

    public List<UserRoleEntity> getUserRoles() {
        return userRoleEntities;
    }

    public UserEntity setUserRoles(List<UserRoleEntity> userRoleEntities) {
        this.userRoleEntities = userRoleEntities;
        return this;
    }

    public String getImageURL() {
        return imageURL;
    }

    public UserEntity setImageURL(String imageURL) {
        this.imageURL = imageURL;
        return this;
    }
}
