package com.terria.sidedish.api;

import com.terria.sidedish.service.OrderSheetService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Api(tags = "SideDishController")
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/order-sheets")
public class OrderSheetController {

    private final OrderSheetService orderSheetService;

    @PostMapping
    public String makeOrderSheet() {
        // TODO
        return null;
    }
}
