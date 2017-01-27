package br.com.netshoes.interfaceadapter.mapper;

import br.com.netshoes.interfaceadapter.Order;
import br.com.netshoes.interfaceadapter.OrderItem;
import br.com.netshoes.interfaceadapter.dto.OrderItemDTO;
import br.com.netshoes.interfaceadapter.dto.OrderDTO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.stream.Collectors;

public class OrderMapper {

    public Order mapToEntity(OrderDTO orderDTO) {
        Order order = new Order();

        order.setNumber(orderDTO.getNumber());
        order.setCustomerName(orderDTO.getCustomerName());
        order.setSupplierName(orderDTO.getSupplierName());

        try {
            order.setDate(new SimpleDateFormat("dd/MM/yyyy").parse(orderDTO.getDate()));
        } catch (ParseException e) {
            throw new IllegalArgumentException(e.getMessage(), e);
        }

        order.setItems(orderDTO.getItems().stream().map(orderItemDTO -> {
            OrderItem orderItem = new OrderItem();
            orderItem.setQuantity(orderItemDTO.getQuantity());
            orderItem.setSku(orderItemDTO.getSku());
            orderItem.setValue(orderItemDTO.getValue());
            return orderItem;
        }).collect(Collectors.toList()));

        return order;
    }

    public OrderDTO mapToDto(Order order) {
        OrderDTO orderDTO = new OrderDTO();

        orderDTO.setNumber(order.getNumber());
        orderDTO.setCustomerName(order.getCustomerName());
        orderDTO.setSupplierName(order.getSupplierName());
        orderDTO.setDate(new SimpleDateFormat("dd/MM/yyyy").format(order.getDate()));

        orderDTO.setItems(order.getItems().stream().map(orderItem -> {
            OrderItemDTO orderItemDTO = new OrderItemDTO();
            orderItemDTO.setQuantity(orderItem.getQuantity());
            orderItemDTO.setSku(orderItem.getSku());
            orderItemDTO.setValue(orderItem.getValue());
            return orderItemDTO;
        }).collect(Collectors.toList()));

        return orderDTO;
    }

}
