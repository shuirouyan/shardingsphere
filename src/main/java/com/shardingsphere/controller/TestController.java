package com.shardingsphere.controller;

import com.shardingsphere.dao.OrderDao;
import com.shardingsphere.dao.UserDao;
import com.shardingsphere.entity.Order;
import com.shardingsphere.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author kangchen
 * @date 2022/8/19 22:13
 */
@Slf4j
@RestController
public class TestController {
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private UserDao userDao;

    @GetMapping("/active")
    public HttpStatus httpStatusMethod() {
        return HttpStatus.OK;
    }

    @GetMapping("/order")
    public HttpStatus addOrderMethod() {
        Order order = new Order();
        order.setItemId(12);
        Order save = orderDao.save(order);
        log.info("save:{}", save);
        return HttpStatus.OK;
    }

    @GetMapping("/find")
    public List<Order> findAllOrderMethod() {
        List<Order> all = orderDao.findAll();
        return all;
    }

    @GetMapping("/user/find")
    public List<User> findAllUserMethod() {
        List<User> all = userDao.findAll();
        return all;
    }
}
