package com.basara.mainpage;

import com.basara.mainpage.unit.MobileDividerUnit;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author long.yl.
 * @Date 2016/6/28
 */
@Service
public class MobileMainPageServiceImpl implements MobileMainPageService {

    @Autowired
    MobileLayoutConfigManager mobileLayoutConfigManager;

    @Override
    public BaseJsonVO getMutativeUnitList(int scenicId, int pageIndex, String deviceType) {
        MobilePaginationListVO layoutVO = new MobilePaginationListVO();
        List<MobileUnitGroupVO> unitGroupVOList = new ArrayList<>();

        if (pageIndex <= 0) {
            List<MobileLayoutConfigDTO> layoutList = mobileLayoutConfigManager.getLayoutConfigListByPageId(scenicId);
            // 版面配置信息
            int i = 0;
            for (MobileLayoutConfigDTO layout : layoutList) {
                i++;
                MobileUnitGroupVO unitGroupVO = new MobileUnitGroupVO();
                unitGroupVO.setId(String.valueOf(layout.getId()));
                unitGroupVO.setIcon(layout.getIcon());
                unitGroupVO.setName(layout.getTitle());
                unitGroupVO.setShowMore(layout.getShowMore());
                unitGroupVO.setMoreLink(layout.getLinkUrl());
                unitGroupVO.setSummary(layout.getSummary());

                List<MobileUnitVO> unitVOList = new ArrayList<>();
                List<MobileUnitConfigDTO> unitConfigList = layout.getUnitList();
                // 版面内单元的配置信息
                for (MobileUnitConfig unit : unitConfigList) {
                    MobileUnitVO unitVO = new MobileUnitVO();
                    int unitType = unit.getUnitType();
                    unitVO.setUnitId(unitType);

                    // 转换图片宽高比
                    unitVO.setRatio(0);
                    if (StringUtils.isNotEmpty(unit.getRatio())) {
                        String[] ratio = unit.getRatio().split(":");
                        if (ratio.length == 2) {
                            double width = Double.parseDouble(ratio[0]);
                            double height = Double.parseDouble(ratio[1]);
                            unitVO.setRatio(width / height);
                        }
                    }
                    /** 单元中的坑位内容-Jason格式字符串 */
                    String jasonUnitContent = unit.getContent();
                    if (unitType == 100) {
                        //2.2.0版本根据设备给定空白单元高度
                        jasonUnitContent = getBlankUnit(jasonUnitContent, deviceType);
                    }
                    unitVO.setUnitContent(JsonUtils.toJSONObject(jasonUnitContent));
                    unitVOList.add(unitVO);
                }
                unitGroupVO.setUnitList(unitVOList);
                unitGroupVOList.add(unitGroupVO);
            }
        }
        layoutVO.setList(unitGroupVOList);
        return new BaseJsonVO(layoutVO);
    }

    private String getBlankUnit(String jasonUnitContent, String deviceType) {
        MobileDividerUnit dividerUnit = JsonUtils.fromJson(jasonUnitContent, MobileDividerUnit.class);
        if (null != dividerUnit) {
            if (deviceType != null && "android".equals(deviceType)) {
                if (dividerUnit.getHeight() != null && dividerUnit.getHeight().split("-").length >= 2) {
                    dividerUnit.setHeight(dividerUnit.getHeight().split("-")[0]);
                }
            } else if (deviceType != null && "ios".equals(deviceType)) {
                if (dividerUnit.getHeight() != null && dividerUnit.getHeight().split("-").length >= 2) {
                    dividerUnit.setHeight(dividerUnit.getHeight().split("-")[1]);
                }
            }
        }
        return JsonUtils.toJson(dividerUnit);
    }
}
