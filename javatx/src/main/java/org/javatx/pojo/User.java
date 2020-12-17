package org.javatx.pojo;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * @Author: 胡俊杰
 * @Date: 2020/7/30 14:47
 */
@Data
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String nickname;
    private boolean enabled;
    private String email;
    private String userface;
    private String role;
}
