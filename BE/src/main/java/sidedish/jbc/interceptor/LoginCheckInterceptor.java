package sidedish.jbc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.HandlerInterceptor;

public class LoginCheckInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
		Object handler) {
		HttpSession session = request.getSession();

		if (session == null || session.getAttribute("accessToken") == null) {
			response.setStatus(HttpStatus.UNAUTHORIZED.value());
			return false;
		}

		return true;
	}
}
