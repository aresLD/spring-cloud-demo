package com.deepexi.b.depend;

import com.deepexi.util.config.Payload;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by donh on 2018/11/5.
 */
@FeignClient("deepexi-service-a-provider")
public interface DemoClient {

    @RequestMapping(method = RequestMethod.GET, value = "/deepexi-user/api/v1/components")
    Payload list(@RequestParam(name = "page", required = false, defaultValue = "1") Integer page,
                 @RequestParam(name = "size", required = false, defaultValue = "10") Integer size,
                 @RequestParam(name = "name", required = false) String name,
                 @RequestParam(name = "type", required = false) String type,
                 @RequestParam(name = "status", required = false) String status);
}