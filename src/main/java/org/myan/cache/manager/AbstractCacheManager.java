package org.myan.cache.manager;


/**
 * Created by myan on 2017/7/18.
 * Intellij IDEA
 */
public abstract class AbstractCacheManager implements CacheManager {

    abstract void clearCache();

//    abstract <K, V> V get(CacheObject<K, V> cache, Filter filter);

}
