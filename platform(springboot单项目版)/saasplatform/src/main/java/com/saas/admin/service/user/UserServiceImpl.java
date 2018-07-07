package com.saas.admin.service.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.ISelect;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.saas.admin.mapper.UserMapper;
import com.saas.admin.model.User;
import com.saas.mybatis.plugins.BaseConditionVO;

@Service(UserService.name)
@Transactional(rollbackFor = { RuntimeException.class, Exception.class })
public class UserServiceImpl implements UserService {

	@Autowired
	UserMapper userMapper;
	
	@Override
	public User getById(Integer uid) {
		
		return userMapper.selectByPrimaryKey(uid);
	}

	@Override
	public User login(String userName, String password) {
		return userMapper.login(userName, password);
	}

	@Override
	public List<User> getByPage(BaseConditionVO vo) {
		//开始分页
		PageHelper.offsetPage(vo.getPage(),vo.getCount());
//		PageHelper.startPage(pageNum, pageSize, orderBy)
		Page<User> value = userMapper.findByVo(vo);
		//设置返回参数
		vo.setTotal(value.getTotal());
		vo.setTotalPage(value.getPages());
		return value;
	}

}
