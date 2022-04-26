package sidedish.com.controller.model;

import javax.validation.constraints.Positive;
import lombok.Getter;

@Getter
public class OrderSaveRequest {

    @Positive
    private Long count;
}
