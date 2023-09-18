package com.gustavogeraldelli.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gustavogeraldelli.course.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
