package com.ey.domain.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    public Integer userId;

    @JsonProperty(value = "name", required = true)
    //@NotBlank(message = "no acepta valores nulos")
    @NotNull
    private String userName;

    @JsonProperty("email")
    private String userMail;

    @JsonProperty("password")
    private String userPasswd;

    @JsonProperty("phones")
    private List<PhoneDTO> phones;

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