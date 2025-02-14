package org.example.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.example.dao.OrderDetailsMapper;
import org.example.entity.OrderDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class OrderDetailsServiceImpl extends ServiceImpl<OrderDetailsMapper, OrderDetails> implements OrderDetailsService {

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateOrderDetails(Integer count) {
        List<OrderDetails> list = this.list();
        // 取第一个进行
        OrderDetails orderDetails = list.get(0);
        if (orderDetails.getCount()>=count) {
            int sum = orderDetails.getCount() - count;
            orderDetails.setCount(sum);
            this.updateById(orderDetails);
            log.info("库存扣减成功");
        }else{
            throw new RuntimeException("库存为："+list.get(0).getCount()+"不足，开始回滚");
        }
    }
}
