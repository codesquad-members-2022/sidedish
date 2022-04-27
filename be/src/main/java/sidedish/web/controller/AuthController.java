package sidedish.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sidedish.service.AuthService;
import sidedish.web.dto.ResponseDto;

@RequiredArgsConstructor
@RestController
public class AuthController {

	private final AuthService authService;

	@GetMapping("/auth/login")
	public ResponseDto auth(@RequestParam String code) {
		return authService.userLogin(code);
	}
}
