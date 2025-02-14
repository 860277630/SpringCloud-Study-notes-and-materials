package org.example.service;

import org.example.dao.AccountMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.entity.Account;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements IAccountService {

    @Override
    @Transactional
    public void reduce(String userId, int money) {
        Account one = lambdaQuery().eq(Account::getUserId, userId).one();
        if(one != null && one.getMoney() < money){
            throw new RuntimeException("Not Enough Money ...");
        }
        lambdaUpdate().setSql("money = money - " + money)
                        .eq(Account::getUserId, userId)
                        .update();

    }
}
