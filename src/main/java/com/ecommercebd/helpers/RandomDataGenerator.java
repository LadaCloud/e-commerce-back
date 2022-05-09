package com.ecommercebd.helpers;

import org.springframework.context.annotation.Configuration;

public interface RandomDataGenerator {
    String dataBaseNameGenerator();
    String generateUserName();
    String generatePassword();
}
