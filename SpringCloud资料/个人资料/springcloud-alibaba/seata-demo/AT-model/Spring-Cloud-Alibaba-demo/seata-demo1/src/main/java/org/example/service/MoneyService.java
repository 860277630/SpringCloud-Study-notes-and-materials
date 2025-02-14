package org.example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.example.entity.Money;

public interface MoneyService extends IService<Money> {
    void changeMoney(Money money,Double num);
}
