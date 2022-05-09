package com.ecommercebd.database.infra;

import com.ecommercebd.database.domain.DataBase;
import com.ecommercebd.database.domain.DataBaseIntegrationManager;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MySQLDataBaseIntegrationManager implements DataBaseIntegrationManager {

	private final JdbcTemplate jdbcTemplate;
	@Override
	public void ping(DataBase dataBase) {
		
	}

	@Override
	public void create(DataBase dataBase) {
		jdbcTemplate.execute(String.format("CREATE DATABASE %s", dataBase.getName()));
	}

	@Override
	public void delete(DataBase dataBase) {

	}

	@Override
	public void update(DataBase dataBase) {

	}
}
