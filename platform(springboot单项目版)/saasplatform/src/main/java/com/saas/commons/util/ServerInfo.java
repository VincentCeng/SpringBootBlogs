package com.saas.commons.util;

import javax.servlet.http.HttpServletRequest;

/**
 * 项目服务的工具类
 * @ClassName: ServerInfo 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author Orchid
 * @date 2018年6月7日 下午3:23:19 
 *
 */
public class ServerInfo {
	
	/**
	 * 判断该request请求是否是ajax请求
	 * @Title: isAjax 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param request
	 * @return
	 * @return boolean    返回类型 
	 * @throws
	 */
	public static boolean isAjax(HttpServletRequest request) {
		if (request!=null
			 &&"XMLHttpRequest".equalsIgnoreCase(request.getHeader("X-Requested-With")) 
			 || request.getParameter("ajax") != null)
			return true;
		return false;
	}

}
