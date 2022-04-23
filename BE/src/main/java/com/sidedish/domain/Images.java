package com.sidedish.domain;

import lombok.Getter;

@Getter
public class Images {
    private String mainUrl;
    private String sideOne;
    private String sideTwo;

    public Images(String mainUrl, String sideOne, String sideTwo) {
        this.mainUrl = mainUrl;
        this.sideOne = sideOne;
        this.sideTwo = sideTwo;
    }
}
