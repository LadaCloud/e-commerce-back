package com.ecommercebd.database.domain;

import com.ecommercebd.helpers.RandomDataGenerator;
import com.ecommercebd.order.domain.Order;
import com.ecommercebd.plan.domain.Plan;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class DataBaseService {
	
	private final DataBaseRepository dataBaseRepository;
	private final DataBaseIntegrationManager dataBaseIntegrationManager;
	private final RandomDataGenerator generator;
	
	public List<DataBase> createBy(Order order) {
		List<DataBase> dataBases = new ArrayList<>();
		for (Plan plan : order.getPlans()) {
			DataBase dataBase = DataBase.builder()
					.status(DataBase.Status.PENDING)
					.order(order)
					.plan(plan)
					.limitOfConnections(plan.getLimitOfConnections())
					.limitOfUsers(plan.getLimitOfUsers())
					.storage(plan.getStorage())
					.name(generator.generateUserName())
					.password(generator.generatePassword())
					.username(generator.dataBaseNameGenerator())
					.build();
			
			dataBaseRepository.save(dataBase);
			dataBases.add(dataBase);
			dataBaseIntegrationManager.create(dataBase);

			dataBaseIntegrationManager.ping(dataBase);
			dataBase.setStatus(DataBase.Status.UP);
			dataBaseRepository.save(dataBase);
		}
		return dataBases;
	}

	public void delete(Long id) {
		
	}
	
}
