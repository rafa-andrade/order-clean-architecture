package br.com.netshoes.repository;

import br.com.netshoes.interfaceadapter.Order;

import java.util.List;

public interface OrderRepository {

    void store(Order order);

    List<Order> listOrders();
}
