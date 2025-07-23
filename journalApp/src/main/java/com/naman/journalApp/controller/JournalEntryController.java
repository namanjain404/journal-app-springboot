package com.naman.journalApp.controller;

import com.naman.journalApp.entity.JournalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {

    private Map<Long, JournalEntry> journalEntries = new HashMap<>();

    @GetMapping
    public List<JournalEntry> getAll() {
        return new ArrayList<JournalEntry>(journalEntries.values());
    }

    @PostMapping
    public String createEntry(@RequestBody JournalEntry myEntry) {
        journalEntries.put(myEntry.getId(), myEntry);
        return "Entry Added!";
    }

    @GetMapping("id/{myId}")
    public JournalEntry getById(@PathVariable Long myId) {
        return journalEntries.get(myId);
    }

    @DeleteMapping("id/{myId}")
    public String deleteById(@PathVariable Long myId) {
        journalEntries.remove(myId);
        return "Deleted";
    }

    @PutMapping("/id/{id}")
    public JournalEntry updateEntryById(@PathVariable Long id, @RequestBody JournalEntry myEntry) {
        return journalEntries.put(id, myEntry);
    }


}
