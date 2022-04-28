package team14.sidedish.menu;

import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	// TODO /category/more -> 내부적으로 PAGE 자체 처리

	@GetMapping("/{special-menu-id}")
	public ResponseEntity<MenuDto.Response> readAll(@PathVariable("special-menu-id") int specialMenuId, @RequestParam("page") final int page) {
		PageRequest pageable = PageRequest.of(page, 10);
		MenuDto.Response response = menuService.readExhibition(specialMenuId, pageable);
		return ResponseEntity.ok().body(response);
	}

	/**
	 * 웰컴페이지 하단 카테고리 별 다음 슬라이드(page=1) 요청
	 * @param categoryId
	 * @param page
	 * @return
	 */
	@GetMapping("/category/{category-id}")
	public ResponseEntity<MenuDto.CategoryResponse> readListFrom(@PathVariable("category-id") int categoryId, @RequestParam("page") final int page) {
		PageRequest pageable = PageRequest.of(page, 10);
		MenuDto.CategoryResponse response = menuService.readListFrom(categoryId, pageable);
		return ResponseEntity.ok().body(response);
	}

	@GetMapping("/menu/{menu-id}")
	public ResponseEntity<MenuDto.DetailResponse> readOne(@PathVariable("menu-id") Long menuId) {
		MenuDto.DetailResponse detailResponse = menuService.readFrom(menuId);
		return ResponseEntity.ok().body(detailResponse);
	}

	/**
	 * 메뉴 상세조회 하단의 함께보면 좋은 메뉴목록에서 슬라이드 다음 요청시
	 * - (사용자 입장에서 URL 을 맞춰야 하지 않을까 싶어서)
	 * @param categoryId
	 * @param page
	 * @return
	 */
	@GetMapping("menu/category/{category-id}")
	public ResponseEntity<MenuDto.CategoryResponse> readOneSubNext(
		@PathVariable("category-id") int categoryId,
		@RequestParam(value = "page") final int page) {
		PageRequest pageable = PageRequest.of(page, 10);
		MenuDto.CategoryResponse response = menuService.readListFrom(categoryId, pageable);
		return ResponseEntity.ok().body(response);
	}

	@PostMapping("/menu/order")
	public ResponseEntity<OrderDto.Response> create(@Valid @RequestBody OrderDto.Request request) {
		OrderDto.Response response = menuService.createOrder(request);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
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
