package com.ecommercebd.database.domain;

import com.ecommercebd.user.domain.User;

import java.util.List;
import java.util.Optional;

public interface DataBaseRepository {
	List<DataBase> findAll();
	User save(DataBase entity);
	Optional<DataBase> findById(Long id);
	void delete(DataBase entity);
}
