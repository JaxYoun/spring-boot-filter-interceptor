package com.yang.springbootfilterinterceptor.interceptor;

import com.yang.springbootfilterinterceptor.annotation.StatusCheck;
import com.yang.springbootfilterinterceptor.service.StatusCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Objects;

public class StatusCheckInterceptor implements HandlerInterceptor {

    @Autowired
    private StatusCheckService statusCheckService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        StatusCheck statusCheck = ((HandlerMethod) handler).getMethodAnnotation(StatusCheck.class);
        if (Objects.isNull(statusCheck)) {
            return true;
        } else {
            List<String> operationList = this.statusCheckService.getOperationList();
            String uri = request.getRequestURI();
            return operationList.contains(uri);
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {

    }
}
