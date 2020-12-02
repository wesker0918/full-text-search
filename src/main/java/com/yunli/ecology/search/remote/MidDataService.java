package com.yunli.ecology.search.remote;

import com.yunli.ecology.common.schema.ResponseInvoke;
import com.yunli.ecology.search.remote.request.QueryDataReq;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Map;

/**
 * @author wangyue
 * @date 2020/11/24 4:45 PM
 */
@FeignClient(name = "${ecology-fts.midData.name:}", url = "${ecology-fts.midData.url:}")
public interface MidDataService {

    @PostMapping(value = "/api/middata/invokeOrginList", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseInvoke<List<Map<String, Object>>> queryData(QueryDataReq queryDataReq);

}
