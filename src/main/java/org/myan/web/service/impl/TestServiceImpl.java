package org.myan.web.service.impl;

import org.myan.web.dao.TestDao;
import org.myan.web.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by myan on 2017/7/17.
 * Intellij IDEA
 */
@Service
public class TestServiceImpl implements TestService {
    private final TestDao dao;

    @Autowired
    public TestServiceImpl(TestDao dao) {
        this.dao = dao;
    }

    @Override
    public List<String> getBases() {
        return dao.selectAll();
    }
}
