package com.saas.common.param;

/**
 * 
 * 
 * @项目 SpringMvc
 *
 * @日期: 2017年5月19日
 * 
 * @负责人: LGQ
 */
public interface Constants {

	interface UserStatus {
		int NORMAL = 1;// 正常状态
		int ERROR = 0;// 禁用状态
	}
	
	interface RedisKey {
		String TOKEN = "token";
	}

	interface HttpKey {
		String USERID = "uid";
		String TOKEN = "token";
	}

	interface CommonStatus {
		int NORMAL = 1;// 正常状态
		int ERROR = 0;// 禁用状态
	}
}
