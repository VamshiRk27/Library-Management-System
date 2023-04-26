package com.example.lms.Transformer;

import com.example.lms.DTO.Request.Author.AuthorRequestDto;
import com.example.lms.DTO.Response.Author.AuthorResponseDto;
import com.example.lms.Entity.Author;
import lombok.experimental.UtilityClass;

@UtilityClass
public class AuthorTransformer {
    // RequestDto to Author Transformer
    public static Author authorRequestToAuthor(AuthorRequestDto authorRequestDto){
        return Author.builder()
                .age(authorRequestDto.getAge())
                .authorName(authorRequestDto.getAuthorName())
                .email(authorRequestDto.getEmail()).build();
    }
    // Author to ResponseDto Transformer
    public static AuthorResponseDto authorToAuthorResponseDto(Author author){
        return AuthorResponseDto.builder()
                .authorName(author.getAuthorName())
                .email(author.getEmail())
                .message("Author "+author.getAuthorName()+" created Successfully with given email "+author.getEmail()).build();
    }
}
