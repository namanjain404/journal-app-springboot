package com.naman.journalApp.service;

import com.naman.journalApp.entity.User;
import com.naman.journalApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserService {

    @Autowired
    public UserRepository userRepository;

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User findByUsername(String userName) {
        return userRepository.findByUsername(userName);
    }

    public String deleteByUsername(String username) {
        userRepository.deleteByUsername((username));
        return "Journal Entry deleted successfully";
    }

}
