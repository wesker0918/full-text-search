package com.yunli.ecology.search.repository.es;

import com.yunli.ecology.search.index.ReservoirHydrologicalStationIndex;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * @author wangyue
 * @date 2020/11/24 4:09 PM
 */
@Repository
public interface ReservoirHydrologicalStationIndexRepository extends ElasticsearchRepository<ReservoirHydrologicalStationIndex, String> {
}
