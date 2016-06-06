package org.sa.redis;

import org.sa.redis.RedisExecuteTemplate.ExecuteCallback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import redis.clients.jedis.ShardedJedis;

@Component("redisClient")
public class RedisClientImpl implements RedisClient {
  @Autowired
  private RedisExecuteTemplate redisExecuteTemplate;
  /**
   * 
   * @see com.cathy.demo.redis.RedisClient#putObjectWithExpire(java.lang.String, java.lang.Object, long)
   */
  public boolean putObjectWithExpire(final String key, final Object obj, final long expireTime) {
    String result = (String) redisExecuteTemplate.excute(new ExecuteCallback() {
      byte[] objSeria = SerializationUtil.serializer(obj);
      public Object command(ShardedJedis shardedJedis) {
    	 
        return shardedJedis.set(key, new String(objSeria), "nx", "ex", expireTime);
      }
    });
    return "OK".equals(result);
  }
  /**
   * 
   * @see com.cathy.demo.redis.RedisClient#getObjectByKey(java.lang.String, java.lang.Class)
   */
  public Object getObjectByKey(final String key, final Class<?> clazz) {
    return redisExecuteTemplate.excute(new ExecuteCallback() {
      public Object command(ShardedJedis shardedJedis) {
        String str = shardedJedis.get(key);
        return SerializationUtil.deserializer(str.getBytes(), clazz);
      }
    });
  }
}
