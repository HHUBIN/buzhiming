package com.buzhiming.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.concurrent.TimeUnit;

/**
 * Redis工具类
 * @author ZENG.XIAO.YAN
 * @date   2018年6月7日
 */
@Component
public final class RedisUtil {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
        // =============================common============================
        /**
         * 指定缓存失效时间
         * @param key 键
         * @param time 时间(秒)
         * @return
         */
    public boolean expire(String key, long time) {
        try {
            if (time > 0) {
                redisTemplate.expire(key, time, TimeUnit.SECONDS);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
        /**
         * 根据key 获取过期时间
         * @param key 键 不能为null
         * @return 时间(秒) 返回0代表为永久有效
         */
    public long getExpire(String key) {
        return redisTemplate.getExpire(key, TimeUnit.SECONDS);
    }
        /**
         * 判断key是否存在
         * @param key 键
         * @return true 存在 false不存在
         */
    public boolean hasKey(String key) {
        try {
            return redisTemplate.hasKey(key);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
        /**
         * 删除缓存
         * @param key 可以传一个值 或多个
         */
    @SuppressWarnings("unchecked")
    public void del(String... key) {
        if (key != null && key.length > 0) {
            if (key.length == 1) {
                redisTemplate.delete(key[0]);
            } else {
                redisTemplate.delete(CollectionUtils.arrayToList(key));
            }
        }
    }
        // ============================String=============================
        /**
         * 普通缓存获取
         * @param key 键
         * @return 值
         */
    public Object get(String key) {
        return key == null ? null : redisTemplate.opsForValue().get(key);
    }

        /**
         * 普通缓存放入
         * @param key 键
         * @param value 值
         * @return true成功 false失败
         */
    public boolean set(String key, Object value) {
        try {
            redisTemplate.opsForValue().set(key, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
        /**
         109
         * 普通缓存放入并设置时间
         110
         * @param key 键
        111
         * @param value 值
        112
         * @param time 时间(秒) time要大于0 如果time小于等于0 将设置无限期
        113
         * @return true成功 false 失败
        114
         */
    public boolean set(String key, Object value, long time) {
        try {
            if (time > 0) {
                redisTemplate.opsForValue().set(key, value, time, TimeUnit.SECONDS);
            } else {
                set(key, value);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
        /**
         *          * 递增
         *          * @param key 键
         *          * @param delta 要增加几(大于0)
         *          * @return
         *          */

    public long incr(String key, long delta) {
         if(delta < 0) {
         throw new RuntimeException("递增因子必须大于0");

        }
         return redisTemplate.opsForValue().increment(key, delta);
    }
  /**
          *          143
          *          * 递减
          *          144
          *          * @param key 键
          *         145
          *          * @param delta 要减少几(小于0)
          *         146
          *          * @return
          *         147
          *          */

    public long decr(String key, long delta) {
         if(delta < 0) {
         throw new RuntimeException("递减因子必须大于0");
        }
         return redisTemplate.opsForValue().increment(key, -delta);
    }
}
