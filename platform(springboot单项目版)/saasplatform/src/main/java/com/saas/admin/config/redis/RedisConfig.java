package com.saas.admin.config.redis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.session.data.redis.config.ConfigureRedisAction;

import com.alibaba.fastjson.parser.ParserConfig;

import redis.clients.jedis.JedisPoolConfig;

/**
 * redis配置文件
 * 
 * @ClassName: RedisConfig
 * @Description: (这里用一句话描述这个类的作用)
 * @author Orchid
 * @date 2018年6月26日 下午1:48:45
 *
 */
@Configuration
public class RedisConfig {

	@Bean
	public RedisSerializer<Object> fastJson2JsonRedisSerializer() {
		ParserConfig.getGlobalInstance().setAutoTypeSupport(true);
		return new FastJson2JsonRedisSerializer<Object>(Object.class);
	}

	/*
	 * 如果您正在使用@EnableRedisHttpSession的SessionMessageListener和启用必要的Redis
	 * KEYSPACE事件是自动完成的。但是，在安全的Redis环境中，config命令被禁用。这意味着Spring Session无法为您配置Redis
	 * Keyspace事件。要禁用自动配置，请添加ConfigureRedisAction.NO_OP为bean。
	 */
	@Bean
	public static ConfigureRedisAction configureRedisAction() {
		return ConfigureRedisAction.NO_OP;
	}

	@Bean
	public RedisConnectionFactory redisConnectionFactory() {
		JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();

		// 最大空闲接连
		jedisPoolConfig.setMaxIdle(RedisConfiguration.maxIdle);
		// 最小空闲连接
		jedisPoolConfig.setMinIdle(RedisConfiguration.minIdle);
		// 连接池最大阻塞等待时间
		jedisPoolConfig.setMaxWaitMillis(RedisConfiguration.maxWait);

		jedisPoolConfig.setTestOnBorrow(RedisConfiguration.testOnBorrow);

		jedisPoolConfig.setTestOnReturn(RedisConfiguration.testOnReturn);

		// 主机地址
		JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();

		jedisConnectionFactory.setHostName(RedisConfiguration.host);
		// 端口
		jedisConnectionFactory.setPort(RedisConfiguration.port);
		// 密码
		jedisConnectionFactory.setPassword(RedisConfiguration.password);
		// 索引
		jedisConnectionFactory.setDatabase(RedisConfiguration.database);
		// 超时时间
		jedisConnectionFactory.setTimeout(RedisConfiguration.timeOut);

		jedisConnectionFactory.setUsePool(true);
		jedisConnectionFactory.setPoolConfig(jedisPoolConfig);
		return jedisConnectionFactory;
	}

	@Bean
	public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory factory,
			FastJson2JsonRedisSerializer fastJson2JsonRedisSerializer) {
		StringRedisTemplate redisTemplate = new StringRedisTemplate(factory);
		// Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new
		// Jackson2JsonRedisSerializer(Object.class);
		redisTemplate.setConnectionFactory(redisConnectionFactory());
		// 开启redis事务
		redisTemplate.setEnableTransactionSupport(true);
		// hash 使用jdk 的序列化
		redisTemplate.setHashValueSerializer(fastJson2JsonRedisSerializer);
		// StringRedisSerializer key 序列化
		redisTemplate.setHashKeySerializer(new StringRedisSerializer());
		// keySerializer 对key的默认序列化器。默认值是StringSerializer
		redisTemplate.setKeySerializer(new StringRedisSerializer());
		redisTemplate.setValueSerializer(fastJson2JsonRedisSerializer);
		redisTemplate.afterPropertiesSet();
		return redisTemplate;
	}
}