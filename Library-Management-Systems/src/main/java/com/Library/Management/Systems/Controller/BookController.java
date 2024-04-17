package com.Library.Management.Systems.Controller;

import com.Library.Management.Systems.Entities.Book;
import com.Library.Management.Systems.Enums.Genre;
import com.Library.Management.Systems.Services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/addBook")
    public ResponseEntity addBook(@RequestBody Book book, @RequestParam("authorId")Integer authorId){

        try{
            String result = bookService.addBook(book,authorId);
            return new ResponseEntity(result,HttpStatus.OK);

        }catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/getBookByGenre")
    public List<String> getBooksByGenre(@RequestParam("genre")Genre genre){


        return null;
    }










}
