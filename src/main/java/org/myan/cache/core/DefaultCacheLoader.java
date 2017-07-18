package org.myan.cache.core;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.myan.cache.annotation.Cacheable;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Created by myan on 2017/7/18.
 * Intellij IDEA
 */
public class DefaultCacheLoader implements CacheLoader, ApplicationContextAware {
    private Map<String, Collection<CacheDefinition<?, ?>>> cacheDefinitions = new HashMap<>();
    private Map<String, Object> cachedClasses = null;
    private final Logger LOG = Logger.getLogger(DefaultCacheLoader.class.getName());
    private SqlSession sqlSession;

    public DefaultCacheLoader() {
        loadCaches();
    }

    @Override
    public void loadCaches() {
        //load all cacheable objects
        for (Map.Entry<String, Object> entry : cachedClasses.entrySet()) {
            if (entry != null){
                Class cacheClass = entry.getValue().getClass();
                Cacheable cacheAnnotation = (Cacheable) cacheClass.getAnnotation(Cacheable.class);
                String tableName = cacheAnnotation.table();
                LOG.info("Start fetch cache from table:"+ tableName);
                addCacheDefinition(cacheAnnotation.key(), fetch(tableName));
            }
        }
    }

    private <K, T> void addCacheDefinition(String name, List<Object> cacheObjects) {
        CacheDefinition<K, T> definition = new CacheDefinition<>(name, cacheObjects);
        Collection collection = cacheDefinitions.get(name);
        if (collection == null) {
            collection = new ArrayList();
            cacheDefinitions.put(name, collection);
        }
        definition.setIndex(collection.size());
        collection.add(definition);
    }

    @Override
    public Map<String, Collection<CacheDefinition<?, ?>>> getCacheDefinitions() {
        return cacheDefinitions;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        //cachedClasses = applicationContext.getBeansWithAnnotation(Cacheable.class);
        sqlSession = ((SqlSessionFactory)applicationContext.getBean("sqlSessionFactory")).openSession();
    }
    
    //fetch all record in a table.
    private List<Object> fetch(String tableName){
        return null;
    }
}


