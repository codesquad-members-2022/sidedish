package kr.codesquad.sidedish.domain;

import org.springframework.data.annotation.Id;

public class BestType {

    @Id
    private final Long best_id;
    private final String best_name;

    public BestType(Long best_id, String best_name) {
        this.best_id = best_id;
        this.best_name = best_name;
    }

    public Long getBest_id() {
        return best_id;
    }

    public String getBest_name() {
        return best_name;
    }
}
