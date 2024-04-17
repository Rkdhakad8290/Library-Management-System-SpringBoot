package com.Library.Management.Systems.Repository;

import com.Library.Management.Systems.Entities.Book;
import com.Library.Management.Systems.Entities.LibraryCard;
import com.Library.Management.Systems.Entities.Transaction;
import com.Library.Management.Systems.Enums.TransactionStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction,Integer> {

    Transaction findTransactionByBookAndCardAndTransactionStatus(Book book, LibraryCard card, TransactionStatus transactionStatus);

}
