package com.ecommercebd.database.infra;

import com.ecommercebd.database.domain.DataBase;
import com.ecommercebd.database.domain.DataBaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DataBaseJpaRepository extends JpaRepository<DataBase, Long>, DataBaseRepository {

}
