package com.example.spatial.repo;

import com.example.spatial.domain.META_USER;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

/**
 * @description:
 * @author: dinglw
 * @date: 2020-01-21 13:57
 */
public interface UserRepo extends JpaRepository<META_USER, String>, QuerydslPredicateExecutor<META_USER> {

}
