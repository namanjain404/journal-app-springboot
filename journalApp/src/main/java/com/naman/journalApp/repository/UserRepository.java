package com.naman.journalApp.repository;

import com.naman.journalApp.entity.JournalEntry;
import com.naman.journalApp.entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;


public interface UserRepository extends MongoRepository<User, ObjectId> {


    User findByUsername(String username);

    void deleteByUsername(String username);
}
