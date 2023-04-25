package com.example.lms.Entity;

// Imports
import com.example.lms.Enum.CardStatus;
import com.example.lms.Enum.Department;
import com.example.lms.Enum.Genre;
import com.example.lms.Enum.TransactionStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// Annotations
@Entity // To specify class as Entity and mapped to Database
@Data // Includes Getters and Setters
@NoArgsConstructor // No Args constructor
@AllArgsConstructor // All Args constructors
@Builder // helps in building pattern without writing boilerplate code.
@FieldDefaults(level=AccessLevel.PRIVATE) // Defines the scope of the variables of the class (in this case Private is used)
@Table(name="card") // Creates a table for the class in the Database with specified name.

// Class
public class Card {
    @Id // Annotation sets the parameter as Primary Key for the author Table/Entity
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    Integer id;

    @CreationTimestamp
    Date issueDate; // Card Creation Date
    @UpdateTimestamp
    Date updatedOn; // Card Updated Date
    @Enumerated(EnumType.STRING) // Annotation for converting Enum Data Type to String
    CardStatus cardStatus; // Enum to define CardStatus of the Card
    Date validTill; // Date to store the validity of the card

    @OneToOne // Annotation for Child class to map with Parent
    @JoinColumn // Annotation to join the Child Entity with Parent Entity
    Student student; // Student(Parent) Entity for the Card(Child)

    @OneToMany(mappedBy="card",cascade=CascadeType.ALL) // Annotation for parent class Cardinal Relation
    List<Book> booksIssued=new ArrayList<>(); // List of books issued for this Card

    @OneToMany(mappedBy="card",cascade=CascadeType.ALL) // Annotation for parent class Cardinal Relation
    List<Transaction> transactionList=new ArrayList<>(); // List of all transactions issued for this Card
}
