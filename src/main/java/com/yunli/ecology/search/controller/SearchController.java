package com.yunli.ecology.search.controller;

import com.yunli.ecology.common.schema.ResponseInvoke;
import com.yunli.ecology.search.schema.request.SearchReq;
import com.yunli.ecology.search.schema.request.SuggestReq;
import com.yunli.ecology.search.schema.response.SearchInitResp;
import com.yunli.ecology.search.schema.response.SearchResp;
import com.yunli.ecology.search.service.SearchService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author wangyue
 * @date 2020/11/25 10:42 AM
 */
@Api(tags = "检索接口")
@RestController
@RequestMapping("/api/search")
public class SearchController {

    @Autowired
    private SearchService searchService;

    /**
     * 水娃欢迎页
     *
     * @return
     */
    @GetMapping("/welcome")
    @ApiOperation(value = "水娃欢迎语")
    public ResponseInvoke<List<SearchInitResp>> init() {
        return ResponseInvoke.ok(searchService.init());
    }

    /**
     * 查询
     *
     * @return
     */
    @PostMapping("/")
    @ApiOperation(value = "查询")
    public ResponseInvoke<List<SearchResp>> search(@RequestBody @Validated SearchReq searchReq) {
        return ResponseInvoke.ok(searchService.search(searchReq));
    }

    /**
     * 搜索建议
     *
     * @return
     */
    @PostMapping("/suggest")
    public ResponseInvoke suggest(@RequestBody @Validated SuggestReq suggestReq) {
        return ResponseInvoke.ok(searchService.suggest(suggestReq));
    }

}
