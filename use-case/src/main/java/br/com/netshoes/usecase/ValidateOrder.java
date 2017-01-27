package br.com.netshoes.usecase;

import br.com.netshoes.interfaceadapter.Order;

public class ValidateOrder {

    public void validateOrder(Order order) {
        if( order.getItems().isEmpty() ) {
            throw new IllegalArgumentException("Empty order items.");
        }
    }

}
