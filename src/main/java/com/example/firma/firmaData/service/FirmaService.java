package com.example.firma.firmaData.service;

import com.example.firma.firmaData.model.Firma;
import com.example.firma.firmaData.repository.FirmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FirmaService {
    @Autowired
    FirmaRepository firmaRepository;
    public boolean addData2(Firma firma){
        boolean b = firmaRepository.existsByFirmaNomi(firma.getFirmaNomi());
        if (b){
            return true;
        }
        Firma firma1 = new Firma();
        firma1.setFirmaNomi(firma.getFirmaNomi());
        firma1.setBoshqaruvchiIsmi(firma.getBoshqaruvchiIsmi());
        firma1.setManzil(firma1.getManzil());
        firmaRepository.save(firma1);
        return false;
    }
    public Firma view(Integer id){
        Optional<Firma> optionalFirma = firmaRepository.findById(id);
        return optionalFirma.orElse(null);
    }
    public String update(Integer id,Firma firma){
        boolean b = firmaRepository.existsByFirmaNomiAndManzilNot(firma.getFirmaNomi(), id);
        if (b){
            return "Bunday Firma Ro'yxatdan O'tgan";
        }
        Optional<Firma> optionalFirma = firmaRepository.findById(id);
        if (!optionalFirma.isPresent()){
            return "Bunday Firma Mavjud Emas";
        }
        Firma firma1 = optionalFirma.get();
        firma1.setManzil(firma.getManzil());
        firma1.setFirmaNomi(firma.getFirmaNomi());
        firma1.setBoshqaruvchiIsmi(firma.getBoshqaruvchiIsmi());
        firmaRepository.save(firma1);
        return "Malumot Tahrirlandi";
    }
    public String delete(Integer id){
        Optional<Firma> optionalFirma = firmaRepository.findById(id);
        if (optionalFirma.isPresent()){
            firmaRepository.deleteById(id);
            return "Malumot O'chirildi";
        }
        return "Malumot Topilmadi";
    }
}
