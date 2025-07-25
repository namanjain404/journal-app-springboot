package com.naman.journalApp.controller;

import com.naman.journalApp.entity.JournalEntry;
import com.naman.journalApp.service.JournalEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {

    @Autowired
    public JournalEntryService journalEntryService;

    @GetMapping
    public List<JournalEntry> getAll() {
        return null;
    }

    @PostMapping
    public String createEntry(@RequestBody JournalEntry myEntry) {
        journalEntryService.saveEntry(myEntry);
        return "Entry Added!";
    }

    @GetMapping("id/{myId}")
    public JournalEntry getById(@PathVariable Long myId) {
        return null;
    }

    @DeleteMapping("id/{myId}")
    public String deleteById(@PathVariable Long myId) {
        return "Deleted";
    }

    @PutMapping("/id/{id}")
    public JournalEntry updateEntryById(@PathVariable Long id, @RequestBody JournalEntry myEntry) {
        return null;
    }



}
