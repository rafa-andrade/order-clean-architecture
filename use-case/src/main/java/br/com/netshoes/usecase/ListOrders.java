package br.com.netshoes.usecase;

import br.com.netshoes.repository.OrderRepository;
import br.com.netshoes.interfaceadapter.Order;

import java.util.List;

public class ListOrders {

    private OrderRepository orderRepository;

    public ListOrders(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> listOrders() {
        return orderRepository.listOrders();
    }

}
