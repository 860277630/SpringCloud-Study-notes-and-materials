package org.example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.example.entity.Account;

public interface IAccountService  extends IService<Account> {

    /**
     * 账户扣款
     * @param userId
     * @param money
     * @return
     */
    void reduce(String userId, int money);
}
