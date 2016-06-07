package org.sa.redis;

import java.util.List;

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
    
    
    public boolean deleteObjectByKey(String key);
    
    
    public boolean putArrayWithExpire(String key,List<?> list,long expire);
    
    public List<?> getArrayWithExpire(String key,Class<?> clazz);
}