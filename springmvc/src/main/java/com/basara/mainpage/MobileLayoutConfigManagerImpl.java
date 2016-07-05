package com.basara.mainpage;

import com.alibaba.dubbo.common.utils.CollectionUtils;
import com.basara.mainpage.xml.MobileLayoutConfigMapper;
import com.basara.mainpage.xml.MobileLayoutFormMapper;
import com.basara.mainpage.xml.MobileUnitConfigMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author long.yl.
 * @Date 2016/6/29
 */
@Service
public class MobileLayoutConfigManagerImpl implements MobileLayoutConfigManager {

    @Autowired
    MobileLayoutConfigMapper mobileLayoutConfigMapper;

    @Autowired
    MobileUnitConfigMapper mobileUnitConfigMapper;

    @Autowired
    MobileLayoutFormMapper mobileLayoutFormMapper;

    @Override
    @Transactional
    public boolean saveLayoutConfig(MobileLayoutConfigDTO layoutDTO) {
        if (deteleLayout(layoutDTO.getPageId(), layoutDTO.getLayoutOrder(), AppConfigStatus.SAVED)) {
            int ret = mobileLayoutConfigMapper.add(layoutDTO);
            if (ret > 0) {
                long layoutId = layoutDTO.getId();
                List<MobileUnitConfigDTO> unitList = layoutDTO.getUnitList();
                for (MobileUnitConfigDTO unit : unitList) {
                    unit.setLayoutId(layoutId);
                }
                MobileLayoutForm form = layoutDTO.getLayoutForm();
                form.setLayoutId(layoutId);
                int addRet = mobileUnitConfigMapper.addList(unitList);
                if (addRet < unitList.size()) {
                    throw new RuntimeException("单元保存异常...");
                }
                return mobileLayoutFormMapper.add(form) > 0;
            }
        }
        return false;
    }

    @Override
    @Transactional
    public boolean deteleLayout(int pageId, int layoutOrder, AppConfigStatus status) {
        List<MobileLayoutConfig> layoutList = mobileLayoutConfigMapper.getLayoutByPageIdAndOrder(pageId, layoutOrder);
        if (CollectionUtils.isNotEmpty(layoutList)) {
            MobileLayoutConfig layout = layoutList.get(0);
            long layoutId = layout.getId();
            if (mobileLayoutConfigMapper.delete(layoutId) > 0) {
                return mobileUnitConfigMapper.deleteByLayoutId(layoutId) > 0
                        && mobileLayoutFormMapper.deleteByLayoutId(layoutId) > 0;
            }
        }
        return true;
    }

    @Override
    @Transactional
    public List<MobileLayoutConfigDTO> getLayoutConfigListByPageId(int pageId) {
        List<MobileLayoutConfigDTO> layoutDTOList = new ArrayList<>();
        List<MobileLayoutConfig> layout = mobileLayoutConfigMapper.getLayoutConfigListByPageId(pageId,
                AppConfigStatus.PUBLISHED.getIntValue());
        for (MobileLayoutConfig config : layout) {
            MobileLayoutConfigDTO dto = new MobileLayoutConfigDTO(config);
            List<MobileUnitConfigDTO> unitList = getUnitConfigByLayoutId(config.getId());
            dto.setUnitList(unitList);
            layoutDTOList.add(dto);
        }
        Collections.sort(layoutDTOList);
        return layoutDTOList;
    }

    @Override
    public List<MobileUnitConfigDTO> getUnitConfigByLayoutId(long layoutId) {
        List<MobileUnitConfigDTO> unitDTOList = new ArrayList<>();
        List<MobileUnitConfig> unitList = mobileUnitConfigMapper.getUnitConfigListByLayoutId(layoutId);
        for (MobileUnitConfig unit : unitList) {
            unitDTOList.add(new MobileUnitConfigDTO(unit));
        }
        Collections.sort(unitDTOList);
        return unitDTOList;
    }
}
