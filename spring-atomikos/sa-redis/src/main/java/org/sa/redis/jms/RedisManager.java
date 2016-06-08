package org.sa.redis.jms;

import org.sa.redis.RedisClientTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RedisManager {
	
	@Autowired
	private RedisClientTemplate redisClientTemplate;
	
	public void publish(String key ,String value){
		redisClientTemplate.publish(key, value);
	}

}
