package com.gustavogeraldelli.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gustavogeraldelli.course.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
