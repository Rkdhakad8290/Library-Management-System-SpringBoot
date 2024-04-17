package com.Library.Management.Systems.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "author")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer authorId;
    @Column(nullable = false)
    private String authorName;
    private int age;
    private double rating;

    //Author should also have the information of the book written
    @OneToMany(mappedBy = "author",cascade = CascadeType.ALL)
    private List<Book> bookList=new ArrayList<>();

    //Total no. of books written
}
