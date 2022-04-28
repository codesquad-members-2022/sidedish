package kr.codesquad.sidedish.interceptor;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;

public class OrderInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
        Object handler) throws Exception {

        if (request.getHeader("userEmail") == null) {
            return false;
        }

        return HandlerInterceptor.super.preHandle(request, response, handler);
    }
}
