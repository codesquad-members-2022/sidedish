package kr.codesquad.sidedish.domain;

import lombok.Getter;
import org.springframework.data.annotation.Id;

@Getter
public class Subcategory {

    @Id
    Long id;
    String name;
}
