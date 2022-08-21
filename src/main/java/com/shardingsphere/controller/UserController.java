package com.shardingsphere.controller;

import com.google.gson.Gson;
import com.shardingsphere.dao.UserDao;
import com.shardingsphere.entity.Order;
import com.shardingsphere.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kangchen
 * @date 2022/8/21 11:37
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserDao userDao;

    @GetMapping("/get")
    public String getUserMethod(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                @RequestParam(value = "size", defaultValue = "10") Integer size,
                                @RequestParam(value = "age", required = false) Integer age) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "age"));
        User user = new User();
        user.setAge(age);
        Example<User> orderExample = Example.of(user);
        Page<User> all = userDao.findAll(orderExample, pageable);
        return new Gson().toJson(all);
    }
}
