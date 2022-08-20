package com.shardingsphere.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author kangchen
 * @date 2022/8/20 11:32
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity
@Table(name = "t_order")
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    private Integer itemId;
}
