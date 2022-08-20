package com.shardingsphere;

import com.shardingsphere.dao.OrderDao;
import com.shardingsphere.dao.UserDao;
import com.shardingsphere.entity.Order;
import com.shardingsphere.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author kangchen
 * @date 2022/8/20 16:00
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(args = {"--spring.profiles.active=dev"})
public class OrderAgloTest {

    @Autowired
    private OrderDao orderDao;
    @Autowired
    private UserDao userDao;

    @Test
    public void orderTest01() {
        for (int i = 0; i < 30; i++) {
            Order order = new Order();
            // order.setOrderId();
            order.setItemId(ThreadLocalRandom.current().nextInt(500));
            Order save = orderDao.save(order);
            log.info("save:{}", save);
        }
    }

    @Test
    public void userTest01() {
        for (int i = 0; i < 30; i++) {
            User user = new User();
            user.setAge(ThreadLocalRandom.current().nextInt(120));
            User save = userDao.save(user);
            log.info("save:{}", save);
        }
    }
}
