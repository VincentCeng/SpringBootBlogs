package com.saas.admin.mapper.permission;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.saas.admin.model.permission.Permission;

import io.lettuce.core.dynamic.annotation.Param;

public interface PermissionMapper {
    int deleteByPrimaryKey(Integer pid);

    int insert(Permission record);

    int insertSelective(Permission record);

    Permission selectByPrimaryKey(Integer pid);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);
    
    Permission load(@Param("permissionId")Integer permissionId);

	/**
	 * @return
	 */
	List<Permission> findAll();

	/**
	 * @param sn
	 * @return
	 */
	Permission findBySn(String sn);
}