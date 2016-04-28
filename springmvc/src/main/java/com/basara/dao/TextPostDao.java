package com.basara.dao;

import com.basara.dao.base.BaseDao;
import com.basara.meta.TextPost;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

/**
 * @author long.yl.
 * @Date 2016/3/15
 */
@Component
public interface TextPostDao{

    /**
     * 这里不能返回刚刚添加的对象，所以如果业务有需求，需要和getObject一起使用
     * 这里可以返回void和int（表示本操作对数据库修改的记录条数）
     * */
    @Insert("insert into TB_Content_TextPost(title, content, authName, createTime, tag)"
            + " values (#{title}, #{content}, #{authName}, #{createTime}, #{tag})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int addObject(TextPost post);

    @Select("select * from TB_Content_TextPost where id = #{id} limit 1")
    TextPost getObjectById(long id);

    @Delete("delete from TB_Content_TextPost where id = #{id}")
    int deleteObjectById(long id);

    @Update("update TB_Content_TextPost set title = #{title}, content = #{content}, authName = #{authName}, " +
            "createTime = #{createTime}, tag = #{tag} where id = #{id}")
    int updateTitle(TextPost post);
}
