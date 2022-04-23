package com.terria.sidedish.dto.auth;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import org.springframework.data.annotation.Id;

@Getter
public class GithubUser {

    @Id
    private long id;

    @JsonProperty("login")
    private String userId;

    @JsonProperty("email")
    private String email;

    @JsonProperty("name")
    private String name;

    private String provider;

    public void setProvider(String provider) {
        this.provider = provider;
    }

    @Override
    public String toString() {
        return "GithubUser{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", provider='" + provider + '\'' +
                '}';
    }
}
