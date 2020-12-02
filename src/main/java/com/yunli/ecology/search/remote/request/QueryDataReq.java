package com.yunli.ecology.search.remote.request;

import lombok.Data;

import java.io.Serializable;

/**
 * @author wangyue
 * @date 2020/11/24 4:54 PM
 */
@Data
public class QueryDataReq implements Serializable {

    /**
     * 中台表名
     */
    private String tableName;

    /**
     * 查询条件
     */
    private String whereCond;

    /**
     * 查询字段
     */
    private String queryFields;

}
