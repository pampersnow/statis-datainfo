package com.example.statisdatainfo.config;

import java.lang.reflect.Method;

import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
@EnableCaching
/*
 * @EnableCaching 会被spring发现，并且会创建一个切面（aspect） 并触发Spring缓存注解的切点（pointcut） 。
 * 根据所使用的注解以及缓存的状态， 这个切面会从缓存中获取数据， 将数据添加到缓存之中或者从缓存中移除某个值。
 */
public class RedisConfig extends CachingConfigurerSupport{

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Bean
	@Primary
	public RedisTemplate redisTemplate(RedisConnectionFactory factory) {
		// 创建一个模板
		// key是String类型，value是Object类型（如果key和value都是String类型，建议使用StringRedisTemplate）
		RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();
		template.setConnectionFactory(factory);
		// 设置key的序列化器
		template.setKeySerializer(new StringRedisSerializer());
		// 设置value的序列化器
		// 使用Jackson 2，将对象序列化为JSON
		Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
		// json转对象类，不设置默认的会将json转成HashMap
		ObjectMapper om = new ObjectMapper();
		om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
		om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
		jackson2JsonRedisSerializer.setObjectMapper(om);
		template.setValueSerializer(jackson2JsonRedisSerializer);
		return template;
	}

	/**
	 * 作用就是@EnableCaching这个切面在新增缓存或者删除缓存的时候会调用这个缓存管理器的方法
	 * 申明缓存管理器，会创建一个切面（aspect）并触发Spring缓存注解的切点（pointcut）
	 * 根据类或者方法所使用的注解以及缓存的状态，这个切面会从缓存中获取数据，将数据添加到缓存之中或者从缓存中移除某个值
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@Bean
	public RedisCacheManager cacheManager(RedisTemplate redisTemplate) {
		return new RedisCacheManager(redisTemplate);
	}

	@Override
	public KeyGenerator keyGenerator() {
		return new KeyGenerator() {			
			@Override
			public Object generate(Object target, Method method, Object... params) {
				// TODO Auto-generated method stub
				StringBuilder sb = new StringBuilder();
				sb.append(target.getClass().getName());
				sb.append(method.getName());
				for (Object object : params) {
					sb.append(object.toString());
				}
				return sb.toString();
			}
		};	
	}

	@Bean
	public RedisConnectionFactory redisCF() {
		// 如果什么参数都不设置，默认连接本地6379端口
		JedisConnectionFactory factory = new JedisConnectionFactory();
		factory.setPort(6379);
		factory.setHostName("localhost");
		return factory;
	}
}
