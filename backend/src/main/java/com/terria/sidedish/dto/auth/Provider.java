package com.terria.sidedish.dto.auth;

import java.util.Arrays;

public enum Provider {

    GITHUB("GitHub.com"),
    UNKNOWN("Unknown");

    final String server;

    Provider(String server) {
        this.server = server;
    }

    public static String of(String server) {
        return Arrays.stream(Provider.values())
                .filter(provider -> provider.server.equals(server))
                .findFirst()
                .orElse(UNKNOWN).server;
    }

    @Override
    public String toString() {
        return "Provider{" +
                "server='" + server + '\'' +
                '}';
    }
}
