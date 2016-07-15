package com.basara.enums;

import com.basara.enums.base.BaseTag;

/**
 * @author long.yl.
 * @Date 2016/3/15
 */
public enum PostTag implements BaseTag<PostTag> {
    NULL(0, "未归类"),
    POLITCAL(1, "政治"),
    SPORT(2, "体育"),
    ENTERTAMENT(3, "娱乐");

    private int value;

    private String tag;

    private PostTag(int value, String tag) {
        this.tag = tag;
        this.value = value;
    }


    @Override
    public int getIntValue() {
        return value;
    }

    @Override
    public PostTag genEnumByIntValue(int intValue) {
        for (PostTag item : PostTag.values()) {
            if (item.value == intValue)
                return item;
        }
        return NULL;
    }
}
