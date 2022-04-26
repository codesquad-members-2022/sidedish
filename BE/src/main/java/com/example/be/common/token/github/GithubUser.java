package com.example.be.common.token.github;

import com.example.be.domain.user.Bio;

import java.util.Map;

public class GithubUser {

    private static final String ID = "id";
    private static final String EMAIL = "email";
    private static final String NAME = "name";
    private static final String AVATAR_URL = "avatar_url";
    private static final String BIO = "bio";
    private static final String LOCATION = "location";
    private static final char KEY_DELIMETER = '"';

    private Long id;
    private final String email;
    private final String name;
    private final String avatarUrl;
    private final Bio bio;
    private final String location;

    public GithubUser(Long id, String email, String name, String avatarUrl, Bio bio, String location) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.avatarUrl = avatarUrl;
        this.bio = bio;
        this.location = location;
    }

    public static GithubUser from(Map<String, String> userDetail) {
        Long id = Long.parseLong(getAttribute(userDetail, ID));
        String email = getAttribute(userDetail, EMAIL);
        String name = getAttribute(userDetail, NAME);
        Bio bio = Bio.valueOf(getAttribute(userDetail, BIO));
        String avatarUrl = getAttribute(userDetail, AVATAR_URL);
        String location = getAttribute(userDetail, LOCATION);
        return new GithubUser(id, email, name, avatarUrl, bio, location);
    }

    // TODO if문 중첩 개선
    public static String getAttribute(Map<String, String> userDetail, String attribute) {
        if (attribute.equals(BIO)) {
            if (userDetail.get(BIO) == null) {
                return Bio.NOT_REGISTERED.name();
            }
        }
        String key = KEY_DELIMETER + attribute + KEY_DELIMETER;
        return userDetail.get(key);
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public Bio getBio() {
        return bio;
    }

    public String getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return "GithubUser{" +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", avatarUrl='" + avatarUrl + '\'' +
                ", bio=" + bio +
                ", location='" + location + '\'' +
                '}';
    }
}
