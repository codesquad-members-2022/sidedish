package sidedish.com.controller;

import static sidedish.com.config.GitHubOAuthUtils.*;

import java.net.URI;
import javax.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sidedish.com.controller.model.UserResponse;
import sidedish.com.service.LoginService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class LoginController {

	private final LoginService loginService;

	@GetMapping("/login")
	public ResponseEntity<Object> loginPage() {
		return ResponseEntity.status(HttpStatus.SEE_OTHER)
			.location(URI.create(LOCATION))
			.build();
	}

	@GetMapping("/login/callback")
	public ResponseEntity<Object> login(@RequestParam String code, HttpSession session) {
		UserResponse user = loginService.login(code);
		session.setAttribute("userId", user.getId());

		/**
		 * TODO : 프론트 협의해야함
		 */
//		return user;
		return ResponseEntity.status(HttpStatus.SEE_OTHER)
			.location(URI.create(DNS_NAME))
			.build();
	}

	@GetMapping("/logout")
	public ResponseEntity<Object> logout(HttpSession session) {
		session.invalidate();
		return ResponseEntity.status(HttpStatus.SEE_OTHER)
			.location(URI.create(DNS_NAME))
			.build();
	}
}
