package org.myan.cache;

import org.myan.cache.annotation.Cacheable;

/**
 * Created by myan on 2017/7/18.
 * Intellij IDEA
 */
@Cacheable(key = "tests", table = "test")
public class TestCache {
    private String name;

    private int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
