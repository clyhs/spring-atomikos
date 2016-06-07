package org.sa.redis;

import java.util.List;

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
	 * @see com.cathy.demo.redis.RedisClient#putObjectWithExpire(java.lang.String,
	 *      java.lang.Object, long)
	 */
	public boolean putObjectWithExpire(final String key, final Object obj,
			final long expireTime) {
		String result = (String) redisExecuteTemplate
				.excute(new ExecuteCallback() {
					byte[] objSeria = SerializationUtil.serializer(obj);

					public Object command(ShardedJedis shardedJedis) {

						return shardedJedis.set(key, new String(objSeria),
								"nx", "ex", expireTime);
					}
				});
		return "OK".equals(result);
	}

	/**
	 * 
	 * @see com.cathy.demo.redis.RedisClient#getObjectByKey(java.lang.String,
	 *      java.lang.Class)
	 */
	public Object getObjectByKey(final String key, final Class<?> clazz) {
		return redisExecuteTemplate.excute(new ExecuteCallback() {
			public Object command(ShardedJedis shardedJedis) {
				String str = shardedJedis.get(key);
				return SerializationUtil.deserializer(str.getBytes(), clazz);
			}
		});
	}

	public boolean deleteObjectByKey(final String key) {
		// TODO Auto-generated method stub
		long id =(Long) redisExecuteTemplate
				.excute(new ExecuteCallback() {

					public Object command(ShardedJedis shardedJedis) {
						// TODO Auto-generated method stub

						String str = shardedJedis.get(key);

						return shardedJedis.del(key);
					}

				});
		System.out.println(id);
		return true;
	}

	public boolean putArrayWithExpire(final String key,final List<?> list,final long expire) {
		// TODO Auto-generated method stub
		String result = (String) redisExecuteTemplate
				.excute(new ExecuteCallback() {
					byte[] objSeria = SerializationUtil.serializeList(list);

					public Object command(ShardedJedis shardedJedis) {

						return shardedJedis.set(key, new String(objSeria), "nx", "ex", expire);
					}
				});
		return "OK".equals(result);
	}

	public List<?> getArrayWithExpire(final String key,final Class<?> clazz) {
		// TODO Auto-generated method stub
		return (List<?>) redisExecuteTemplate.excute(new ExecuteCallback() {
			public Object command(ShardedJedis shardedJedis) {
				String str = shardedJedis.get(key);
				//System.out.println(str);
				return SerializationUtil.deserializeList(str.getBytes(), clazz);
			}
		});
	}
}
