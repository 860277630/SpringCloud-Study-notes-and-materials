package org.example.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.entity.Order;
import org.example.feign.AccountFeignClient;
import org.example.dao.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {

    @Autowired
    private AccountFeignClient accountFeignClient;

    @Override
    @Transactional
    public void create(String userId, String commodityCode, int count) {
        // 定单总价 = 订购数量(count) * 商品单价(100)
        int orderMoney = count * 100;
        // 生成订单
        Order order = new Order();
        order.setCount(count);
        order.setCommodityCode(commodityCode);
        order.setUserId(userId);
        order.setMoney(orderMoney);
        super.save(order);

        // 调用账户余额扣减
        String result = accountFeignClient.reduce(userId, orderMoney);
        if (!"SUCCESS".equals(result)) {
            throw new RuntimeException("Failed to call Account Service. ");
        }

    }
}
