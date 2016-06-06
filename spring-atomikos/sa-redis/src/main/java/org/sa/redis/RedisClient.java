package org.sa.redis;
public interface RedisClient {

    /**
     *
     *
     * @param key
     * @param obj
     * @param expire
     * @return
     */
    public boolean putObjectWithExpire(String key, Object obj, long expire);

    /**
     *
     *  从Redis缓存中获取key指定的对象
     * @param key
     * @param clazz
     * @return
     */
    public Object getObjectByKey(String key, Class<?> clazz);
}