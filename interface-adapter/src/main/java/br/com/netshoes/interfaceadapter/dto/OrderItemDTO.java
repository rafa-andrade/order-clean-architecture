package br.com.netshoes.interfaceadapter.dto;

import lombok.Data;

@Data
public class OrderItemDTO {
    private String sku;
    private Integer quantity;
    private Double value;
}
