package com.deepexi.a.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.deepexi.a.domain.eo.Component;
import com.deepexi.a.service.ComponentService;
import com.deepexi.util.config.Payload;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "componentcontroller", description = "组件管理")
@RestController
@RequestMapping("/api/v1/components")
public class ComponentController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ComponentService componentService;

    @ApiOperation(value = "过滤条件查询所有组件", notes = "", httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "第几页", required = false, dataType = "Integer"),
            @ApiImplicitParam(name = "size", value = "每页查询数", required = false, dataType = "Integer"),
            @ApiImplicitParam(name = "name", value = "组件名称", required = false, dataType = "String"),
            @ApiImplicitParam(name = "type", value = "分类", required = false, dataType = "String"),
            @ApiImplicitParam(name = "status", value = "状态", required = false, dataType = "String")
    })
    @GetMapping
    public Payload getProductList(@RequestParam(name = "page", required = false, defaultValue = "1") Integer page,
                                  @RequestParam(name = "size", required = false, defaultValue = "10") Integer size,
                                  @RequestParam(name = "name", required = false) String name,
                                  @RequestParam(name = "type", required = false) String type,
                                  @RequestParam(name = "status", required = false) String status) {
        return new Payload(componentService.getComponentList(page, size, name, type, status));
    }

    @GetMapping("/{id:[a-zA-Z0-9]+}")
    public Payload getProductById(@PathVariable("id") String id) {
        return new Payload(componentService.getComponentById(id));
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Payload createProduct(@RequestBody Component component) {
        return new Payload(componentService.createComponent(component));
    }

    @PutMapping(value = "/{id:[a-zA-Z0-9]+}",produces = MediaType.APPLICATION_JSON_VALUE)
    public Payload updateProductById(@PathVariable("id") String id, @RequestBody Component component) {
        component.setId(id);
        return new Payload(componentService.updateComponent(component));
    }

    @DeleteMapping
    public Payload deleteProductById(@RequestBody List<String> ids) {
        return new Payload(componentService.deleteComponentById(ids));
    }

    @GetMapping("/testSentinel")
    @SentinelResource(value = "testSentinel", blockHandler = "exceptionHandler")
    public Integer testSentinel(@RequestParam Integer a, @RequestParam Integer b) {
        logger.info("远程Sentinel测试接口成功: Hello World!!");
        return a + b;
    }

}
