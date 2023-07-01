package com.example.OnlineBookStore.Controller;

import com.example.OnlineBookStore.Exceptions.UserNotFound;
import com.example.OnlineBookStore.Models.Orders;
import com.example.OnlineBookStore.Services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/place-order")
    public String placeOrder(@RequestParam int userId, @RequestParam int bookId)
    {
        return orderService.placeOrder(userId,bookId);
    }

    @GetMapping("/get-order-list")
    public List<Orders> getOrderList(@RequestParam int userId) throws UserNotFound {
        return orderService.getOrderList(userId);
    }
}
