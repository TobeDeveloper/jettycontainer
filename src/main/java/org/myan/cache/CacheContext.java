package org.myan.cache;

import org.myan.cache.core.CacheLoader;
import org.myan.cache.core.CacheObject;
import org.myan.cache.core.DefaultCacheLoader;
import org.myan.cache.manager.CacheManager;

/**
 * Created by myan on 2017/7/18.
 * Intellij IDEA
 */
public final class CacheContext {

    private CacheObject<String, Object> caches;

    private CacheManager manager;

    private CacheLoader loader = new DefaultCacheLoader();

    public void initialize() {
        //get the cache manager

        //
    }
}
