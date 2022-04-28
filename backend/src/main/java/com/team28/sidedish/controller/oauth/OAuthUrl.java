package com.team28.sidedish.controller.oauth;

import com.team28.sidedish.exception.URISyntaxException;

import java.util.ArrayList;
import java.util.List;

public class OAuthUrl {

    public static OAuthUrlBuilder builder() {
        return new OAuthUrlBuilder();
    }

    public static class OAuthUrlBuilder {
        private String baseUrl;
        private boolean isClientIdSet = false;
        private boolean isRedirectUriSet = false;
        private final List<String> params = new ArrayList<>();

        public OAuthUrlBuilder baseUrl(String baseUrl) {
            this.baseUrl = baseUrl;
            return this;
        }

        public OAuthUrlBuilder client_id(String client_id) {
            isClientIdSet = true;
            params.add("client_id=" + client_id);
            return this;
        }

        public OAuthUrlBuilder redirect_uri(String redirect_uri) {
            isRedirectUriSet = true;
            params.add("redirect_uri=" + redirect_uri);
            return this;
        }

        public OAuthUrlBuilder scope(String scope) {
            params.add("scope=" + scope);
            return this;
        }

        public OAuthUrlBuilder response_type(String response_type) {
            params.add("response_type=" + response_type);
            return this;
        }

        public String build() {
            if (isBaseUrlEmpty(this.baseUrl) || !isClientIdSet || !isRedirectUriSet) {
                throw new URISyntaxException();
            }

            String queryString = params.stream()
                    .reduce((nested, element) -> nested + "&" + element)
                    .orElse("");

            return baseUrl + "?" + queryString;
        }

        private boolean isBaseUrlEmpty(String baseUrl) {
            return baseUrl == null || baseUrl.isEmpty();
        }
    }

}
