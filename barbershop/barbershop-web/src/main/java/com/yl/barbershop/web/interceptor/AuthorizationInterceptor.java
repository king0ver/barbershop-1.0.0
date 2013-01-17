package com.yl.barbershop.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.yl.barbershop.web.annotation.AuthRequired;
import com.yl.barbershop.web.util.AuthLevel;
import com.yl.barbershop.web.util.Constants;
import com.yl.barbershop.web.util.RequestUtil;


public class AuthorizationInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		
		//用于区分mvc:resources, 正常的Controller请求
        if (handler==null || !HandlerMethod.class.isAssignableFrom(handler.getClass())) {
            return true;
        }
        
        HandlerMethod method = (HandlerMethod)handler;
        AuthLevel level = getAuthLevel(method);
        if(level == AuthLevel.NONE){
        	return true;
        }
        
        if(checkAuth(request)){
        	return true;
        }
        
        if (RequestUtil.isJsonRequest(request)) {
            // TODO: 对于4xx/5xx错误是否需要使用统一的JsonPackageWrapper格式？
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        } else {
            response.sendRedirect(Constants.LOGIN_URL);
        	return true;
        }

        response.flushBuffer();
       
		
		return false;
	}
	/**
	 * check登录
	 * @param request
	 * @return
	 */
	private boolean checkAuth(HttpServletRequest request){
		
		Object o = request.getSession().getAttribute(Constants.LOGINNAME);
		String userName = o == null ? null : (String)o;
		if(StringUtils.isEmpty(userName)){
			return false;
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
	}
	
	private AuthLevel getAuthLevel(HandlerMethod method){
		
	    AuthRequired ar = method.getMethodAnnotation(AuthRequired.class);
	    if(ar == null){
	    	ar = method.getBeanType().getAnnotation(AuthRequired.class);
	    }
		
	    return ar == null ? AuthLevel.STRICT : ar.value();
	}

}
