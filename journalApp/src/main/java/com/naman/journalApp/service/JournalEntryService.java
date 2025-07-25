package com.naman.journalApp.service;

import com.naman.journalApp.entity.JournalEntry;
import com.naman.journalApp.repository.JournalEntryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Component
public class JournalEntryService {

    @Autowired
    public JournalEntryRepository journalEntryRepository;

    public void saveEntry(JournalEntry myEntry) {
        journalEntryRepository.save(myEntry);
    }

    public List<JournalEntry> getAll() {
        return journalEntryRepository.findAll();
    }

    public Optional<JournalEntry> getById(ObjectId id) {
        return journalEntryRepository.findById(id);
    }

    public String deleteById(ObjectId id) {
        journalEntryRepository.deleteById(id);
        return "Journal Entry deleted successfully";
    }

}
