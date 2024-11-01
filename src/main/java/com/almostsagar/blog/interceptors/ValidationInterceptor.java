package com.almostsagar.blog.interceptors;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Component;
import org.springframework.validation.Validator;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ValidationInterceptor implements HandlerInterceptor {

    private final ObjectProvider<Validator> validatorProvider;

    public ValidationInterceptor(ObjectProvider<Validator> validatorProvider) {
        this.validatorProvider = validatorProvider;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        return true;
    }

}
