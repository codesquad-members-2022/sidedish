package kr.codesquad.sidedish.domain;

import org.springframework.data.annotation.Id;

public class Label {

    @Id
    private final Long label_id;
    private final String label_name;

    public Label(Long label_id, String label_name) {
        this.label_id = label_id;
        this.label_name = label_name;
    }

    public Long getLabel_id() {
        return label_id;
    }

    public String getLabel_name() {
        return label_name;
    }
}
