package org.KakfaConsumer.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextConfig {
	
	private ApplicationContext ctx;

	public ApplicationContextConfig() {
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	
	public ApplicationContext getCtx() {
		return ctx;
	}
	
}
