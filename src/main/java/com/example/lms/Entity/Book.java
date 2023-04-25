package com.example.lms.Entity;

// Imports
import com.example.lms.Enum.Genre;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

// Annotations
@Entity // To specify class as Entity and mapped to Database
@Data // Includes Getters and Setters
@NoArgsConstructor // No Args constructor
@AllArgsConstructor // All Args constructors
@Builder // helps in building pattern without writing boilerplate code.
@FieldDefaults(level=AccessLevel.PRIVATE) // Defines the scope of the variables of the class (in this case Private is used)
@Table(name="book") // Creates a table for the class in the Database with specified name.

// Class
public class Book {
    @Id // Annotation sets the parameter as Primary Key for the author Table/Entity
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    Integer id; // an Integer id for book which is also a Primary Key
    String title; // Title/Name of the book

    @Enumerated(EnumType.STRING) // Annotation for converting Enum Data Type to String
    Genre genre; // Genre of the book

    Integer numberOfPages; // Number of pages in the book
    Integer price; // Price of the book
    Boolean isIssued; // Issue status of the book

    @ManyToOne // Annotation for Child class to map with Parent
    @JoinColumn // Annotation to join the Child Entity with Parent Entity
    Author author; // Author for the book

    @ManyToOne // Annotation for Child class to map with Parent
    @JoinColumn // Annotation to join the Child Entity with Parent Entity
    Card card; // Card(Parent) Entity for the Book(Child)

    @OneToMany(mappedBy="book",cascade=CascadeType.ALL)// Annotation for parent class Cardinal Relation
    List<Transaction> transactionList; // List of all the transactions issued for this book
}
