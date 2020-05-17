package org.KakfaConsumer;

import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
	private Logger logger = Logger.getLogger(KafkaConsumer.class);
	private ClassPathXmlApplicationContext ctx;
	JdbcTemplate jdbcTemplate;

		
    @KafkaListener(topics = "${app.topic.foo}")
    public void listen(@Payload String message) {
    	ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
    	jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");
    	logger.info("Message: " + message);    	
    	logger.info(" Record update status: " + jdbcTemplate.update(message));   
    }
}
