package br.com.netshoes.interfaceadapter;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Order {

    private String number;

    private Date date;

    private String customerName;

    private String supplierName;

    private List<OrderItem> items;

}
