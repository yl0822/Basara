package com.basara.mainpage.xml;

import com.basara.mainpage.BaseMapper;
import com.basara.mainpage.MobileUnitConfig;
import com.basara.mainpage.MobileUnitConfigDTO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author long.yl.
 * @Date 2016/6/29
 */
public interface MobileUnitConfigMapper extends BaseMapper<MobileUnitConfig> {

    /**
     * 插入多条记录
     */
    int addList(List<MobileUnitConfigDTO> list);

    int deleteByLayoutId(@Param("layoutId") long layoutId);

    @Select("SELECT * FROM TB_Mobile_UnitConfig WHERE layoutId = #{layoutId} AND configStatus = 1")
    List<MobileUnitConfig> getUnitConfigListByLayoutId(@Param("layoutId") long layoutId);
}
