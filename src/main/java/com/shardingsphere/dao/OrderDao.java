package com.shardingsphere.dao;

import com.shardingsphere.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author kangchen
 * @date 2022/8/20 11:46
 */
//@Repository
public interface OrderDao extends JpaRepository<Order, Long> {

    Order findByOrderId(Long orderId);
}
