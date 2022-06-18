package bg.softuni.mobile.model.entity;


import bg.softuni.mobile.model.entity.enums.Role;

import javax.persistence.*;

@Entity
@Table(name = "user_roles")
public class UserRoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Role role;

    public Long getId() {
        return id;
    }

    public UserRoleEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public Role getRole() {
        return role;
    }

    public UserRoleEntity setRole(Role role) {
        this.role = role;
        return this;
    }
}
