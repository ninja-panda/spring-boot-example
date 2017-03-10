package com.tuturself.springboot.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class RequestInterceptor extends HandlerInterceptorAdapter {

	/**
	 * This is not a good practice to use sysout. Always integrate any logger
	 * with your application. We will discuss about integrating logger with
	 * spring boot application in some later article
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, 
			HttpServletResponse response, Object object) throws Exception {
		System.out.println("In preHandle we are Intercepting the Request");
		System.out.println("____________________________________________");
		String requestURI = request.getRequestURI();
		Integer personId = ServletRequestUtils.getIntParameter(request, "personId", 0);
		System.out.println("RequestURI::" + requestURI + 
				" || Search for Person with personId ::" + personId);
		System.out.println("____________________________________________");
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, 
			Object object, ModelAndView model)
			throws Exception {
		System.out.println("_________________________________________");
		System.out.println("In postHandle request processing "
				+ "completed by @RestController");
		System.out.println("_________________________________________");
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, 
			Object object, Exception arg3)
			throws Exception {
		System.out.println("________________________________________");
		System.out.println("In afterCompletion Request Completed");
		System.out.println("________________________________________");
	}
}
