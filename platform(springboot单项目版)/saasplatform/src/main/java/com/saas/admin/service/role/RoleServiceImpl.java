package com.saas.admin.service.role;

import java.util.Date;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saas.admin.mapper.role.RoleMapper;
import com.saas.admin.model.User;
import com.saas.admin.model.role.Role;
import com.saas.common.exception.ServiceException;
import com.saas.common.param.Constants;


/**
 * 
 * 
 * @项目 SpringMvc
 *
 * @日期: 2017年3月2日
 * 
 * @负责人: LGQ
 */
@Service(value = RoleService.name)
public class RoleServiceImpl implements RoleService {

	Logger logger = LoggerFactory.getLogger("role");

	@Autowired
	RoleMapper roleMapper;
	
	@Override
	public List<Role> findAll() {
		return roleMapper.findAll();
	}

	@Override
	public void insert(Role role) throws ServiceException {
		User user = (User)SecurityUtils.getSubject().getPrincipal();
		if (user == null){
			throw new ServiceException("请登录");
		}
		if (role.getGrade().intValue() >= user.getRole().getGrade().intValue()){
			throw new ServiceException("管理权限不足");
		}
		String name = roleMapper.findByGrade(role.getGrade());
		if (name != null){
			throw new ServiceException("当前等级已存在");
		}
		role.setUid(user.getUid());
		role.setCreatedate(new Date());
		if (role.getStatus() == null){
			role.setStatus(Constants.CommonStatus.NORMAL);
		}
		roleMapper.insertSelective(role);
	}

	@Override
	public void update(Role role) throws ServiceException {
		User user = (User)SecurityUtils.getSubject().getPrincipal();
		if (user == null){
			throw new ServiceException("请登录");
		}
		if (role.getGrade() != null ){
			if (role.getGrade().intValue() >= user.getRole().getGrade().intValue()){
				throw new ServiceException("管理权限不足");
			}
			String name = roleMapper.findByGrade(role.getGrade());
			if (name != null){
				throw new ServiceException("当前等级已存在");
			}
		}
		role.setUid(user.getUid());
		role.setUpdatedate(new Date());
		roleMapper.updateByPrimaryKeySelective(role);
	}

	@Override
	public void delete(Integer rid) throws ServiceException {
		roleMapper.deleteByPrimaryKey(rid);
	}

	@Override
	public Role findById(Integer rid) throws ServiceException {
		return roleMapper.selectByPrimaryKey(rid);
	}
	
}
