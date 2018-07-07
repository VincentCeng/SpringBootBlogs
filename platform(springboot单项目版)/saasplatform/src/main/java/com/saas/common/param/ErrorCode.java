package com.saas.common.param;


/**
 * Created by momo on 2016/8/17. AJAX 错误号，理论上需要按照： 错误号{5位} = 模块编号{2} + 错误编号{3}
 * 这里从110开始往后递增编号就可以了，
 */
public enum ErrorCode {
	NOT_LOGIN("未登录", -1),
	ERROR_ACCOUNT("账号信息错误", 1),
	NOT_ALLOWED("账号权限不足", 2),
	CODE("未定义错误",110), 
	LOGIN_PASSWORD_ERROR("用户名或密码错误", -1), 
	NOT_REGISTER("用户不存在", -2),
	PASSWORD_ERROR("密码错误", -1),
	Success("success",0), 
	ERROT_FOR_ALL("error",-1);
	
	private int code;

	private String msg;

	private ErrorCode(String msg, int code) {
		this.code = code;
		this.msg = msg;
	}

	public int getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}

}
