package com.saas.admin.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.saas.admin.model.User;
import com.saas.common.json.JSONResult;
import com.saas.commons.util.StringUtils;

/*
 * 拦截过滤
 */
public class CustomInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if (handler instanceof HandlerMethod) {
			String url = request.getRequestURI();
			String token = request.getHeader("token");
			String uid = request.getParameter("uid");
			String md5 = null;
			// token处理
			if (token != null) {
				if (!url.contains("/api/")) {
					response.setCharacterEncoding("UTF-8");
					response.setContentType("application/json;charset=UTF-8");
					JSONResult jsonResult = new JSONResult();
					jsonResult.setCode(500);
					jsonResult.setMsg("error");
					response.getWriter().write(JSON.toJSONString(jsonResult));
					return false;
				}
				md5 = "tokenKey";
				if (token.equals(md5)) {
					// 登陆,无u_token路径
					if (url.contains("/api/login") || url.contains("/api/free")) {
						return true;
					} else {
						response.setCharacterEncoding("UTF-8");
						response.setContentType("application/json;charset=UTF-8");
						JSONResult jsonResult = new JSONResult();
						jsonResult.setCode(500);
						jsonResult.setMsg("请登录");
						response.getWriter().write(JSON.toJSONString(jsonResult));
						return false;
					}
					// 如果得到的token在返回的所有token中,则该用户在登陆状态,可以访问所有api移动端接口
				} else if (StringUtils.isNumeric(uid) == false) {
					response.setCharacterEncoding("UTF-8");
					response.setContentType("application/json;charset=UTF-8");
					JSONResult jsonResult = new JSONResult();
					jsonResult.setCode(-1);
					jsonResult.setMsg("用户身份信息错误");
					response.getWriter().write(JSON.toJSONString(jsonResult));
					return false;
				}
			}
			User user = (User) SecurityUtils.getSubject().getPrincipal();
			if (user != null) {
				return true;
			}
			// 当返回true的时候,继续向下执行到controller
			response.setHeader("sessionstatus", "timeout");
			response.setCharacterEncoding("UTF-8");
			response.setContentType("application/json;charset=UTF-8");
			JSONResult jsonResult = new JSONResult();
			jsonResult.setCode(500);
			jsonResult.setMsg("请登录");
			response.getWriter().write(JSON.toJSONString(jsonResult));
			return false;
		} else {
			return HandlerInterceptor.super.preHandle(request, response, handler);
		}
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}

}
