package com.example.librarymanagement.domain.user.controller;


import com.example.librarymanagement.domain.user.CreateUserCommand;
import com.example.librarymanagement.domain.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController

public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/hello")
    public String helloWorld() {
        return "hello world";
    }
    @GetMapping("/api/service/user/{id}")
        public Integer returnId(@PathVariable("id") String id) {
        return userService.getId(id);
    }
    //I created this on my own
    @GetMapping("/api/service/book/{id}")
        public Integer returnBook(@PathVariable("genre") String genre) {
        return userService.getGenre(genre);
    }
    @PostMapping(value="/api/service/user", consumes = {"application/json"})
    public String blahBlah(@RequestBody CreateUserCommand command) {
        var title = command.getTitle();
        var author = command.getAuthor();
        var genre = command.getGenre();
        return "the title is %s genre is %s and the author is %s".formatted(title,genre, author);
    }
}
