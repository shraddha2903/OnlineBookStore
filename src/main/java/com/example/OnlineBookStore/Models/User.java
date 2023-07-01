package com.example.OnlineBookStore.Models;

import jakarta.persistence.*;
import jakarta.persistence.criteria.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String userName;

    private String email;

    private String mobileNum;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Orders> orderList = new ArrayList<>();
}
