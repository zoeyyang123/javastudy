package foundation.utils;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.Maps;

import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by zhouzheng on 2017/6/8.
 */
public class Counter {

    private static Map<String,LoadingCache> counters = Maps.newHashMap();

    public static LoadingCache<String, AtomicLong> getCounter(String counterType){
        LoadingCache<String, AtomicLong> counter = null;
        synchronized (Counter.class) {
            counter = counters.get(counterType);
            if (counter == null) {
                LoadingCache<String, AtomicLong> cache =
                        CacheBuilder.newBuilder()
                                .expireAfterWrite(2, TimeUnit.SECONDS)
                                .build(new CacheLoader<String, AtomicLong>() {
                                    @Override
                                    public AtomicLong load(String ip) throws Exception {
                                        return new AtomicLong(0);
                                    }
                                });
                counters.put(counterType,cache);
            }
        }

        return counter;
    }
}
