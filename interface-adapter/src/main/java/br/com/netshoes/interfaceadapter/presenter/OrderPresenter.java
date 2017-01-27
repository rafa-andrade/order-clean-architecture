package br.com.netshoes.interfaceadapter.presenter;

import br.com.netshoes.interfaceadapter.dto.OrderDTO;
import br.com.netshoes.interfaceadapter.mapper.OrderMapper;
import br.com.netshoes.usecase.ListOrders;

import java.util.List;
import java.util.stream.Collectors;

public class OrderPresenter {

    private OrderMapper orderMapper;

    private ListOrders listOrders;

    public OrderPresenter(ListOrders listOrders, OrderMapper orderMapper) {
        this.listOrders = listOrders;
        this.orderMapper = orderMapper;
    }

    public List<OrderDTO> listOrders() {
        return listOrders.listOrders().stream().map(orderMapper::mapToDto).collect(Collectors.toList());
    }

}
