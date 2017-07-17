package org.myan.web.dao;

import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by myan on 2017/7/17.
 * Intellij IDEA
 */
@Repository
public interface TestDao {
    List<String> selectAll();
}
