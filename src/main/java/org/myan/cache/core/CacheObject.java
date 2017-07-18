package org.myan.cache.core;

/**
 * Created by myan on 2017/7/18.
 * Intellij IDEA
 */
public interface CacheObject<K, V> {
    CacheDefinition<K, V> getCacheDefinition();
    String getName();
    void change(CacheOperation function, Object object, boolean sortable, boolean skipSorting);
    void sortCache();
}
