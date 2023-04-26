package com.example.lms.Controller;

import com.example.lms.DTO.Request.Author.AuthorRequestDto;
import com.example.lms.DTO.Response.Author.AuthorResponseDto;
import com.example.lms.Exception.AuthorException;
import com.example.lms.Service.Interface.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/author")
public class AuthorController {
    @Autowired
    AuthorService authorService;

    // 1.Add Author
    @PostMapping("/add-author")
    public AuthorResponseDto addAuthor(@RequestBody AuthorRequestDto authorRequestDto) throws AuthorException {
        return authorService.addAuthor(authorRequestDto);
    }
}
