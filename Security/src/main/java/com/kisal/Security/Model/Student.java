package com.kisal.Security.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
//import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "students")
@Data
@AllArgsConstructor
public class Student {

    @Id
    private String id;

    private String name;
    private String index;
    private int age;


}