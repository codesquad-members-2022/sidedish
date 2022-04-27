package team14.sidedish.menu;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/sidedish")
public class MenuApiController {
	private final MenuService menuService;

	@GetMapping("/{id}")
	public ResponseEntity<MenuDto.Response> readAll(@PathVariable int id) {
		MenuDto.Response response = menuService.readExhibition(id);
		return ResponseEntity.ok().body(response);
	}

	@GetMapping("/menu/{menu-id}")
	public ResponseEntity<MenuDto.DetailResponse> readOne(@PathVariable("menu-id") Long menuId) {
		MenuDto.DetailResponse detailResponse = menuService.readFrom(menuId);
		return ResponseEntity.ok().body(detailResponse);
	}
}
