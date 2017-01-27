package br.com.netshoes.interfaceadapter.controller;

import br.com.netshoes.interfaceadapter.Order;
import br.com.netshoes.interfaceadapter.dto.OrderDTO;
import br.com.netshoes.interfaceadapter.mapper.OrderMapper;
import br.com.netshoes.usecase.CreateOrder;

public class OrderController {

    private OrderMapper orderMapper;

    private CreateOrder createOrder;

    public OrderController(CreateOrder createOrder, OrderMapper orderMapper) {
        this.createOrder = createOrder;
        this.orderMapper = orderMapper;
    }

    public void createOrder(OrderDTO orderDTO) {
        Order order = orderMapper.mapToEntity(orderDTO);
        createOrder.createOrder(order);
    }

}
