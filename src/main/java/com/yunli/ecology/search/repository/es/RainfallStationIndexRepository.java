package com.yunli.ecology.search.repository.es;

import com.yunli.ecology.search.index.RainfallStationIndex;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * @author wangyue
 * @date 2020/11/21 4:51 PM
 */
@Repository
public interface RainfallStationIndexRepository extends ElasticsearchRepository<RainfallStationIndex, String> {
}
