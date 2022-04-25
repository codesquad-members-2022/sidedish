package kr.codesquad.sidedish.domain;

import org.springframework.data.annotation.Id;

public class BestType {

    @Id
    private final Long bestId;
    private final String bestName;

    public BestType(Long bestId, String bestName) {
        this.bestId = bestId;
        this.bestName = bestName;
    }
}
