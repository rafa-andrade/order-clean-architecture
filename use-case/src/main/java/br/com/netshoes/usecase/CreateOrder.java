package br.com.netshoes.usecase;


import br.com.netshoes.repository.OrderRepository;
import br.com.netshoes.interfaceadapter.Order;

public class CreateOrder {

    private ValidateOrder validateOrder;

    private OrderRepository orderRepository;

    public CreateOrder(ValidateOrder validateOrder, OrderRepository orderRepository) {
        this.validateOrder = validateOrder;
        this.orderRepository = orderRepository;
    }

    public void createOrder(Order order) {
        validateOrder.validateOrder(order);

        orderRepository.store(order);
    }

}
