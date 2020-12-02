package com.yunli.ecology.search.properties;

import com.yunli.ecology.search.enums.SceneEnum;
import com.yunli.ecology.search.enums.SearchEnum;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;

/**
 * @author wangyue
 * @date 2020/11/21 1:22 PM
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "ecology-fts")
public class FtsProperties {

    private Boolean showSwaggerUi;
    private String ver;
    private Map<SceneEnum, List<SearchEnum>> scene;

}
