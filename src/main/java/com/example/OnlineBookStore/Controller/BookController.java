package com.example.OnlineBookStore.Controller;

import com.example.OnlineBookStore.Models.Book;
import com.example.OnlineBookStore.Services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;
    @PostMapping("/add-book")
    public String addBook(@RequestBody Book book)
    {
        bookService.addBook(book);
        return "Book added successfully";
    }

    @PutMapping("/delete-book-by title")
    public String deleteByTitle(@RequestParam String title)
    {
        return bookService.deleteByTitle(title);

    }

}
