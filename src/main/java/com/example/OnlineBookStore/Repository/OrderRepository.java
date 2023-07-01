package com.example.OnlineBookStore.Repository;

import com.example.OnlineBookStore.Models.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Orders,Integer> {

}
