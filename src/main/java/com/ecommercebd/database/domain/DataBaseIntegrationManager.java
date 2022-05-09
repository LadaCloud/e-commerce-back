package com.ecommercebd.database.domain;

public interface DataBaseIntegrationManager {
	void ping(DataBase dataBase);
	void create(DataBase dataBase);
	void delete(DataBase dataBase);
	void update(DataBase dataBase);
}
