package kr.codesquad.sidedish.interceptor;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.HandlerInterceptor;

public class OrderInterceptor implements HandlerInterceptor {

    private final Logger log = LoggerFactory.getLogger(OrderInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
        Object handler) throws Exception {

        if(HttpMethod.OPTIONS.matches(request.getMethod())) {
            log.info("is preflight");
            return true;
        }

        if (request.getHeader("userEmail") == null) {
            log.info("userEmail is null");
            response.sendError(HttpStatus.FORBIDDEN.value(),"로그인이 필요한 서비스입니다.");
            return false;
        }

        return HandlerInterceptor.super.preHandle(request, response, handler);
    }
}
