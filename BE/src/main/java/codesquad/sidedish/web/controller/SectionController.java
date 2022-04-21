package codesquad.sidedish.web.controller;

import codesquad.sidedish.web.dto.ItemListElement;
import codesquad.sidedish.web.dto.ItemListResponse;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/sections")
public class SectionController {
    @GetMapping("/{sectionName}")
    public ItemListResponse loadItems(@PathVariable String sectionName) {
        ItemListElement sampleElement = new ItemListElement();
        List<ItemListElement> items = List.of(sampleElement);
        return new ItemListResponse(items);
    }
}
