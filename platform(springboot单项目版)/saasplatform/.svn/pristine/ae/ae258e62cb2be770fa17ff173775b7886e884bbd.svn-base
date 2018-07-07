package com.saas.admin.service.role.permission;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.saas.admin.mapper.role.permission.RolePermissionMapper;
import com.saas.admin.model.role.permission.RolePermission;
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
@Service(value = RolePermissionService.name)
public class RolePermissionServiceImpl implements RolePermissionService {

	Logger logger = LoggerFactory.getLogger("rolepermission");

	@Autowired
	RolePermissionMapper rolePermissionMapper;
	
//	@Autowired
//	PermissionMapper permissionMapper;
	
	Map<Integer, SimpleAuthorizationInfo> rolePermissionMap = new ConcurrentHashMap<Integer, SimpleAuthorizationInfo>();

	@Override
	public SimpleAuthorizationInfo findRolePermission(Integer rId) {
		return rolePermissionMap.get(rId);
	}

	@Override
	public void init() {
		List<RolePermission> ps = rolePermissionMapper.findAll();
		Map<Integer, SimpleAuthorizationInfo> map = new HashMap<Integer, SimpleAuthorizationInfo>();
		for (RolePermission p : ps) {
			SimpleAuthorizationInfo info = map.get(p.getRoleId());
			if (info == null) {
				info = new SimpleAuthorizationInfo();
				map.put(p.getRoleId(), info);
			}
			info.addStringPermission(p.getPermission().getSn());
		}
		rolePermissionMap = map;
	}
	
	
	/**
	 * 更新某个角色的缓存
	 * @param rid
	 */
	public void updateCacheMap(Integer rid) {
		List<RolePermission> ps = rolePermissionMapper.findByRoleId(rid);
		SimpleAuthorizationInfo info =  new SimpleAuthorizationInfo();
		for (RolePermission p : ps) {
			info.addStringPermission(p.getPermission().getSn());
		}
		rolePermissionMap.put(rid,info);
	}
	/**
	 * 删除某个角色的所有权限
	 * 用于更新角色权限前的清空处理
	 *
	 * @param rid
	 * @return
	 */
	@Override
	public void deleteByRoleId(Integer rid) throws ServiceException{
		try {
			rolePermissionMapper.deleteByRoleId(rid);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("清空角色权限失败");
		}
	}

	/**
	 * 角色更新时批量插入
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public void insertAll(Integer roleId, Integer[] permissionIds) throws ServiceException {
		if (roleId == null) {
			throw new ServiceException("角色ID错误");
		}
		try {
			//删除此角色的所有权限
			rolePermissionMapper.deleteByRoleId(roleId);
			if (permissionIds == null || permissionIds.length == 0) {
				rolePermissionMap.remove(roleId);
			}
			rolePermissionMapper.insertAll(roleId, permissionIds);
			//更新map缓存
			updateCacheMap(roleId);
		} catch (Exception e) {
			throw new ServiceException("更新角色权限失败");
		}
	}

	@Override
	public List<RolePermission> findByRoleId(Integer roleId) throws ServiceException {
		return rolePermissionMapper.findByRoleId(roleId);
	}

	@Override
	public RolePermission findByPermissionId(Integer pid) throws ServiceException {
		return rolePermissionMapper.findByPermissionId(pid);
	}
}
