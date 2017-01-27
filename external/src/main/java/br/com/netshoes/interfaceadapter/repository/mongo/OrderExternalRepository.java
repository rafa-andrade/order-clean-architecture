package br.com.netshoes.interfaceadapter.repository.mongo;

import br.com.netshoes.interfaceadapter.Order;
import br.com.netshoes.interfaceadapter.entity.OrderExternal;
import br.com.netshoes.interfaceadapter.mapper.OrderExtenalMapper;
import br.com.netshoes.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class OrderExternalRepository implements OrderRepository {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private OrderExtenalMapper orderExtenalMapper;

    @Override
    public void store(Order order) {
        mongoTemplate.save(orderExtenalMapper.mapToExternalOrder(order));
    }

    @Override
    public List<Order> listOrders() {
        return mongoTemplate.findAll(OrderExternal.class).stream()
                .map(orderExtenalMapper::mapToEntity)
                .collect(Collectors.toList()) ;
    }
}
