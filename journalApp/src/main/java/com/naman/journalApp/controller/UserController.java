package com.naman.journalApp.controller;

import com.naman.journalApp.entity.User;
import com.naman.journalApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    public UserService userService;

    @GetMapping
    private ResponseEntity<?> getAllUsers() {
        List<User> all = userService.getAll();
        if (all.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody User user) {
        try {
            userService.saveUser(user);
            return new ResponseEntity<>(user, HttpStatus.CREATED);
        }
        catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{username}")
    public ResponseEntity<?> updateUserByUsername(@PathVariable String username, @RequestBody User newUser) {
        User old =  userService.findByUsername(username);
        if(old != null) {
            old.setUsername(newUser.getUsername());
            old.setPassword(newUser.getPassword());
            userService.saveUser(newUser);
            return new  ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //    @GetMapping("/id/{id}")
//    public ResponseEntity<?> getUserByUsername(@PathVariable String username) {
//        User user = userService.getByUsername(username);
//        if (user.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<>(user.get(), HttpStatus.OK);
//    }
//
//    @DeleteMapping("/id/{id}")
//    public ResponseEntity<?> deleteUserByUsername(@PathVariable String username) {
//        userService.deleteById(username);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }

}
