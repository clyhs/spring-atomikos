package org.sa.redis.jms;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.druid.support.json.JSONUtils;


@Service
public class RedisProducer {

	@Autowired
	private RedisManager redisManager;

	public void send(){
		 Map<String, String> map = new HashMap<String, String>();
	     map.put("type", "log");
	     map.put("time", String.valueOf(new Date()));
	     map.put("event", "sun qq login");
	     redisManager.publish("log", JSONUtils.toJSONString(map));
	}
}
