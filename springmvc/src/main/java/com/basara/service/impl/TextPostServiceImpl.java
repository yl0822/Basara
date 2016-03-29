package com.basara.service.impl;

import com.basara.dao.TextPostDao;
import com.basara.meta.TextPost;
import com.basara.service.TextPostService;
import com.redis.dc.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author long.yl.
 * @Date 2016/3/15
 */
//@Service("textPostService")
public class TextPostServiceImpl implements TextPostService {

    @Autowired
    TextPostDao textPostDao;

    @Autowired
    Client hashClient;

    @Override
    @Transactional
    public boolean addTestPost(TextPost post) {
        return false;
    }

    @Override
    public boolean deleteTestPostById(long id) {
        return textPostDao.deleteObjectById(id) > 0;
    }

    @Override
    public boolean updateTestPost(TextPost post) {
        return false;
    }

    @Override
    public TextPost getTestPostById(long id) {
        hashClient.getDesc();
        return textPostDao.getObjectById(id);
    }

    @Override
    public boolean getTestPostListByTag(int tag) {
        return false;
    }
}
