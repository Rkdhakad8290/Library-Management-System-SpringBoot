package com.Library.Management.Systems.Entities;

import com.Library.Management.Systems.Enums.CardStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name ="Library_card")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LibraryCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cardNo; // This is acting for the PK of the library card table

    @Enumerated(value = EnumType.STRING)
    private CardStatus cardStatus;

    private String nameOnCard;
    private Integer noOfBooksIssued;

    //Library card needs to be connected with the student table

    @OneToOne
    @JoinColumn
    private Student student; //This is  acting as a fk of the library card table
    //This variable is to be put in mappedBy attribute in the parent class


    @OneToMany(mappedBy = "card",cascade = CascadeType.ALL)
    private List<Transaction> transactionList = new ArrayList<>();



}
