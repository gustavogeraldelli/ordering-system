package com.gustavogeraldelli.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gustavogeraldelli.course.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
