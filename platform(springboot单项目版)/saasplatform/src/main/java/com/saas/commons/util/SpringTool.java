package com.saas.commons.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * 获得上下文
* @ClassName: SpringTool 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author 740363090@qq.com 
* @date 2018年5月22日 下午2:49:54 
*
 */
public final class SpringTool implements ApplicationContextAware {
	private static ApplicationContext applicationContext = null;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		if (SpringTool.applicationContext == null) {
			SpringTool.applicationContext = applicationContext;
			System.out.println(
					"========ApplicationContext配置成功,在普通类可以通过调用ToolSpring.getAppContext()获取applicationContext对象,applicationContext="
							+ applicationContext + "========");
		}
	}

	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	public static Object getBean(String name) {
		return getApplicationContext().getBean(name);
	}
}