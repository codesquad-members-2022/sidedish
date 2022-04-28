package sidedish.com.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
		Object handler) throws Exception {
		if (HttpMethod.OPTIONS.matches(request.getMethod())) {
			return true;
		}

		HttpSession session = request.getSession();
		Long userId = (Long) session.getAttribute("userId");
		if (userId == null) {
			response.sendRedirect("http://localhost:8080");
			return false;
		}
		return true;
	}
}
