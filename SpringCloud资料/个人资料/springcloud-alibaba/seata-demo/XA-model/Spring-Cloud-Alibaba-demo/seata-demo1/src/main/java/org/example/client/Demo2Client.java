package org.example.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "seata-demo2-service")
public interface Demo2Client {
    @RequestMapping("order/addCount")
    ResponseEntity<String> addCount(@RequestParam("count") int count);
}
