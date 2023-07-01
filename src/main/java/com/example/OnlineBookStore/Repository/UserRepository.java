package com.example.OnlineBookStore.Repository;

import com.example.OnlineBookStore.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
