package team14.sidedish.controller;

import org.springframework.web.bind.annotation.RestController;
import team14.sidedish.service.SideDishService;

@RestController
public class SideDishController {

    private final SideDishService sideDishService;

    public SideDishController(SideDishService sideDishService) {
        this.sideDishService = sideDishService;
    }
}
