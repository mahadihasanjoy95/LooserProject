package com.mylooserproject.joy.LooserProject.repository;

import com.mylooserproject.joy.LooserProject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByEmail(String email);
}
