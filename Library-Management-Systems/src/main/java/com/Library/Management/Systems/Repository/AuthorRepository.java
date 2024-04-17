package com.Library.Management.Systems.Repository;

import com.Library.Management.Systems.Entities.Author;
import com.Library.Management.Systems.Entities.Book;
import com.Library.Management.Systems.Enums.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author,Integer> {


    List<Author> findAuthorByAgeGreaterThanEqualAndRatingEquals(Integer age,double rating);

    List<Book> findBookByGenre(Genre genre);
}
