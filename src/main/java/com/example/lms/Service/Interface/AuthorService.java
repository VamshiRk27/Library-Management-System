package com.example.lms.Service.Interface;

import com.example.lms.DTO.Request.Author.AuthorRequestDto;
import com.example.lms.DTO.Response.Author.AuthorResponseDto;
import com.example.lms.Exception.AuthorException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface AuthorService {
    public AuthorResponseDto addAuthor(AuthorRequestDto addAuthorRequestDto) throws AuthorException;
}
