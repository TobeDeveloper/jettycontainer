package org.myan.cache.manager;

import org.myan.cache.core.CacheDefinition;
import org.myan.cache.core.CacheObject;
import org.myan.cache.core.CacheOperation;

import java.util.Map;

/**
 * Created by myan on 2017/7/18.
 * Intellij IDEA
 */
public interface CacheManager {

    <K,V> CacheObject<K,V> getCache(String name);

    <K, V> CacheObject<K, V> createCache(CacheDefinition<K,V> cacheDefinition, Map<K, V> cache);

    <V> boolean updateCache(CacheOperation function, V object);

}
