package com.saas.admin.config.redis;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * redis链接的参数配置
 * 
 * @ClassName: RedisConfigProperties
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Orchid
 * @date 2018年6月26日 下午1:47:25
 *
 */
@Configuration
public class RedisConfiguration {

	@Value("${platform.name}")
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// 本地参数
	public static String host = "127.0.0.1";
	// 端口
	public static int port = 6379;
	// 密码
	public static String password = "123456";
	// key过期时间
	// public static int expire = 1000;
	//
	public static int shiro_expire = 1800;
	public static int shiro_timeout = 0;
	// 数据库索引
	public static int database = 0;
	// 最大活跃连接
	public static int maxActive = 100;
	// 连接池最大阻塞等待时间（使用负值表示没有限制）
	public static int maxWait = 1000;
	// 连接池中的最大空闲连接
	public static int maxIdle = 100;
	// 连接池中的最小空闲连接
	public static int minIdle = 1;
	// 连接超时时间（毫秒）
	public static int timeOut = 600;

	public static boolean testOnBorrow = true;

	public static boolean testOnReturn = true;

}
