package com.test.demo.services;

import com.test.demo.models.Book;
import com.test.demo.repositories.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // returns all the books
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }

    // creates a book
    public Book createBook(Book b) {
        return bookRepository.save(b);
    }

    // retrieves a book
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }

    public Book updateBook(Long id, String title, String desc, String lang, Integer numOfPages) {
        Book book = findBook(id);
        if(book != null) {
            book.setTitle(title);
            book.setDescription(desc);
            book.setLanguage(lang);
            book.setNumberOfPages(numOfPages);
            bookRepository.save(book);
            return book;
        }else {
            return null;
        }
    }


    public void deleteBook(Long id) {
        Book book = findBook(id);
        if (book != null){
            bookRepository.deleteById(id);
        }
    }

    public void updateBook(Book book) {
        Book updatedBook = bookRepository.findById(book.getId()).orElse(null);
        assert updatedBook != null;
        updatedBook.setTitle(book.getTitle());
        updatedBook.setLanguage(book.getLanguage());
        updatedBook.setDescription(book.getDescription());
        updatedBook.setNumberOfPages(book.getNumberOfPages());
        bookRepository.save(updatedBook);
    }
}
