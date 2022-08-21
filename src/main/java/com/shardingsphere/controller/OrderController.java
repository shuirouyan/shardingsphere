package com.shardingsphere.controller;

import com.google.gson.Gson;
import com.shardingsphere.dao.OrderDao;
import com.shardingsphere.entity.Order;
import org.apache.shardingsphere.infra.properties.TypedProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * @author kangchen
 * @date 2022/8/21 11:07
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderDao orderDao;

    @GetMapping("/get")
    public String getOrderEntityMethod(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                       @RequestParam(value = "size", defaultValue = "10") Integer size,
                                       @RequestParam(value = "itemId", required = false) Integer itemId) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "itemId"));
        Order order = new Order();
        order.setItemId(itemId);
        Example<Order> orderExample = Example.of(order);
        Page<Order> all = orderDao.findAll(orderExample, pageable);
        return new Gson().toJson(all);
    }
}
