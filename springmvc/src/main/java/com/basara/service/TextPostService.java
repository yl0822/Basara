package com.basara.service;

import com.basara.meta.TextPost;

/**
 * @author long.yl.
 * @Date 2016/3/15
 */
public interface TextPostService {
    boolean addTestPost(TextPost post);

    boolean deleteTestPostById(long id);

    boolean updateTestPost(TextPost post);

    TextPost getTestPostById(long id);

    boolean getTestPostListByTag(int tag);
}
