package com.example.be.common.token.github;

import com.example.be.business.user.domain.Bio;

import java.util.Map;

public class GithubUser {

    private static final String ID = "id";
    private static final String EMAIL = "email";
    private static final String NAME = "name";
    private static final String AVATAR_URL = "avatar_url";
    private static final String BIO = "bio";
    private static final String LOCATION = "location";
    private static final String HTML_URL = "html_url";
    private static final String GITHUB_ID = "githubId";
    private static final String USERDETAIL_DELIMETER = "/";
    private static final char KEY_DELIMETER = '"';

    private Long id;
    private final String email;
    private final String name;
    private final String avatarUrl;
    private final Bio bio;
    private final String location;
    private final String githubId;

    public GithubUser(Long id, String email, String name, String avatarUrl, Bio bio, String location, String githubId) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.avatarUrl = avatarUrl;
        this.bio = bio;
        this.location = location;
        this.githubId = githubId;
    }

    public static GithubUser from(Map<String, String> userDetail) {
        Long id = Long.parseLong(getAttribute(userDetail, ID));
        String email = getAttribute(userDetail, EMAIL);
        String name = getAttribute(userDetail, NAME).replaceAll("'\"'", "");
        Bio bio = Bio.valueOf(getAttribute(userDetail, BIO));
        String avatarUrl = getAttribute(userDetail, AVATAR_URL);
        String location = getAttribute(userDetail, LOCATION);
        String githubId = saveGithubId(userDetail);
        return new GithubUser(id, email, name, avatarUrl, bio, location, githubId);
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

    private static String saveGithubId(Map<String, String> userDetail) {
        String key = KEY_DELIMETER + HTML_URL + KEY_DELIMETER;
        String[] parsing = userDetail.get(key).split(USERDETAIL_DELIMETER);
        String id = parsing[parsing.length - 1];
        userDetail.put(GITHUB_ID, id);
        return parsing[parsing.length - 1];
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

    public String getGithubId() {
        return githubId;
    }
}
