package br.com.netshoes.interfaceadapter.entity;

import lombok.Data;

@Data
public class OrderItemExtenal {

    private String sku;
    private Integer quantity;
    private Double value;

}
