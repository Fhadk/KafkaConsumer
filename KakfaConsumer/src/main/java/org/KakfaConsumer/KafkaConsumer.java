package org.KakfaConsumer;

import org.KakfaConsumer.config.ApplicationContextConfig;
import org.KakfaConsumer.dao.KafkaDao;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.BeanFactory;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
	private Logger logger = Logger.getLogger(KafkaConsumer.class);
	
	ApplicationContextConfig ctx;
		
    @KafkaListener(topics = "${app.topic.foo}")
    public void listen(@Payload String message) {	
    	logger.info("Message: " + message);    	
    	KafkaDao dao = (KafkaDao) ((BeanFactory) ctx.getCtx()).getBean("KafkaDao");
    	dao.updateRecord(message);
    }
}
