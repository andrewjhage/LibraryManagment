package com.example.librarymanagement.domain.user.controller;

import com.example.librarymanagement.domain.user.CreateJournalRequest;
import com.example.librarymanagement.domain.user.UpdateJournalRequest;
import com.example.librarymanagement.domain.user.entities.Journal;
import com.example.librarymanagement.domain.user.service.JournalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JournalController {
    @Autowired
    private JournalService journalService;

    @PostMapping(value = "/api/service/Journals")
    public String createJournal(@RequestBody CreateJournalRequest request) {
        return journalService.createJournal(request);
    }

    @PutMapping(value = "/api/service/Journals/{id}")
    public String updateJournal(@RequestBody UpdateJournalRequest request, @PathVariable("id") Integer id) {
        return journalService.updateJournal(id, request);
    }

    @GetMapping(value = "/api/service/Journals")
    public List<Journal> getAllJournals() {
        return journalService.getAllJournals();
    }

    @GetMapping(value = "/api/service/Journals/{id}")
    public Journal getJournalById(@PathVariable("id") Integer id) {
        return journalService.getJournalById(id);
    }

    @DeleteMapping(value = "/api/service/Journals/{id}")
    public Integer deleteJournalById(@PathVariable("id") Integer id) {
        return journalService.deleteJournal(id);
    }
}
