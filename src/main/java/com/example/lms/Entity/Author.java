package com.example.lms.Entity;

// Imports
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

// Annotations
@Entity // To specify class as Entity and mapped to Database
@Data // Includes Getters and Setters
@NoArgsConstructor // No Args constructor
@AllArgsConstructor // All Args constructors
@Builder // helps in building pattern without writing boilerplate code.
@FieldDefaults(level=AccessLevel.PRIVATE) // Defines the scope of the variables of the class (in this case Private is used)
@Table(name="author") // Used to create table for the class in the Database with specified name.

// Class
public class Author {

    @Id // Annotation sets the parameter as Primary Key for the author Table/Entity
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    Integer id; // an Integer id for author which is also a Primary Key

    String authorName; // Name of the author
    Integer age; // age of the author

    @Column(unique=true) // Annotation sets the column values as Unique preventing duplicates
    String email; // Email of the author and is Unique

    @OneToMany(mappedBy="author",cascade=CascadeType.ALL) // Annotation for parent class Cardinal Relation
    List<Book> books=new ArrayList<>(); // List of all Books by the Author
}
