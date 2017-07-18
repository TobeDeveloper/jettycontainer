package org.myan.cache.core;

/**
 * Created by myan on 2017/7/18.
 * Intellij IDEA
 */
public enum CacheOperation {
    UPDATE(0),
    DELETE(1);

    private final int value;

    private CacheOperation(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
