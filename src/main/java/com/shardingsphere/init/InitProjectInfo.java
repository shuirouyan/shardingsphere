package com.shardingsphere.init;

import com.shardingsphere.dao.OrderDao;
import com.shardingsphere.dao.UserDao;
import com.shardingsphere.entity.Order;
import com.shardingsphere.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author kangchen
 * @date 2022/8/20 19:26
 */
@Slf4j
@Component
public class InitProjectInfo implements CommandLineRunner {
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private UserDao userDao;

    @Override
    public void run(String... args) throws Exception {
        List<Order> all = orderDao.findAll();
        if (CollectionUtils.isEmpty(all)) {
            List<Order> list = new ArrayList<>();
            for (int i = 1; i <= 100; i++) {
                Order order = new Order();
                order.setItemId(ThreadLocalRandom.current().nextInt(500));
                list.add(order);
            }
            list = orderDao.saveAll(list);
            log.info("order list:{}", list);
            log.info("init order data success...");
        } else {
            log.info("order table have many data....");
        }
        List<User> userAll = userDao.findAll();
        if (CollectionUtils.isEmpty(userAll)) {
            List<User> list = new ArrayList<>();
            for (int i = 1; i <= 100; i++) {
                User user = new User();
                user.setAge(ThreadLocalRandom.current().nextInt(100));
                User save = userDao.save(user);
                list.add(save);
            }
            log.info("user list:{}", list);
            log.info("init user data success...");
        } else {
            log.info("user table have many data....");
        }
    }
}
