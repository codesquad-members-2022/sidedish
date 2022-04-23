package team14.sidedish.menu;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/sidedish")
public class MenuApiController {
	@GetMapping
	public ResponseEntity readAll() {
		return ResponseEntity.ok().build();
	}
}
