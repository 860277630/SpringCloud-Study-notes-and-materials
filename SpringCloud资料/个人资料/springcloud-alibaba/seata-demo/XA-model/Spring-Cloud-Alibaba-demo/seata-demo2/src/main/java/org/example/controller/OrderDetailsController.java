package org.example.controller;

import org.example.entity.OrderDetails;
import org.example.service.OrderDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("order")
public class OrderDetailsController {
    @Autowired
    private OrderDetailsService orderService;

    @RequestMapping("addCount")
    public ResponseEntity<String> addCount(@RequestParam("count") Integer count) {
        orderService.updateOrderDetails(count);
        return new ResponseEntity<String>("success",HttpStatus.OK);
    }


}
