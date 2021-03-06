package com.cqupt.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author jingdong
 * @description: 消息队列枚举配置
 * @menu
 * @date 2022/5/16 20:47
 */
@Getter
@AllArgsConstructor
public enum  QueueEnum {
    QUEUE_ORDER_CANCEL("mall.order.direct", "mall.order.cancel", "mall.order.cancel"),
    QUEUE_TTL_ORDER_CANCEL("mall.order.direct.ttl", "mall.order.cancel.ttl", "mall.order.cancel.ttl");

    /**
     * 交换名称
     */
    private String exchange;
    /**
     * 队列名称
     */
    private String name;
    /**
     * 路由键
     */
    private String routeKey;

//    QueueEnum(String exchange, String name, String routeKey) {
//        this.exchange = exchange;
//        this.name = name;
//        this.routeKey = routeKey;
//    }
}
