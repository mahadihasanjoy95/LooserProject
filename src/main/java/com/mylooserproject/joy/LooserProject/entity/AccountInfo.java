package com.mylooserproject.joy.LooserProject.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class AccountInfo {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue
    private Long id;
    private String accountName;
    private Double amount;
    @ManyToMany(mappedBy = "acoAccountInfoList")
    private List<User> userInfo;
}
