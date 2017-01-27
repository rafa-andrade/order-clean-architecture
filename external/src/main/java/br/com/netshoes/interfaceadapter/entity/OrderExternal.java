package br.com.netshoes.interfaceadapter.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Data
@Document
public class OrderExternal {

    @Id
    private String number;

    private Date date;

    private String customerName;

    private String supplierName;

    private List<OrderItemExtenal> items;

}
