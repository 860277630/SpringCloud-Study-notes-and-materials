package org.example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.example.entity.Order;

public interface IOrderService  extends IService<Order> {

    /**
     * 创建订单
     */
    void create(String userId, String commodityCode, int orderCount);
}
