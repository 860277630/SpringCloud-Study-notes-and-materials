package org.example.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "seata-demo2-service")
public interface AccountFeignClient {
    @GetMapping("/accounts/reduce")
    String reduce(@RequestParam("userId") String userId, @RequestParam("money") int money);


}
