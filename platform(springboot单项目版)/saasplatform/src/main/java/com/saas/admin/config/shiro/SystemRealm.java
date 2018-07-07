package com.saas.admin.config.shiro;

import java.util.Collection;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import com.saas.admin.model.User;
import com.saas.admin.service.role.permission.RolePermissionService;
import com.saas.admin.service.user.UserService;
import com.saas.common.exception.ServiceException;

public class SystemRealm extends AuthorizingRealm {

	Logger logger = LoggerFactory.getLogger("SystemRealm");

	@Autowired
	RolePermissionService rolePermissionService;

	@Autowired
	UserService userService;

	/**
	 * 认证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken arg0) throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken) arg0;
		String password = String.valueOf(token.getPassword());
		String userName = token.getUsername();
		if (StringUtils.isEmpty(userName) || StringUtils.isEmpty(password)) {
			throw new AuthenticationException("用户名或密码为空");
		}
		userName = userName.trim();
		password = password.trim();
		User user;
		try {
			user = userService.login(userName, password);
			if (user == null) {
				throw new ServiceException("账户或密码错误");
			}
		} catch (ServiceException e) {
			e.printStackTrace();
			throw new AuthenticationException(e.getMessage());
		}
		 //返回认证信息由父类 AuthenticatingRealm 进行认证
		return new SimpleAuthenticationInfo(user, password, getName());
	}
	
	/**
	 * 授权
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		if (!SecurityUtils.getSubject().isAuthenticated()) {
			doClearCache(arg0);
			SecurityUtils.getSubject().logout();
			return null;
		}

		if (arg0 == null) {
			throw new AuthorizationException("parameters principals is null");
		}
		// 获取已认证的用户名（登录名）
		User user = (User) getAvailablePrincipal(arg0);
//		返回认证信息由父类 AuthenticatingRealm 进行认证
		SimpleAuthorizationInfo info = (SimpleAuthorizationInfo) rolePermissionService
				.findRolePermission(user.getRid());
		return info;
	}

	@Override
	public boolean isPermitted(PrincipalCollection principals, String permission) {

		return super.isPermitted(principals, permission);
	}

	@Override
	public boolean isPermitted(PrincipalCollection principals, Permission permission) {

		return super.isPermitted(principals, permission);
	}

	@Override
	public boolean[] isPermitted(PrincipalCollection subjectIdentifier, String... permissions) {

		return super.isPermitted(subjectIdentifier, permissions);
	}

	@Override
	public boolean[] isPermitted(PrincipalCollection principals, List<Permission> permissions) {

		return super.isPermitted(principals, permissions);
	}

	@Override
	public boolean isPermittedAll(PrincipalCollection subjectIdentifier, String... permissions) {

		return super.isPermittedAll(subjectIdentifier, permissions);
	}

	@Override
	public boolean isPermittedAll(PrincipalCollection principal, Collection<Permission> permissions) {

		return super.isPermittedAll(principal, permissions);
	}

	@Override
	protected boolean isPermittedAll(Collection<Permission> permissions, AuthorizationInfo info) {

		return super.isPermittedAll(permissions, info);
	}
}
