package com.ecommercebd.database.domain;

import java.util.List;
import java.util.Optional;

public interface DataBaseRepository {
	List<DataBase> findAll();
	DataBase save(DataBase entity);
	Optional<DataBase> findById(Long id);
	void delete(DataBase entity);
}
