package com.saas.admin.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.github.pagehelper.Page;
import com.saas.admin.model.User;
import com.saas.mybatis.plugins.BaseConditionVO;

@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(Integer uid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer uid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

	/** 
	* @Title: login 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param username
	* @param @param password
	* @param @return    设定文件 
	* @return User    返回类型 
	* @throws 
	*/
	User login(@Param("username")String username, @Param("password")String password);
	
	/**
	 * 返回HashMap类型的数据
	 * @Title: hm 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @param username
	 * @param @param password
	 * @param @return    设定文件 
	 * @return Map<String,String>    返回类型 
	 * @throws
	 */
	Map<String, String> hm(@Param("username")String username, @Param("password")String password);

	Page<User> findByVo(@Param("vo")BaseConditionVO vo);
}