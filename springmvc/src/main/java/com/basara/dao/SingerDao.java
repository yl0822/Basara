package com.basara.dao;

import com.basara.meta.Singer;
import com.basara.meta.TextPost;
import org.apache.ibatis.annotations.*;

/**
 * @author long.yl.
 * @Date 2016/3/15
 */
public interface SingerDao {

    @Insert("insert into TB_Content_Singer(name, nickName, introduce, tag)"
            + " values (#{name}, #{nickName}, #{introduce}, #{tag})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int addObject(Singer obj);

    @Select("select * from TB_Content_Singer where id = #{id} limit 1")
    TextPost getObjectById(long id);

    @Delete("delete from TB_Content_Singer where id = #{id}")
    int deleteObjectById(long id);

    @Update("update TB_Content_Singer set name = #{name}, nickName = #{nickName}, introduce = #{introduce}, " +
            "tag = #{tag} where id = #{id}")
    int updateTitle(Singer obj);
}
