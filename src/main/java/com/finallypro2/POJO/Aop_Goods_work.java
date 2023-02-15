package com.finallypro2.POJO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Aop_Goods_work {
    private Goods_work goods_work;
    private String phone;

    public Aop_Goods_work(Goods_work goods_work) {
        this.goods_work = goods_work;
    }
}
