package com.ey.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(schema = "EYSCHEMA", name = "TBL_USERS")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @Column(name = "userid", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer userId;

    @Column(name = "username", nullable = false, length = 50)
    public String userName;

    @Column(name = "usermail", nullable = false, length = 50)
    public String userMail;

    @Column(name = "userpasswd", nullable = false, length = 50)
    public String userPasswd;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    public List<Phone> phones;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("User{");
        sb.append("userId=").append(userId);
        sb.append(", userName='").append(userName).append('\'');
        sb.append(", userMail='").append(userMail).append('\'');
        sb.append(", userPasswd='").append(userPasswd).append('\'');
        sb.append(", phones=").append(phones);
        sb.append('}');
        return sb.toString();
    }
}
