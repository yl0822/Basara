package com.basara.dao.impl;

import com.basara.dao.CloudSongDao;
import com.basara.dao.base.BaseDao;
import com.basara.meta.CloudSong;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author long.yl.
 * @Date 2016/3/15
 */
@Component("cloudSongDao")
public class CloudSongDaoImpl implements CloudSongDao {

    private static Logger logger = LoggerFactory.getLogger(CloudSongDaoImpl.class);

    SqlSession sqlSession;

    @Autowired
    SqlSessionFactoryBean sqlSessionFactory;

    @PostConstruct
    public void initSession(){
        if (sqlSessionFactory == null){
            logger.error("无法从IOC容器中获取sqlSessionFactoryBean");
        }else {
            try {
                SqlSessionFactory factory = (SqlSessionFactory)sqlSessionFactory.getObject();
                logger.info("初始化并打开mybatis持有的的jdbc连接...");
                sqlSession = factory.openSession();
            }catch (Exception e){
                logger.error(e.getMessage());
            }
        }
    }

    @PreDestroy
    public void destroySession(){
        if (sqlSession != null){
            logger.info("销毁mybatis持有的的jdbc连接...");
            sqlSession.close();
        }
    }

    @Override
    public int add(CloudSong obj) {
        //不太清楚这里的statement代表什么
        int result = sqlSession.insert("CloudSongMapper.add", obj);
        sqlSession.commit();
        return result;
    }

    @Override
    public CloudSong getById() {
        return null;
    }

    @Override
    public int deleteById() {
        System.out.println("what the fuck!");
        return 0;
    }

    @Override
    public int update(CloudSong obj) {
        return 0;
    }
}
