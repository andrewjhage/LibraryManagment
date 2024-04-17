package com.example.librarymanagement.domain.user.service;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    public Integer getId(String id) {
        try {
            return Integer.valueOf(id);
        } catch (NumberFormatException e){
            return 0;
        }
    }

    //I created this on my own
    public Integer getGenre(String genre) {
        return Integer.valueOf(genre);
    }
}









