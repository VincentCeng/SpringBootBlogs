package com.saas.platform.saasplatform;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.github.pagehelper.Page;
import com.saas.admin.mapper.UserMapper;
import com.saas.admin.model.User;
import com.saas.mybatis.plugins.BaseConditionVO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SaasplatformApplicationTests {

	
	@Autowired
	UserMapper userMapper;
	
	@Test
	public void contextLoads() {
		System.out.println("dasd");
	}
	
	@Test
	public void test2() {
		/** 
		 * @author 刘曾 
		 * @version 2018年7月7日 下午9:46:57 
		 */
		System.out.println("进入。。。");
		BaseConditionVO vo=new BaseConditionVO();
		vo.setCount(3);
		vo.setPage(1);
		Page<User> list=userMapper.findByVo(vo);
		for (User user : list) {
			System.out.println(user);
		}
		
	}
	

}
