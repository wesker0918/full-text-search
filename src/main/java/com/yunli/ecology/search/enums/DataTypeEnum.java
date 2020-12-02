package com.yunli.ecology.search.enums;

import com.yunli.ecology.common.schema.BaseEnum;

/**
 * 数据类型
 *
 * @author wangyue
 * @date 2020/11/25 6:44 PM
 */
public enum DataTypeEnum implements BaseEnum {
    /**
     * 雨量站
     */
    PP("雨量站"),
    /**
     * 河道水情站
     */
    ZQ("河道水情站"),
    /**
     * 水库水情站
     */
    RR("水库水情站"),
    /**
     * 土壤墒情站
     */
    SS("土壤墒情站"),
    /**
     * 联系人
     */
    CS("联系人"),
    /**
     * 河长
     */
    RC("河长"),
    /**
     * 水电站
     */
    HP("水电站"),
    /**
     * 水库
     */
    RES("水库"),
    /**
     * 水闸
     */
    GATE("水闸"),
    /**
     * 提防
     */
    DIKE("提防"),
    /**
     * 水泵站
     */
    PUMP("水泵站"),
    ;

    private String desc;

    DataTypeEnum(String desc) {
        this.desc = desc;
    }

    @Override
    public Integer getCode() {
        return null;
    }

    @Override
    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
