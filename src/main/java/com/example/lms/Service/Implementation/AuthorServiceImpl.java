package com.example.lms.Service.Implementation;

import com.example.lms.DTO.Request.Author.AuthorRequestDto;
import com.example.lms.DTO.Response.Author.AuthorResponseDto;
import com.example.lms.Entity.Author;
import com.example.lms.Exception.AuthorException;
import com.example.lms.Repository.AuthorRepository;
import com.example.lms.Service.Interface.AuthorService;
import com.example.lms.Transformer.AuthorTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    AuthorRepository authorRepository;
    // 1.Add Author
    @Override
    public AuthorResponseDto addAuthor(AuthorRequestDto authorRequestDto) throws AuthorException {
        Author author;
        // Check for any author existing with given email
        if(authorRepository.findByEmail(authorRequestDto.getEmail())!=null){
            throw new AuthorException("Author already exists with specified email");
        }
        author=AuthorTransformer.authorRequestToAuthor(authorRequestDto); //Creating a new author
        Author savedAuthor=authorRepository.save(author); // Save/Adding Author to the Author Repository

        // Preparing and returning the Response for Author
        AuthorResponseDto response=AuthorTransformer.authorToAuthorResponseDto(savedAuthor);
        return response;
    }
}
