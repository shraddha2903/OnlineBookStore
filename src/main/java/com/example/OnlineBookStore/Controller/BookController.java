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

    @GetMapping("/get-book-by-title")
    public Book getByTitle(@RequestParam String title) throws Exception {
        return bookService.getBookByTitle(title);
    }

    @GetMapping("/get-book-by-author")
    public Book getByAuthor(@RequestParam String author) throws Exception {
        return bookService.getBookByAuthor(author);
    }
    @GetMapping("/get-book-by-publication-date")
    public Book getByPublication(@RequestParam String publication) throws Exception {
        return bookService.getBookByPublication(publication);
    }

    @GetMapping("/get-book-by-price")
    public Book getByPrice(@RequestParam String price) throws Exception {
        return bookService.getBookByPrice(price);
    }


}
