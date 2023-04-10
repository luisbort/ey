package com.ey.model.dtos;

import com.ey.util.ValidationUtil;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    @JsonIgnore
    public Integer userId;

    @JsonProperty(value = "name", required = true)
    @NotNull
    private String userName;

    @JsonProperty("email")
    @NotNull
    @Email(regexp = ValidationUtil.EMAIL_PATTERN)
    private String userMail;

    @JsonProperty("password")
    @NotNull
    @Pattern(regexp = ValidationUtil.PASSWD_PATTERN)
    private String userPasswd;

    @JsonProperty("phones")
    private List<PhoneDTO> phones;

    public Date dateCreation;

    public Date dateUpdate;

    public Date dateLastLogin;

    public String isActive;

    public String tokenSession;

    public String userUuid;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UserDTO{");
        sb.append("userName='").append(userName).append('\'');
        sb.append(", userMail='").append(userMail).append('\'');
        sb.append(", userPasswd='").append(userPasswd).append('\'');
        sb.append(", phones=").append(phones);
        sb.append('}');
        return sb.toString();
    }
}
