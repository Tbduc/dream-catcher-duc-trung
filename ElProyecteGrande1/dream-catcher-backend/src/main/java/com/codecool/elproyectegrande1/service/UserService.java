package com.codecool.elproyectegrande1.service;

import com.codecool.elproyectegrande1.dto.SignInDto;
import com.codecool.elproyectegrande1.entity.Dreamer;
import com.codecool.elproyectegrande1.exceptions.AuthenticationFailException;
import com.codecool.elproyectegrande1.repository.DreamerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    Logger logger = LoggerFactory.getLogger(UserService.class);
    @Autowired
    private DreamerRepository dreamerRepository;

    public SignInDto signIn(SignInDto signInDto) {
        Dreamer dreamer = dreamerRepository.findByEmail(signInDto.getEmail());
        if (dreamer == null) {
            throw new AuthenticationFailException("User not present");
        }
        try {
            if (!dreamer.getPassword().equals(signInDto.getPassword())) {
                //password doesn't match
                throw new AuthenticationFailException("Wrong password");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("hashing password failed {}", e.getMessage());
            throw new RuntimeException(e.getMessage());
        }

        return new SignInDto("Login success");
    }
}
