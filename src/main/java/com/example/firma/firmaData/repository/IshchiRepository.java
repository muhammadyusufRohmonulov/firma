package com.example.firma.firmaData.repository;

import com.example.firma.firmaData.model.Ishchi;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IshchiRepository extends JpaRepository<Ishchi,Integer> {
    boolean existsByTelefonRaqami(String nomer);
}
