package com.shardingsphere.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author kangchen
 * @date 2022/8/20 11:31
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity
@Table(name = "t_user")
public class User implements Serializable {
    private static final long serialVersionUID = -6018129966549983371L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private Integer age;
}
