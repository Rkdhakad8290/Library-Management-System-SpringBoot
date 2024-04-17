package com.Library.Management.Systems.Entities;

import com.Library.Management.Systems.Enums.TransactionStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Table(name = "transaction")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer transactionId; // Handled by spring Automatically

    @Enumerated(value = EnumType.STRING)
    private TransactionStatus transactionStatus;

    private Date issueDate;

    private Date returnDate;

    private Integer fine;

    @CreationTimestamp
    private Date createOn; //Handled by spring internally

    @UpdateTimestamp
    private  Date lastModifiedOn; //Handled by spring internally


    //Connect fk here with Book Entity
    @ManyToOne
    @JoinColumn
    private Book book;

    @ManyToOne
    @JoinColumn
    private LibraryCard card;






}
