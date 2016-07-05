package com.basara.mainpage;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by hzlifangjian on 2016/6/12.
 */
public class BaseMeta implements Serializable {

    private static final long serialVersionUID = 5264085969136691276L;

    /**
     * 创建时间
     */
    private long createTime;

    /**
     * 最后更改时间
     */
    private Date updateTime;

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
