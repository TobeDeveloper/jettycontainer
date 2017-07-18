package org.myan.cache.core;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Created by myan on 2017/7/18.
 * Intellij IDEA
 */
public class CacheDefinition<K, T> {
    private String name;
    private Class<T> cacheClass;
    private List<Object> cacheObjects;

    private int index = 0;
    private boolean registered = false;
    private Supplier<Collection<T>> defaultCollection;
    private Supplier<Map<Object, Object>> defaultMap;

    public CacheDefinition(Class<T> cacheClass,
                           List<Object> cacheObjects) {
        this(cacheClass.getName(), cacheObjects);
    }

    public CacheDefinition(
            String name,
            List<Object> cacheObjects) {
        super();
        this.name = name;
        this.cacheObjects = cacheObjects;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Class<T> getCacheClass() {
        return cacheClass;
    }

    public void setCacheClass(Class<T> cacheClass) {
        this.cacheClass = cacheClass;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public boolean isRegistered() {
        return registered;
    }

    public void setRegistered(boolean registered) {
        this.registered = registered;
    }

    public Supplier<Collection<T>> getDefaultCollection() {
        return defaultCollection;
    }

    public void setDefaultCollection(Supplier<Collection<T>> defaultCollection) {
        this.defaultCollection = defaultCollection;
    }

    public Supplier<Map<Object, Object>> getDefaultMap() {
        return defaultMap;
    }

    public void setDefaultMap(Supplier<Map<Object, Object>> defaultMap) {
        this.defaultMap = defaultMap;
    }
}
