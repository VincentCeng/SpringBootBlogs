package com.saas.admin.mapper.role;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.saas.admin.model.role.Role;

public interface RoleMapper {
    int deleteByPrimaryKey(Integer rid);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer rid);

    int updateByPrimaryKeySelective(Role record);

	/**
	 * @return
	 */
	List<Role> findAll();

	Role load(Integer rid);

	/**
	 * @param grade
	 * @return
	 */
	String findByGrade(Integer grade);
}