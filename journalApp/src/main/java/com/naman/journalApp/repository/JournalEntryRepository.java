package com.naman.journalApp.repository;

import com.naman.journalApp.entity.JournalEntry;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface JournalEntryRepository extends MongoRepository<JournalEntry,Long> {



}
