package com.saas.admin.service.role.permission;

import java.util.List;

import org.apache.shiro.authz.SimpleAuthorizationInfo;

import com.saas.admin.model.role.permission.RolePermission;
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
public interface RolePermissionService {
	public final String name = "rolepermissionService.name";

	/**
	 * 权限验证
	 * @param rid
	 * @return
	 */
	SimpleAuthorizationInfo findRolePermission(Integer rid);

	/**
	 * 初始化所有的权限
	 */
	void init();

	/**
	 * 更新角色权限
	 * @param roleId
	 * @param resourceIds
	 * @throws ServiceException
	 */
	void insertAll(Integer roleId, Integer[] permissionIds) throws ServiceException;

	/**
	 * 删除角色权限
	 * @param rid
	 * @throws ServiceException
	 */
	void deleteByRoleId(Integer rid) throws ServiceException;

	/**
	 * 查找角色权限
	 * @param roleId
	 * @return
	 */
	List<RolePermission> findByRoleId(Integer roleId) throws ServiceException;

	/**
	 * 验证权限是否在使用
	 * @param pid
	 */
	RolePermission findByPermissionId(Integer pid) throws ServiceException;

}
