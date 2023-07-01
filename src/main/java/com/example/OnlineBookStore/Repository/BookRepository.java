package com.example.OnlineBookStore.Repository;

import com.example.OnlineBookStore.Models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book,Integer> {

    public Optional<Book> findByTitle(String title);

    public Optional<Book> findByAuthor(String author);

   public Optional<Book> findByPublicationDate(String publication);

   public Optional<Book> findByPrice(String price);
}
