package com.saas.admin.config.shiro;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.stereotype.Component;

import com.saas.common.json.JSONResult;
import com.saas.common.param.ErrorCode;
import com.saas.commons.util.ServerInfo;

/**
 * shiro过滤器组件
 * @ClassName: AuthcFilters 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author Orchid
 * @date 2018年6月29日 上午10:10:53 
 *
 */
@Component
public class AuthcFilters extends FormAuthenticationFilter {
	
	//
	private String loginView = "/login/test";

	Logger logger = Logger.getLogger(this.getClass());

	/**
	 * 创建 Token
	 */
	protected UsernamePasswordToken createToken(ServletRequest request, ServletResponse response) {
		String username = getUsername(request);
		String password = getPassword(request);
		// boolean rememberMe = isRememberMe(request);
		String host = getHost(request);
		return new UsernamePasswordToken(username, password,host);
	}

	/**
	 * 执行登陆方法
	 */
	protected boolean executeLogin(ServletRequest request, ServletResponse response) throws Exception {
		UsernamePasswordToken token = createToken(request, response);
		try {
			Subject subject = getSubject(request, response);
			subject.login(token);
			//方法交给父类执行
			return onLoginSuccess(token, subject, request, response);
		} catch (AuthenticationException e) {
			return onLoginFailure(token, e, request, response);
		}
	}

	@Override
	protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request,
			ServletResponse response) throws Exception {
//		该方法在会调用doGetAuthenticationInfo方法
		return super.onLoginSuccess(token, subject, request, response);
	}

	/** 
     * 会话超时或权限校验未通过的，统一返回401，由前端页面弹窗提示 
     */ 
	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
		if (isLoginRequest(request, response)) {
			if (isLoginSubmission(request, response)) {
				return executeLogin(request, response);
			} else {
				return true;
			}
		} else {
			if (ServerInfo.isAjax((HttpServletRequest) request)) {
				PrintWriter out = response.getWriter();
				JSONResult resp = new JSONResult();
				resp.setCode(ErrorCode.NOT_LOGIN);
				out.println(resp.toString());
			} else {
				saveRequestAndRedirectToLogin(request, response);
			}
			return false;
		}
	}

	@Override
	protected void saveRequestAndRedirectToLogin(ServletRequest request, ServletResponse response) throws IOException {
		WebUtils.issueRedirect(request, response, this.loginView);
		// super.saveRequestAndRedirectToLogin(request, response);
	}

	@Override
	protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
		return super.isAccessAllowed(request, response, mappedValue);
	}

	@Override
	protected boolean isPermissive(Object mappedValue) {
		return super.isPermissive(mappedValue);
	}

	@Override
	protected boolean onLoginFailure(AuthenticationToken token, AuthenticationException e, ServletRequest request,
			ServletResponse response) {
		HttpServletRequest req = (HttpServletRequest) request;
		req.setAttribute("case", e.getMessage());
		return super.onLoginFailure(token, e, request, response);
	}

	public String getLoginView() {
		return loginView;
	}

	public void setLoginView(String loginView) {
		this.loginView = loginView;
	}

}
