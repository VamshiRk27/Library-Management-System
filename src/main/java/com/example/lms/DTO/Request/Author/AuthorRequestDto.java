package com.example.lms.DTO.Request.Author;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level= AccessLevel.PRIVATE)
public class AuthorRequestDto {
    String authorName;
    Integer age;
    String email;
//    List<Book> books;
}
