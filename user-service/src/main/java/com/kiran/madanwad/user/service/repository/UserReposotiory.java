package com.kiran.madanwad.user.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kiran.madanwad.user.service.entity.User;

@Repository
public interface UserReposotiory extends JpaRepository<User, Long>{

    User findByUserId(Long userId);

}
