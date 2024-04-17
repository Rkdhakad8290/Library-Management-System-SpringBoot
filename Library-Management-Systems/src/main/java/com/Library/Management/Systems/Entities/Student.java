package com.Library.Management.Systems.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity // This means it's a structure that will be reflected in Database
@Table(name = "student") // This class will have a table whose name is student
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student {

     @Id
    private Integer studentId; //this will behave as the Primary key
    private String name;
    private  int age;
    //@Column(name="contactNo",unique=true,nullable=false) -> this is for changing column name
    private String mobNo;
    private String emailId;
    private String bloodGroup;

    @OneToOne(mappedBy = "student",cascade = CascadeType.ALL)
    private LibraryCard libraryCard;


}
