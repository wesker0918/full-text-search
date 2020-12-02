package com.yunli.ecology.search.schema.request;

import com.yunli.ecology.search.enums.SceneEnum;
import com.yunli.ecology.search.enums.SearchEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author wangyue
 * @date 2020/11/25 11:24 AM
 */
@Data
@ApiModel
public class SearchReq {

    @NotNull
    @ApiModelProperty(name = "场景", required = true)
    private SceneEnum scene;

    @ApiModelProperty(name = "查询限定范围")
    private SearchEnum searchKey;

    @NotEmpty
    @ApiModelProperty(name = "查询内容", required = true)
    private String content;

}
