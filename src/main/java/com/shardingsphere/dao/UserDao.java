package com.shardingsphere.dao;

import com.shardingsphere.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author kangchen
 * @date 2022/8/20 11:43
 */
//@Repository
public interface UserDao extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {

    User findByUserId(Long userId);
}
