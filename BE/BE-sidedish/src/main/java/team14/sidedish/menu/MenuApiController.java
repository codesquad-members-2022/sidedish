package team14.sidedish.menu;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import lombok.RequiredArgsConstructor;
import team14.sidedish.common.Exception.InvalidOrderException;
import team14.sidedish.common.error.Error;
import team14.sidedish.common.error.ErrorResponse;
import team14.sidedish.order.OrderDto;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/sidedish")
public class MenuApiController {
	private final MenuService menuService;

	@GetMapping("/{id}")
	public ResponseEntity<MenuDto.Response> readAll(@PathVariable("id") int specialMenuId) {
		MenuDto.Response response = menuService.readExhibition(specialMenuId);
		return ResponseEntity.ok().body(response);
	}

	@GetMapping("/menu/{menu-id}")
	public ResponseEntity<MenuDto.DetailResponse> readOne(@PathVariable("menu-id") Long menuId) {
		MenuDto.DetailResponse detailResponse = menuService.readFrom(menuId);
		return ResponseEntity.ok().body(detailResponse);
	}

	@PostMapping("/menu/order")
	@ResponseStatus(HttpStatus.CREATED)
	public void update(@Valid @RequestBody OrderDto.Request request) {
		menuService.update(request);
	}

	@ExceptionHandler(InvalidOrderException.class)
	public ResponseEntity<ErrorResponse> invalidOrderException(
		InvalidOrderException exception,
		HttpServletRequest httpServletRequest) {
		Error error = new Error(exception.getValue(), exception.getMessage(), exception.getInvalidValue());
		ErrorResponse errorResponse = ErrorResponse.oneErrorOfFail(httpServletRequest.getRequestURI(), error);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
	}
}
