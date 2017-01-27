package br.com.netshoes.interfaceadapter.mapper;

import br.com.netshoes.interfaceadapter.Order;
import br.com.netshoes.interfaceadapter.OrderItem;
import br.com.netshoes.interfaceadapter.entity.OrderExternal;
import br.com.netshoes.interfaceadapter.entity.OrderItemExtenal;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class OrderExtenalMapper {

    public Order mapToEntity(OrderExternal orderExternalDTO) {
        Order order = new Order();

        order.setNumber(orderExternalDTO.getNumber());
        order.setCustomerName(orderExternalDTO.getCustomerName());
        order.setSupplierName(orderExternalDTO.getSupplierName());
        order.setDate(orderExternalDTO.getDate());

        order.setItems(orderExternalDTO.getItems().stream().map(orderItemExtenal -> {
            OrderItem orderItem = new OrderItem();
            orderItem.setQuantity(orderItemExtenal.getQuantity());
            orderItem.setSku(orderItemExtenal.getSku());
            orderItem.setValue(orderItemExtenal.getValue());
            return orderItem;
        }).collect(Collectors.toList()));

        return order;
    }

    public OrderExternal mapToExternalOrder(Order order) {
        OrderExternal orderDTO = new OrderExternal();

        orderDTO.setNumber(order.getNumber());
        orderDTO.setCustomerName(order.getCustomerName());
        orderDTO.setSupplierName(order.getSupplierName());
        orderDTO.setDate(order.getDate());

        orderDTO.setItems(order.getItems().stream().map(orderItem -> {
            OrderItemExtenal orderItemDTO = new OrderItemExtenal();
            orderItemDTO.setQuantity(orderItem.getQuantity());
            orderItemDTO.setSku(orderItem.getSku());
            orderItemDTO.setValue(orderItem.getValue());
            return orderItemDTO;
        }).collect(Collectors.toList()));

        return orderDTO;
    }

}
