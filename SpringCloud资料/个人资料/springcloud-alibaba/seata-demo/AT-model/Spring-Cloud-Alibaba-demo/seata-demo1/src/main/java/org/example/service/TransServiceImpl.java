package org.example.service;

import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.example.client.Demo2Client;
import org.example.entity.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class TransServiceImpl implements TransService {
    @Autowired
    private MoneyService moneyService;

    @Autowired
    private Demo2Client demo2Client;

    /**
     * 分布式事务   回滚例子
     */
    @GlobalTransactional
    public void globalRollBackDemo(int orderCount) {
        log.info("=================开始扣钱========================");
        List<Money> list = moneyService.list();
        Money money = list.get(0);
        Double bankMoney = money.getBankMoney();
        log.info("=================查询到银行余额为："+bankMoney+",开始扣款：20=================");
        moneyService.changeMoney(money,20D);
        log.info("=================扣款成功，开始扣库存，扣减库存为："+orderCount+"========================");
        demo2Client.addCount(orderCount);
    }
}
