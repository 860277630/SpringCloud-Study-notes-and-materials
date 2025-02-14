package org.example.controller;

import org.example.service.IAccountTCCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("accounts")
public class AccountController {

    //@Autowired
    //private IAccountService accountService;
    @Autowired
    private IAccountTCCService accountTCCService;

    @GetMapping(value = "/reduce")
    public String reduce(String userId, int money) {
        try {
            accountTCCService.tryReduce(userId, money);
        } catch (Exception exx) {
            exx.printStackTrace();
            return "FAIL";
        }
        return "SUCCESS";
    }

}
