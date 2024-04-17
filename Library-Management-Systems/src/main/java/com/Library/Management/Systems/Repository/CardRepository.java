package com.Library.Management.Systems.Repository;

import com.Library.Management.Systems.Entities.LibraryCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<LibraryCard,Integer> {

}
