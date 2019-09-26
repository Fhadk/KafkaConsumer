package org.KakfaConsumer.dao;

import org.springframework.jdbc.core.JdbcTemplate;

public class KafkaDao {
	private JdbcTemplate jdbcTemplate;
	
	public void updateRecord(String message) {
		jdbcTemplate.update(message);
	}
}
