package com.saas.admin.mapper.role.permission;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.saas.admin.model.role.permission.RolePermission;

public interface RolePermissionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RolePermission record);

    int insertSelective(RolePermission record);

    RolePermission selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RolePermission record);

    int updateByPrimaryKey(RolePermission record);

	/**
	 * @return
	 */
	List<RolePermission> findAll();

	/**
	 * @param roleId
	 * @return 
	 */
	int deleteByRoleId(Integer roleId);

	/**
	 * @param roleId
	 * @param resourceIds
	 * @return
	 */
	int insertAll(@Param("roleId")Integer roleId, @Param("permissionIds")Integer[] permissionIds);

	/**
	 * @param rid
	 * @return
	 */
	List<RolePermission> findByRoleId(Integer rid);

	/**
	 * @param pid
	 * @return
	 */
	RolePermission findByPermissionId(Integer pid);
}