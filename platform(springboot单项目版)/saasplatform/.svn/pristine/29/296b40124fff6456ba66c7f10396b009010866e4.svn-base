package com.saas.admin.service.role;

import java.util.List;

import com.saas.admin.model.role.Role;
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
public interface RoleService {
	public final String name = "roleService.name";

	/**
	 * @return
	 */
	List<Role> findAll() throws ServiceException;

	/**
	 * @param role
	 */
	void insert(Role role) throws ServiceException;

	/**
	 * @param role
	 */
	void update(Role role) throws ServiceException;

	/**
	 * @param rid
	 */
	void delete(Integer rid) throws ServiceException;

	/**
	 * @param rid
	 * @return
	 */
	Role findById(Integer rid) throws ServiceException;;

	
}
