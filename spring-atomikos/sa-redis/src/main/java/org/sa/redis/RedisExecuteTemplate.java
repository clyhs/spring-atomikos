package org.sa.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;


@Component
public class RedisExecuteTemplate {

    @Autowired
    private ShardedJedisPool shardedJedisPool;

    public ShardedJedis getRedisClient() {
        try {
            ShardedJedis shardJedis = shardedJedisPool.getResource();
            return shardJedis;
        } catch (Exception e) {

        }
        return null;
    }

    @SuppressWarnings("deprecation")
    public void returnResource(ShardedJedis shardedJedis) {
        shardedJedisPool.returnResource(shardedJedis);
    }

    public Object excute(ExecuteCallback executeCallback) {

        ShardedJedis shardedJedis = getRedisClient();
        if (shardedJedis == null) {
            return null;
        }
        try {
            // 通过回调方法执行具体执行
            return executeCallback.command(shardedJedis);
        } catch (Exception e) {

        } finally {
            // 释放资源
            returnResource(shardedJedis);
        }
        return null;
    }

    /**
     *
     *
     * @author zhangwei_david
     * @version $Id: RedisExecuteTemplate.java, v 0.1 2015年6月6日 下午7:45:58 zhangwei_david Exp $
     */
    public interface ExecuteCallback {

        public Object command(ShardedJedis shardedJedis);
    }
}
