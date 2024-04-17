package com.Library.Management.Systems.Services;

import com.Library.Management.Systems.Entities.Author;
import com.Library.Management.Systems.Entities.Book;
import com.Library.Management.Systems.Enums.Genre;
import com.Library.Management.Systems.Exceptions.AuthorNotFoundException;
import com.Library.Management.Systems.Repository.AuthorRepository;
import com.Library.Management.Systems.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    public String addBook(Book book,Integer authorId) throws Exception{
        // Final goal is  : to save the book Entity

        Optional<Author>optionalAuthor = authorRepository.findById(authorId);

        if (!optionalAuthor.isPresent()){

            throw new AuthorNotFoundException("Author Id Entered is invalid");
        }

        Author author = optionalAuthor.get();

        book.setAuthor(author);

        //Bcz its a bidirectional mapping
        //Author should also have the information of the Book Entity

        author.getBookList().add(book);


        // now Book and Author Entity both have been modifies



        // I will save only the Author Entity
        //And because of cascading effect : book Entity will get autosaved

        authorRepository.save(author);

        return "Book has been added to the Database";



    }

    public List<String > getBooksByGenre(Genre genre){

        List<Book> bookList = bookRepository.findBooksByGenre(genre);

        List<String> bookNames = new ArrayList<>();

        for (Book book : bookList){
            bookNames.add(book.getBookName());
        }
        return bookNames;
    }





}
