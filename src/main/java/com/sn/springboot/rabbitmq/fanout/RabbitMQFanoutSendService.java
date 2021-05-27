package com.sn.springboot.rabbitmq.fanout;

import com.sn.springboot.rabbitmq.RabbitMQSendService;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQFanoutSendService implements RabbitTemplate.ConfirmCallback, RabbitMQSendService {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public void sendMessage(String message) {
        // 设置发送消息是否已被消费的回调
        rabbitTemplate.setConfirmCallback(this);
        System.out.println("发送的消息：" + message);
        // 和FanoutExchange绑定的消息队列都能收到消息
        rabbitTemplate.convertAndSend(RabbitMQFanoutConfig.FANOUT_NAME, null, message);
    }

    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        if (ack) {
            System.out.println("消息发送成功");
        } else {
            System.out.println("消息发送失败：" + cause);
        }
    }
}
