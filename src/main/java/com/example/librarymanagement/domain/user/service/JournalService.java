package com.example.librarymanagement.domain.user.service;

import com.example.librarymanagement.domain.user.CreateCatalogRequest;
import com.example.librarymanagement.domain.user.UpdateCatalogRequest;
;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class JournalService {
    @Autowired
    public CatalogRepository catalogRepository;

    public String createCatalog(CreateCatalogRequest request) {

        var catalog = new Catalog();
        catalog.setTitle(request.getTitle());
        catalog.setAuthor(request.getAuthor());
        catalog.setYear(request.getYear());
        catalog.setIsbn(request.getIsbn());
        catalog.setQuantity(request.getQuantity());
        catalog.setStatus(request.getStatus());
        catalog.setLateFeePerDay(request.getLateFeePerDay());
        catalog.setGenre(request.getGenre());

        catalogRepository.save(catalog);

        return "OK";
    }

    public List<Catalog> getAllCatalogs() {
        return catalogRepository.findAll();
    }

    public Catalog getCatalogById(Integer id) {
        return catalogRepository.findById(id).orElseThrow(() -> new RuntimeException("Catalog not found"));
    }

    public String updateCatalog(Integer id, UpdateCatalogRequest request) {
        Catalog catalog = catalogRepository.findById(id).orElseThrow(() -> new RuntimeException("Catalog not found"));
        catalog.setTitle(request.getTitle());
        catalog.setAuthor(request.getAuthor());
        catalogRepository.save(catalog);
        return "OK";
    }

    public Integer deleteCatalog(Integer id) {
        catalogRepository.deleteById(id);
        return id;
    }
}
