package org.sa.redis.jms.listener;

import redis.clients.jedis.JedisPubSub;
import net.sf.json.JSONObject;

import org.springframework.stereotype.Component;


@Component
public class RedisListener extends JedisPubSub {

	@Override
	public void onPMessage(String pattern, String channel, String message) {
		// TODO Auto-generated method stub
		if (channel.equals("log")) {
            JSONObject mqMessage = JSONObject.fromObject(message);
            String time = mqMessage.getString("time");
            String event = mqMessage.getString("event");
            System.out.println("time:" + time + ",event :" + event);
		}
	}

	
}
