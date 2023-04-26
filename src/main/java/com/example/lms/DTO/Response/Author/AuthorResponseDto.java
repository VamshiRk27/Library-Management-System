package com.example.lms.DTO.Response.Author;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level=AccessLevel.PRIVATE)
public class AuthorResponseDto {
    String authorName;
    String email;
    String message;
}
