package com.example.OnlineBookStore.Services;

import com.example.OnlineBookStore.Models.User;
import com.example.OnlineBookStore.Repository.OrderRepository;
import com.example.OnlineBookStore.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;
    public void addUser(User user) {
        User user1 = new User();
        user1.setUserName(user.getUserName());

        user1.setMobileNum(user.getMobileNum());

        user1.setEmail(user.getEmail());

        userRepository.save(user1);
    }
}
