package com.shardingsphere.controller;

import com.google.gson.Gson;
import com.shardingsphere.dao.OrderDao;
import com.shardingsphere.dao.UserDao;
import com.shardingsphere.entity.Order;
import com.shardingsphere.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
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
    public String findAllOrderMethod() {
        List<Order> all = orderDao.findAll();
        log.info("order:{}", all);
        return new Gson().toJson(all);
    }

    @GetMapping("/find/{orderId}")
    public List<Order> findOrderOrderMethod(@PathVariable(value = "orderId")Long orderId) {
        Order all = orderDao.findByOrderId(orderId);
        log.info("order:{}", all);
        return Collections.singletonList(all);
    }

    @GetMapping("/user/find")
    public String findAllUserMethod() {
        List<User> all = userDao.findAll();
        log.info("order:{}", all);
        return new Gson().toJson(all);
    }

    @GetMapping("/user/find/{userId}")
    public List<User> findUserByUserIdMethod(@PathVariable(value = "userId") Long userId) {
        User all = userDao.findByUserId(userId);
        log.info("order:{}", all);
        return Collections.singletonList(all);
    }
}
