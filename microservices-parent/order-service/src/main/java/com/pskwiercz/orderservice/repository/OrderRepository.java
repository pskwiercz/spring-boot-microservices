package com.pskwiercz.orderservice.repository;

import com.pskwiercz.orderservice.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
