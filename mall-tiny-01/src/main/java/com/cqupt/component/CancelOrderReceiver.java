package com.cqupt.component;

import com.cqupt.service.OmsPortalOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * @author jingdong
 * @description: 取消订单消息的处理者
 * @menu
 * @date 2022/5/16 21:12
 */
@Component
@RabbitListener(queues = "mall.order.cancel")
public class CancelOrderReceiver {
    private static Logger LOGGER = LoggerFactory.getLogger(CancelOrderReceiver.class);
    @Autowired
    private OmsPortalOrderService portalOrderService;

    public void handle(Long orderId){
        LOGGER.info("receive delay message orderId:{}", orderId);
        portalOrderService.cancelOrder(orderId);
    }
}
