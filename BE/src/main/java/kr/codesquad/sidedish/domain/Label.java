package kr.codesquad.sidedish.domain;

import org.springframework.data.annotation.Id;

public class Label {

    @Id
    private final Long labelId;
    private final String labelName;

    public Label(Long labelId, String labelName) {
        this.labelId = labelId;
        this.labelName = labelName;
    }

    public Long getLabelId() {
        return labelId;
    }

    public String getLabelName() {
        return labelName;
    }
}
