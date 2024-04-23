package com.example.librarymanagement.domain.user.service;

import com.example.librarymanagement.domain.user.CreateJournalRequest;
import com.example.librarymanagement.domain.user.UpdateJournalRequest;
import com.example.librarymanagement.domain.user.entities.Journal;
import com.example.librarymanagement.domain.user.repository.JournalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class JournalService {
    @Autowired
    public JournalRepository journalRepository;

    public String create(CreateJournalRequest request) {

        var journal = new Journal();
        journal.setTitle(request.getTitle());
        journal.setAuthor(request.getAuthor());
        journal.setYear(request.getYear());
        journal.setIssueNumber(request.getIssueNumber());
        journal.setQuantity(request.getQuantity());
        journal.setStatus(request.getStatus());
        journal.setLateFeePerDay(request.getLateFeePerDay());

        journalRepository.save(journal);

        return journal.getDetails();
    }

    public List<Journal> getAll() {
        return journalRepository.findAll();
    }

    public Journal getJournalById(Integer id) {
        return journalRepository.findById(id).orElseThrow(() -> new RuntimeException("Journal not found"));
    }

    public String updateJournal(Integer id, UpdateJournalRequest request) {
        Journal journal = journalRepository.findById(id).orElseThrow(() -> new RuntimeException("Catalog not found"));
        journal.setTitle(request.getTitle());
        journal.setAuthor(request.getAuthor());
        journalRepository.save(journal);
        return journal.getDetails();
    }

    public Integer deleteJournal(Integer id) {
        journalRepository.deleteById(id);
        return id;
    }
}
