package com.basara.mainpage.xml;

import com.basara.mainpage.BaseMapper;
import com.basara.mainpage.MobileLayoutConfig;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author long.yl.
 * @Date 2016/6/29
 */
public interface MobileLayoutConfigMapper extends BaseMapper<MobileLayoutConfig> {

	@Select("SELECT * FROM TB_Mobile_LayoutConfig WHERE pageId = #{pageId} AND layoutOrder = #{layoutOrder}")
	List<MobileLayoutConfig> getLayoutByPageIdAndOrder(@Param("pageId") int pageId, @Param("layoutOrder") int layoutOrder);

	@Select("SELECT * FROM TB_Mobile_LayoutConfig WHERE pageId = #{pageId} AND configStatus = #{status}")
	List<MobileLayoutConfig> getLayoutConfigListByPageId(@Param("pageId") long pageId, @Param("status") int status);
}
