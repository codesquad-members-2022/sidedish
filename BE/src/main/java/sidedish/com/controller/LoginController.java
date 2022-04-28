package sidedish.com.controller;

import java.net.URI;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sidedish.com.service.LoginService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class LoginController {

	private final LoginService loginService;

	public static final String callbackUrl = "http://localhost:8080/api/login/callback";
	private String clientId = "9819a665d5d8256d5ad6";
	private String clientSecret = "684aa9107cd2d757809f7fb642bab01c041a06aa";

	@GetMapping("/login")
	public ResponseEntity<Object> loginPage() {
		String location = "https://github.com/login/oauth/authorize?client_id=" + clientId +
			"&redirect_uri=" + callbackUrl;

		return ResponseEntity.status(HttpStatus.SEE_OTHER)
			.location(URI.create(location))
			.build();
	}

	@GetMapping("/login/callback")
	public void login(@RequestParam String code) {
		loginService.login(code);
	}
}
