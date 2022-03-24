package com.mylooserproject.joy.LooserProject.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private Integer age;
    private String password;
    private String email;
    private String loginId;
    @ManyToMany
    @JoinTable(
            name = "user_account_info",
            joinColumns = @JoinColumn(name = "account_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<AccountInfo> acoAccountInfoList;
    @Column(name = "roles")
    private String roles;

    @Column (name ="active")
    private boolean active;
}
