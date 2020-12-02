package com.yunli.ecology.search.properties;

import com.yunli.ecology.search.enums.SceneEnum;
import com.yunli.ecology.search.enums.SearchEnum;
import lombok.Data;

import java.util.List;

/**
 * @author wangyue
 * @date 2020/11/25 10:57 AM
 */
@Data
public class SceneProperties {

    private SceneEnum scene;
    private List<SearchEnum> searchEnumList;

}
