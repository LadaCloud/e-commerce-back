package com.ecommercebd.database.domain;

import com.ecommercebd.order.domain.Order;
import com.ecommercebd.plan.domain.Plan;
import com.github.javafaker.Faker;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class DataBaseService {
	
	private final DataBaseRepository dataBaseRepository;
	private final DataBaseIntegrationManager dataBaseIntegrationManager;
	
	public List<DataBase> createBy(Order order) {
		List<DataBase> dataBases = new ArrayList<>();
		for (Plan plan : order.getPlans()) {
			DataBase dataBase = DataBase.builder()
					.order(order)
					.plan(plan)
					.limitOfConnections(plan.getLimitOfConnections())
					.limitOfUsers(plan.getLimitOfUsers())
					.storage(plan.getStorage())
					.build();
			dataBaseRepository.save(dataBase);
			dataBases.add(dataBase);
		}
		return dataBases;
	}

	public void delete(Long id) {
		
	}
	
}
