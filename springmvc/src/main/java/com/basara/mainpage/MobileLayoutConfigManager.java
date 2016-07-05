package com.basara.mainpage;

import java.util.List;

/**
 * @author long.yl.
 * @Date 2016/6/29
 */
public interface MobileLayoutConfigManager {

    boolean saveLayoutConfig(MobileLayoutConfigDTO layout);

    boolean deteleLayout(int pageId, int layoutOrder, AppConfigStatus status);

    List<MobileLayoutConfigDTO> getLayoutConfigListByPageId(int pageId);

    List<MobileUnitConfigDTO> getUnitConfigByLayoutId(long layoutId);
}
