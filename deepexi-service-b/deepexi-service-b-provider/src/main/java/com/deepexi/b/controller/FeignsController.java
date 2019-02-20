package com.deepexi.b.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.deepexi.b.extension.ApplicationException;
import com.deepexi.b.service.ProductService;
import com.deepexi.b.depend.DemoClient;
import com.deepexi.b.domain.eo.Product;
import com.deepexi.util.config.Payload;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by donh on 2018/11/5.
 */
@RequestMapping("/api/v1/feigns")
@RestController
public class FeignsController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private DemoClient demolient;

    @GetMapping("/testFeign")
    public Payload testFeign(@RequestParam(name = "page", required = false, defaultValue = "1") Integer page,
                                    @RequestParam(name = "size", required = false, defaultValue = "10") Integer size,
                                    @RequestParam(name = "name", required = false) String name,
                                    @RequestParam(name = "type", required = false) String type,
                                    @RequestParam(name = "status", required = false) String status) {
        logger.info("远程调用deepexi-service-a-provider");
        return demolient.list(page,size,name,type,status);
    }
}
