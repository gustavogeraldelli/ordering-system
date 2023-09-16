package com.gustavogeraldelli.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gustavogeraldelli.course.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
