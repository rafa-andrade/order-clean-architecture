package br.com.netshoes.interfaceadapter;

import br.com.netshoes.interfaceadapter.controller.OrderController;
import br.com.netshoes.interfaceadapter.mapper.OrderMapper;
import br.com.netshoes.interfaceadapter.presenter.OrderPresenter;
import br.com.netshoes.interfaceadapter.repository.mongo.OrderExternalRepository;
import br.com.netshoes.usecase.CreateOrder;
import br.com.netshoes.usecase.ListOrders;
import br.com.netshoes.usecase.ValidateOrder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DependenceConfiguration {

    @Bean
    public ValidateOrder validateOrder() {
        return new ValidateOrder();
    }

    @Bean
    public OrderMapper orderMapper() {
        return new OrderMapper();
    }

    @Bean
    public CreateOrder createOrder(ValidateOrder validateOrder, OrderExternalRepository orderExternalRepository) {
        return new CreateOrder(validateOrder, orderExternalRepository);
    }

    @Bean
    public ListOrders listOrders(OrderExternalRepository orderExternalRepository) {
        return new ListOrders(orderExternalRepository);
    }


    @Bean
    public OrderController orderController(OrderMapper orderMapper, CreateOrder createOrder) {
        return new OrderController(createOrder, orderMapper);
    }

    @Bean
    public OrderPresenter orderPresenter(OrderMapper orderMapper, ListOrders listOrders) {
        return new OrderPresenter(listOrders, orderMapper);
    }

}
