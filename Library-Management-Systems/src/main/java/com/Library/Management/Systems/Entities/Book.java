package com.Library.Management.Systems.Entities;

import com.Library.Management.Systems.Enums.Genre;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "book")// Incase you dont't write any name : ClassName is taken as table Name
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookId;
    private String bookName;
    private int price;
    private int noOfPages;

    @Enumerated(value = EnumType.STRING)
    private Genre genre;
    private double rating;

    private boolean isAvailable;


    @ManyToOne
    @JoinColumn
    private Author author;


    //Connecting to transactions
    @OneToMany(mappedBy = "book",cascade = CascadeType.ALL)
    private List<Transaction> transactionList = new ArrayList<>();


}
