package com.example.OnlineBookStore.Services;

import com.example.OnlineBookStore.Exceptions.UserNotFound;
import com.example.OnlineBookStore.Models.Book;
import com.example.OnlineBookStore.Models.Orders;
import com.example.OnlineBookStore.Models.User;
import com.example.OnlineBookStore.Repository.BookRepository;
import com.example.OnlineBookStore.Repository.OrderRepository;
import com.example.OnlineBookStore.Repository.UserRepository;
import jakarta.persistence.criteria.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookRepository bookRepository;

    public String placeOrder(int userId, int bookId) {
        Optional<User> user = userRepository.findById(userId);
        if(!user.isPresent())
        {
            return "User with this id :"+userId+" is not present";
        }
        Optional<Book> book = bookRepository.findById(bookId);
        if(!book.isPresent())
        {
            return "book with this id :"+bookId+" is not present";
        }
        User user1 = user.get();
        Book book1 = book.get();

        Orders orders = new Orders();
        orders.setBook(book1);
        orders.setBook(book1);

        List<Orders> ordersList = user1.getOrderList();
        ordersList.add(orders);
        user1.setOrderList(ordersList);

        userRepository.save(user1);

        return "Order Placed Successfully! \n Thank You";
    }

    public List<Orders> getOrderList(int userId) throws UserNotFound {
        Optional<User> userOptional = userRepository.findById(userId);
        if(!userOptional.isPresent())
        {
            throw new UserNotFound("User not found");
        }
        User user = userOptional.get();
        return user.getOrderList();
    }
}
