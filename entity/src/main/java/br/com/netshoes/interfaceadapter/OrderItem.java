package br.com.netshoes.interfaceadapter;

import lombok.Data;

@Data
public class OrderItem {

    private String sku;
    private Integer quantity;
    private Double value;

}
