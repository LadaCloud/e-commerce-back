package com.ecommercebd.config;

import com.ecommercebd.helpers.RandomDataGenerator;
import com.github.javafaker.Faker;
import org.apache.commons.text.RandomStringGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RandomDataGeneratorConfig {
	
	@Bean
	public RandomDataGenerator randomDataGenerator(){
		return new RandomDataGenerator() {
			
			private static final Faker faker = Faker.instance();
			private static final RandomStringGenerator passwordGenerator = new RandomStringGenerator.Builder().build();
			
			@Override
			public String dataBaseNameGenerator() {
				return faker.cat().name().toLowerCase().replace(" ", "")
						.concat("-")
						.concat(faker.number().digits(4));
			}

			@Override
			public String generateUserName() {
				return faker.name().username()
						.concat("-")
						.concat(faker.number().digits(4));
			}

			@Override
			public String generatePassword() {
				return passwordGenerator.generate(16);
			}

		};
	}

}
