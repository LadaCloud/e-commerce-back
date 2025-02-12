package com.ecommercebd.order.application;

import com.ecommercebd.exception.NotFoundException;
import com.ecommercebd.helpers.Mapper;
import com.ecommercebd.order.domain.Order;
import com.ecommercebd.order.domain.OrderRepository;
import com.ecommercebd.plan.application.BusinessException;
import com.ecommercebd.plan.domain.Plan;
import com.ecommercebd.plan.domain.PlanRepository;
import com.ecommercebd.security.IsAdmin;
import com.ecommercebd.user.domain.User;
import com.ecommercebd.user.domain.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/orders")
@IsAdmin
class OrderController {

    private final Mapper mapper;
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final PlanRepository planRepository;

    @GetMapping
    List<OrderResponse> findAll(){
        return orderRepository.findAll()
                .stream()
                .map(p -> mapper.map(p, OrderResponse.class)).toList();
    }

    @GetMapping("{orderId}")
    OrderResponse findById(@PathVariable Long orderId){
        return orderRepository.findById(orderId)
                .map(p -> mapper.map(p, OrderResponse.class))
                .orElseThrow(() -> new NotFoundException("Pedido não encontrado."));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    OrderResponse create(@RequestBody @Valid NewOrderRequest newOrderRequest){
        Order order = mapper.map(newOrderRequest, Order.class);

        User customer = order.getCustomer();
        Long customerId = customer.getId();

        customer = userRepository.findById(customerId)
                .orElseThrow(() -> new BusinessException(String.format("Usuário não encontrado", customerId)));


        List<Plan> plans = new ArrayList<>();
        for (Plan plan : order.getPlans()) {
            Plan planFound = planRepository.findById(plan.getId())
                    .orElseThrow(() -> new BusinessException(String.format("Plano não encontrado", plan.getId())));

            plans.add(planFound);
        }


        order.setCustomer(customer);
        order.setPlans(plans);

        orderRepository.save(order);
        return this.mapper.map(order, OrderResponse.class);

    }

    @PutMapping("/{orderId}")
    OrderResponse update(@PathVariable Long orderId,
                         @RequestBody @Valid NewOrderRequest newOrderRequest){
        final Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new NotFoundException("Pedido não localizado."));

        this.mapper.map(newOrderRequest, order);
        this.orderRepository.save(order);
        return this.mapper.map(order, OrderResponse.class);
    }


    @DeleteMapping("{orderId}")
    void delete(@PathVariable Long orderId){
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new NotFoundException("Pedido não localizado"));
        orderRepository.delete(order);
    }

}