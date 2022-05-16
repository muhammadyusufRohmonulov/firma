package com.example.firma.firmaData.repository;

import com.example.firma.firmaData.model.Firma;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

public interface FirmaRepository extends JpaRepository<Firma,Integer> {
    boolean existsByFirmaNomi(String nomi);
    boolean existsByFirmaNomiAndManzilNot(String nomi,Integer id);
}
