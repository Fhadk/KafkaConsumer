package org.KakfaConsumer.dao;

import org.springframework.jdbc.core.JdbcTemplate;

public class KafkaDao {
	private JdbcTemplate jdbcTemplate;
	
	public int updateRecord(String message) {
		return jdbcTemplate.update(message);
	}
}
