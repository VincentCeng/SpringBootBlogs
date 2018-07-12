package com.saas.admin.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.saas.admin.model.User;
import com.saas.admin.service.user.UserService;
import com.saas.common.json.JSONResult;
import com.saas.mybatis.plugins.BaseConditionVO;

/**
 * 
 * @ClassName: LoginController 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author Orchid
 * @date 2018年6月29日 上午10:27:09 
 *
 */
@Controller
public class LoginController extends BaseController {

	@Autowired
	UserService userService;
	
	@RequestMapping("login")
	public String login(){
		return "login";
	}
	
	@RequestMapping("login/test")
	public String loginTest(){
		return "login";
	}
	
	@RequestMapping("index")
	public String index(){
		return "index";
	}

	@RequestMapping("loginSuccess")
	@ResponseBody
	public JSONResult loginSuccess() {
		User user = (User) SecurityUtils.getSubject().getPrincipal();
		return ajaxSuccess(user);
	}
	
	// 登录
	@RequestMapping(value = "login/post", method = RequestMethod.POST)
	public @ResponseBody JSONResult loginPost(HttpServletRequest request) {
		if (SecurityUtils.getSubject().isAuthenticated()) {
			User user = (User) SecurityUtils.getSubject().getPrincipal();
			// 这里永远不会执行到
			return ajaxSuccess(user);
		} else {
			String errorClassName = (String) request.getAttribute("case");
			return ajaxFail(errorClassName);
		}
	}
	
	@RequestMapping("logout")
	@ResponseBody
	public JSONResult logout(BaseConditionVO vo){
		User user = (User) SecurityUtils.getSubject().getPrincipal();
		// 这里永远不会执行到
		return ajaxSuccess(user);
	}
	
	@RequestMapping("get")
	@RequiresPermissions("test:test")
	@ResponseBody
	public JSONResult get(Integer uid){
		User user = userService.getById(uid);
		return ajaxSuccess(user);
	}
	
	@RequestMapping("gets")
	@RequiresPermissions("test:test")
	@ResponseBody
	public JSONResult gets(BaseConditionVO vo){
		List<User> user = userService.getByPage(vo);
		return ajaxSuccess(user,vo);
	}
	/**
	 * 定时任务
	 */
	@Scheduled(cron="*/5 * * * * ?")
	public void task(){
//		System.out.println(111);
	}
}
