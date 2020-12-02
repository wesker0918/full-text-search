package com.yunli.ecology.search.repository.es;

import com.yunli.ecology.search.index.WaterConservancyProjectIndex;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * @author wangyue
 * @date 2020/11/24 4:10 PM
 */
@Repository
public interface WaterConservancyProjectIndexRepository extends ElasticsearchRepository<WaterConservancyProjectIndex, String> {
}
