package br.com.netshoes.interfaceadapter.dto;

import lombok.Data;

import java.util.List;

@Data
public class OrderDTO {

    private String number;

    private String date;

    private String customerName;

    private String supplierName;

    private List<OrderItemDTO> items;

}
