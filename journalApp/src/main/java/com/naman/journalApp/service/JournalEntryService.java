package com.naman.journalApp.service;

import com.naman.journalApp.entity.JournalEntry;
import com.naman.journalApp.entity.User;
import com.naman.journalApp.repository.JournalEntryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class JournalEntryService {

    @Autowired
    public JournalEntryRepository journalEntryRepository;
    @Autowired
    private UserService userService;

    @Transactional
    public void saveEntry(JournalEntry myEntry, String username) {
        try {
            User user = userService.findByUsername(username);
            myEntry.setDate(LocalDateTime.now());
            JournalEntry saved = journalEntryRepository.save(myEntry);
            user.getJournalEntry().add(saved);
            userService.saveUser(user);
        } catch (Exception e) {
            System.out.println(e);
            throw new RuntimeException(e);
        }
    }

    public void saveEntry(JournalEntry myEntry) {
        journalEntryRepository.save(myEntry);
    }

    public List<JournalEntry> getAll() {
        return journalEntryRepository.findAll();
    }

    public Optional<JournalEntry> getById(ObjectId id) {
        return journalEntryRepository.findById(id);
    }

    public String deleteById(ObjectId id, String username) {
        User user = userService.findByUsername(username);
        user.getJournalEntry().removeIf(x -> x.getId().equals(id));
        userService.saveUser(user);
        journalEntryRepository.deleteById(id);
        return "Journal Entry deleted successfully";
    }

}
