package kr.codesquad.sidedish.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;

@Getter
@RequiredArgsConstructor
public class Theme {

    @Id
    private Long id;
    private final String name;

}
