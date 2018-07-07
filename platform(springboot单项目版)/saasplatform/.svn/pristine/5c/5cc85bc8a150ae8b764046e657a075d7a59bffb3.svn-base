package com.saas.admin.service.permission;

import java.util.List;

import com.saas.admin.model.permission.Permission;
import com.saas.common.exception.ServiceException;


/**
 *  
 * 
 * @项目        SpringMvc
 *
 * @日期:       2017年3月2日
 *  
 * @负责人:    LGQ
 */
public interface PermissionService {
	public final String name = "permissionService.name";

	/**
	 * @return
	 */
	List<Permission> findAll() throws ServiceException;

	/**
	 * @param permission
	 */
	void insert(Permission permission) throws ServiceException;

	/**
	 * @param permission
	 */
	void update(Permission permission) throws ServiceException;

	/**
	 * @param pid
	 */
	void delete(Integer pid) throws ServiceException;

	/**
	 * @param rid
	 * @return
	 */
	Permission findById(Integer pid) throws ServiceException;

	
}
