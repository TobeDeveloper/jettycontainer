package org.myan.cache.manager;

import org.myan.cache.core.CacheDefinition;
import org.myan.cache.core.CacheObject;
import org.myan.cache.core.CacheOperation;

import java.util.Map;

/**
 * Created by myan on 2017/7/18.
 * Intellij IDEA
 */
public class DefaultCacheManager extends AbstractCacheManager {
    @Override
    public void clearCache() {

    }

    @Override
    public <K, V> CacheObject<K, V> getCache(String name) {
        return null;
    }

    @Override
    public <K, V> CacheObject<K, V> createCache(CacheDefinition<K, V> cacheDefinition, Map<K, V> cache) {
        return null;
    }

    @Override
    public <V> boolean updateCache(CacheOperation function, V object) {
        return false;
    }
}
