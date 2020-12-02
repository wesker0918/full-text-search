package com.yunli.ecology.search.configuration;

import org.apache.commons.lang.StringUtils;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.elasticsearch.rest.RestClientProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

/**
 * @author wangyue
 * @date 2020/11/21 1:27 PM
 */
@Configuration
@EnableElasticsearchRepositories
public class EsRestClientConfiguration extends AbstractElasticsearchConfiguration {

    @Autowired
    private RestClientProperties restClientProperties;

    @Bean
    @Override
    public RestHighLevelClient elasticsearchClient() {
        final ClientConfiguration clientConfiguration = ClientConfiguration.builder()
                .connectedTo(StringUtils.join(restClientProperties.getUris(), ","))
                .build();
        return RestClients.create(clientConfiguration).rest();
    }

    @Bean
    public ElasticsearchRestTemplate elasticsearchRestTemplate() throws Exception {
        return new ElasticsearchRestTemplate(elasticsearchClient());
    }

}
