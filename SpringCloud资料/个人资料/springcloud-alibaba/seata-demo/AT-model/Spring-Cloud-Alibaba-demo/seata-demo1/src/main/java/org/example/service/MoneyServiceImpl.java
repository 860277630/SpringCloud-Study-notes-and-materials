package org.example.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.example.dao.MoneyMapper;
import org.example.entity.Money;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MoneyServiceImpl extends ServiceImpl<MoneyMapper, Money> implements MoneyService{

    @Transactional
    public void changeMoney(Money money, Double num) {
        Double bankMoney = money.getBankMoney();
        if (bankMoney >= num) {
            money.setBankMoney(bankMoney - num);
            this.updateById(money);
        }else{
            throw new RuntimeException("余额不足");
        }
    }
}
