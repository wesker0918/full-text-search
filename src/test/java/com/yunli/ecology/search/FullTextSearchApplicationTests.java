package com.yunli.ecology.search;

import com.yunli.ecology.search.remote.MidDataService;
import com.yunli.ecology.search.remote.request.QueryDataReq;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Objects;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {FullTextSearchApplication.class})
class FullTextSearchApplicationTests {

    @Autowired
    private MidDataService midDataService;

    @Test
    void contextLoads() {
        QueryDataReq queryDataReq = new QueryDataReq();
        queryDataReq.setTableName("adm_zhslyzt_stat");
        queryDataReq.setWhereCond("station_type_code='PP'");
        queryDataReq.setQueryFields("station_code,station_name,prov_region_name,city_region_name,district_region_name,lat,lng");
        System.out.println(midDataService.queryData(queryDataReq));
    }

    public static void main(String[] args) {
    }

}
