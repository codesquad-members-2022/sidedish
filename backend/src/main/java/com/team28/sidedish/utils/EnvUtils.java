package com.team28.sidedish.utils;

public class EnvUtils {

    private static final String ENV_GITHUB_CLIENT_ID = "CLIENT_ID";
    private static final String ENV_GITHUb_SECRET_CODE = "API_SECRET_CODE";
    private static final String ENV_REDIRECT_URI = "REDIRECT_URI";
    private static final String ENV_JWT_SECRET_CODE = "JWT_SECRET_CODE";

    public static String getClientId() {
        return System.getenv(ENV_GITHUB_CLIENT_ID);
    }

    public static String getSecretCode() {
        return System.getenv(ENV_GITHUb_SECRET_CODE);
    }

    public static String getRedirectUri() {
        return System.getenv(ENV_REDIRECT_URI);
    }

    public static String getJwtSecret() {
        return System.getenv(ENV_JWT_SECRET_CODE);
    }
}
