package br.com.netshoes.interfaceadapter.controller;

import br.com.netshoes.interfaceadapter.dto.OrderDTO;
import br.com.netshoes.interfaceadapter.presenter.OrderPresenter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/orders")
public class OrderExternalController {

    @Autowired
    private OrderController orderController;

    @Autowired
    private OrderPresenter orderPresenter;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> post(@RequestBody OrderDTO orderDTO) {
        orderController.createOrder(orderDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<OrderDTO>> get() {
        return ResponseEntity.ok(orderPresenter.listOrders());
    }

}
