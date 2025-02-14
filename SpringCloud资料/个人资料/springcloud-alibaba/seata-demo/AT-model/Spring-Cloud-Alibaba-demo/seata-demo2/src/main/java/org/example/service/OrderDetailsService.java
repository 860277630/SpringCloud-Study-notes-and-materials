package org.example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.example.entity.OrderDetails;

public interface OrderDetailsService extends IService<OrderDetails> {

    //  修改库存剩余
    void updateOrderDetails(Integer count);

}
