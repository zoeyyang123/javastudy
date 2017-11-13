package foundation.redis;

import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;


//@Service
public class RedisService {

//    @Resource(name = "redisTemplate")
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 保存数据
     *
     * @param key
     * @param obj
     * @return false :失败，true：成功
     */
    public boolean insertObject(final String key, final Object obj) {

        return redisTemplate.execute(new RedisCallback<Boolean>() {

            @Override
            public Boolean doInRedis(RedisConnection connection)
                    throws DataAccessException {
                RedisSerializer<String> serializer = getKeyRedisSerializer();
                byte[] keys = serializer.serialize(key);

                if (null != connection.get(keys)) {
                    return false;
                }
                JdkSerializationRedisSerializer valueSerializer = new JdkSerializationRedisSerializer();

                byte[] values = valueSerializer.serialize(obj);
                return connection.setNX(keys, values);
            }
        });
    }
    /**
     * 修改数据
     *
     * @param key
     * @param obj
     * @return false :失败，true：成功
     */
    public boolean updateObject(final String key, final Object obj) {
        return redisTemplate.execute(new RedisCallback<Boolean>() {
            @Override
            public Boolean doInRedis(RedisConnection connection)
                    throws DataAccessException {
                RedisSerializer<String> serializer = getKeyRedisSerializer();
                byte[] keys = serializer.serialize(key);
                if (null != connection.get(keys)) {
                    if (1 == connection.del(keys)) {
                        JdkSerializationRedisSerializer valueSerializer = new JdkSerializationRedisSerializer();
                        byte[] values = valueSerializer.serialize(obj);
                        return connection.setNX(keys, values);
                    }
                    return false;
                }
                return false;
            }
        });
    }
    /**
     * 删除数据
     *
     * @param key
     * @return false :失败，true：成功
     */
    public boolean deleteObject(final String key) {
        return redisTemplate.execute(new RedisCallback<Boolean>() {
            @Override
            public Boolean doInRedis(RedisConnection connection)
                    throws DataAccessException {
                RedisSerializer<String> serializer = getKeyRedisSerializer();
                byte[] keys = serializer.serialize(key);
                if (1 == connection.del(keys)) {
                    return true;
                }
                return false;
            }
        });

    }
    /**
     * 按Key查询
     * @param key
     * @return
     */
    public Object queryDataFromRedis(final String key) {
        return redisTemplate.execute(new RedisCallback<Object>() {
            public Object doInRedis(RedisConnection connection)
                    throws DataAccessException {
                RedisSerializer<String> serializer = getKeyRedisSerializer();
                byte[] keys = serializer.serialize(key);
                byte[] values = connection.get(keys);
                if (values == null) {
                    return null;
                }
                JdkSerializationRedisSerializer valueSerializer = new JdkSerializationRedisSerializer();
                return valueSerializer.deserialize(values);
            }
        });
    }
    private RedisSerializer<String> getKeyRedisSerializer() {
        return redisTemplate.getStringSerializer();
    }


}
