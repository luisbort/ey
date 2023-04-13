package com.ey.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
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

    @OneToMany(mappedBy = "user", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    public List<Phone> phones;

    @Column(name = "datecreation", nullable = false, length = 50)
    public Date dateCreation;

    @Column(name = "dateupdate", nullable = false, length = 50)
    public Date dateUpdate;

    @Column(name = "datelastlogin", length = 50)
    public Date dateLastLogin;

    @Column(name = "isactive", nullable = false, length = 1)
    public String isActive;

    @Column(name = "tokensession", length = 200)
    public String tokenSession;

    @Column(name = "useruuid", length = 60)
    public String userUuid;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("User{");
        sb.append("userId=").append(userId);
        sb.append(", userName='").append(userName).append('\'');
        sb.append(", userMail='").append(userMail).append('\'');
        sb.append(", userPasswd='").append(userPasswd).append('\'');
        sb.append(", phones=").append(phones);
        sb.append(", dateCreation=").append(dateCreation);
        sb.append(", dateUpdate=").append(dateUpdate);
        sb.append(", dateLastLogin=").append(dateLastLogin);
        sb.append(", isActive='").append(isActive).append('\'');
        sb.append(", tokenSession='").append(tokenSession).append('\'');
        sb.append(", userUuid='").append(userUuid).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
