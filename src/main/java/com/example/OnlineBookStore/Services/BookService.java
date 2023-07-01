package com.example.OnlineBookStore.Services;

import com.example.OnlineBookStore.Models.Book;
import com.example.OnlineBookStore.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    public void addBook(Book book) {
        Book newBook = new Book();
        newBook.setAuthor(book.getAuthor());
        newBook.setCategory(book.getCategory());
        newBook.setTitle(book.getTitle());
        newBook.setPrice(book.getPrice());

        bookRepository.save(newBook);
    }

    public String deleteByTitle(String title) {
        Optional<Book> book = bookRepository.findByTitle(title);
        if(!book.isPresent())
        {
            return "Book with given title not found";
        }
        Book book1 = book.get();

        int id = book1.getId();

        bookRepository.deleteById(id);
        bookRepository.save(book1);
        return "book has been deleted successfully! ";
    }

    public Book getBookByTitle(String title) throws Exception {
        Optional<Book> bookOptional = bookRepository.findByTitle(title);
        if(!bookOptional.isPresent())
        {
            throw new Exception("Book not present with this title :"+title);
        }
        Book book = bookOptional.get();
        return book;
    }

    public Book getBookByAuthor(String author) throws Exception {
        Optional<Book> bookOptional = bookRepository.findByAuthor(author);
        if(!bookOptional.isPresent())
        {
            throw new Exception("Book not present with this title :"+author);
        }
        Book book = bookOptional.get();
        return book;
    }

    public Book getBookByPublication(String publication) throws Exception {
        Optional<Book> bookOptional = bookRepository.findByPublicationDate(publication);
        if(!bookOptional.isPresent())
        {
            throw new Exception("Book not present with this title :"+publication);
        }
        Book book = bookOptional.get();
        return book;
    }

    public Book getBookByPrice(String price) throws Exception {
        Optional<Book> bookOptional = bookRepository.findByPrice(price);
        if(!bookOptional.isPresent())
        {
            throw new Exception("Book not present with this title :"+price);
        }
        Book book = bookOptional.get();
        return book;
    }
}
