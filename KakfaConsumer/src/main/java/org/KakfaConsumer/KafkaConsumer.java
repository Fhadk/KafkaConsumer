package org.KakfaConsumer;

import org.KakfaConsumer.dao.KafkaDao;
import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
	private Logger logger = Logger.getLogger(KafkaConsumer.class);
	private ClassPathXmlApplicationContext ctx;
	private KafkaDao dao;

		
    @KafkaListener(topics = "${app.topic.foo}")
    public void listen(@Payload String message) {
    	ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
    	dao = (KafkaDao) ctx.getBean("KafkaDao");
    	logger.info("Message: " + message);    	
    	logger.info(" Record update status: " + dao.updateRecord(message));   
    }
}
