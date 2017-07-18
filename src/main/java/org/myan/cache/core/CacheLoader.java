package org.myan.cache.core;

import java.util.Collection;
import java.util.Map;

/**
 * Created by myan on 2017/7/18.
 * Intellij IDEA
 */
public interface CacheLoader {
    void loadCaches();
    Map<String, Collection<CacheDefinition<?,?>>> getCacheDefinitions();
}
