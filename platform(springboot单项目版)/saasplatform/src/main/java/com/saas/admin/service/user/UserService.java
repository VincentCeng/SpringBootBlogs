package com.saas.admin.service.user;

import java.util.List;

import com.saas.admin.model.User;
import com.saas.mybatis.plugins.BaseConditionVO;

public interface UserService {
	public final String name = "userService";
	
	User getById(Integer uid);

	User login(String userName, String password);

	List<User> getByPage(BaseConditionVO vo);
}
