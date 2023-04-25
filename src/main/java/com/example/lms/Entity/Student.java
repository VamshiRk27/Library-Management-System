package com.example.lms.Entity;

// Imports
import com.example.lms.Enum.Department;
import com.example.lms.Enum.Genre;
import com.example.lms.Enum.TransactionStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

// Annotations
@Entity // To specify class as Entity and mapped to Database
@Data // Includes Getters and Setters
@NoArgsConstructor // No Args constructor
@AllArgsConstructor // All Args constructors
@Builder // helps in building pattern without writing boilerplate code.
@FieldDefaults(level=AccessLevel.PRIVATE) // Defines the scope of the variables of the class (in this case Private is used)
@Table(name="student") // Creates a table for the class in the Database with specified name.

// Class
public class Student {
    @Id // Annotation sets the parameter as Primary Key for the author Table/Entity
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    Integer id;

    String name;
    Integer age;

    @Enumerated(EnumType.STRING) // Annotation for converting Enum Data Type to String
    Department department;
    String mobNo;

    @OneToOne(mappedBy="student",cascade=CascadeType.ALL) // Annotation for parent class Cardinal Relation
    Card card;
}
