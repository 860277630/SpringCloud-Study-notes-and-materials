package org.example.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("money")
public class Money {
    @TableId
    private String id;
    @TableField("user_name")
    private String userName;
    @TableField("bank_money")
    private Double bankMoney;
}
