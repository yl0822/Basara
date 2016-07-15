package com.basara.mainpage.xml;

import com.basara.mainpage.BaseMapper;
import com.basara.mainpage.MobileLayoutForm;
import org.apache.ibatis.annotations.Param;

/**
 * @author long.yl.
 * @Date 2016/6/29
 */
public interface MobileLayoutFormMapper extends BaseMapper<MobileLayoutForm> {

    int deleteByLayoutId(@Param("layoutId") long layoutId);
}
