package com.saas.admin.service.permission;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saas.admin.mapper.permission.PermissionMapper;
import com.saas.admin.model.permission.Permission;
import com.saas.admin.model.role.permission.RolePermission;
import com.saas.admin.service.role.permission.RolePermissionService;
import com.saas.common.exception.ServiceException;

/**
 * 
 * 
 * @项目 SpringMvc
 *
 * @日期: 2017年3月2日
 * 
 * @负责人: LGQ
 */
@Service(value = PermissionService.name)
public class PermissionServiceImpl implements PermissionService {

	Logger logger = LoggerFactory.getLogger("permission");


	@Autowired
	RolePermissionService rolePermissionService;
	
	@Autowired
	PermissionMapper permissionMapper;
	@Override
	public void insert(Permission permission) throws ServiceException{
		Permission p = permissionMapper.findBySn(permission.getSn());
		if (p != null){
			throw new ServiceException("该权限已存在");
		}
		permissionMapper.insert(permission);
	}

	@Override
	public void update(Permission permission) throws ServiceException {
		if (permission.getPid() == null){
			throw new ServiceException("权限ID不能为空");
		}
		if (permission.getSn() != null){
			RolePermission rolePermission = rolePermissionService.findByPermissionId(permission.getPid());
			if (rolePermission != null){
				throw new ServiceException("权限使用中,不能编辑");
			}
		}
		permissionMapper.updateByPrimaryKeySelective(permission);
	}

	@Override
	public void delete(Integer pid) throws ServiceException {
		RolePermission rolePermission = rolePermissionService.findByPermissionId(pid);
		if (rolePermission != null){
			throw new ServiceException("权限使用中,不能删除");
		}
		permissionMapper.deleteByPrimaryKey(pid);
	}

	@Override
	public List<Permission> findAll() {
		return permissionMapper.findAll();
	}

	@Override
	public Permission findById(Integer rid) {
		return permissionMapper.load(rid);
	}

	
}
