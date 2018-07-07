package com.saas.admin.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.saas.admin.service.role.permission.RolePermissionService;

/**
 * 上下文执行类
 * @ClassName: InitMethod 
 * @Description: (这里用一句话描述这个类的作用) 
 * @author Orchid
 * @date 2018年6月29日 上午9:05:38 
 *
 */
@Component
public class InitMethod implements ApplicationRunner{

	@Autowired
	RolePermissionService rolePermissionService;
	
	/**
	 * 启动就执行
	 */
    @Override
    public void run(ApplicationArguments var1) throws Exception{
    	//加载权限的方法
		rolePermissionService.init();
		System.out.println("init_success");
    }

}
