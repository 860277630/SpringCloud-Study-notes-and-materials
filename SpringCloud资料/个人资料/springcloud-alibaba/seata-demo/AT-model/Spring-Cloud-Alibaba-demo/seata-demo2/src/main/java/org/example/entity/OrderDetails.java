package org.example.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("order_details")
public class OrderDetails {
    @TableId
    private String id;
    @TableField("goods_name")
    private String goodsName;
    @TableField("count")
    private int count;
}
