package com.ecommercebd.database.domain;

import com.ecommercebd.order.domain.Order;
import com.ecommercebd.plan.domain.Plan;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "`database`")
@Builder
public class DataBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //TODO UNIQUE
    private String name;
    private int port;
    private String password;
    private String username;
    private String timeZone;

    private Long storage;
    private int limitOfConnections;
    private int limitOfUsers;
    
    @ManyToOne
    @JoinColumn(name = "order_id",
            foreignKey = @ForeignKey(name = "fk_database_order_id"))
    private Order order;

    @ManyToOne
    @JoinColumn(name = "plan_id",
            foreignKey = @ForeignKey(name = "fk_database_plan_id"))
    private Plan plan;

    @Enumerated(EnumType.ORDINAL)
    private Status status;
    
    public enum Status {
        PENDING,
        UP,
        DOWN
    }
}
