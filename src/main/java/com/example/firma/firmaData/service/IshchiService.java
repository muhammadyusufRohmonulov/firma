package com.example.firma.firmaData.service;

import com.example.firma.firmaData.model.Ishchi;
import com.example.firma.firmaData.repository.IshchiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class IshchiService {
    @Autowired
    IshchiRepository ishchiRepository;
    public boolean insert2(Ishchi ishchi){
        boolean b = ishchiRepository.existsByTelefonRaqami(ishchi.getTelefonRaqami());
        if (b){
            return true;
        }
        Ishchi ishchi1 = new Ishchi();
        ishchi1.setIsmi(ishchi.getIsmi());
        ishchi1.setLavozimi(ishchi.getLavozimi());
        ishchi1.setTelefonRaqami(ishchi.getTelefonRaqami());
        ishchi1.setManzili(ishchi.getManzili());
        ishchi1.setMaoshi(ishchi.getMaoshi());
        ishchiRepository.save(ishchi1);
        return false;
    }
    public Ishchi view2(Integer id){
        Optional<Ishchi> optionalIshchi = ishchiRepository.findById(id);
        return optionalIshchi.orElse(null);
    }
    public String update2(Integer id,Ishchi ishchi){
        Optional<Ishchi> optionalIshchi = ishchiRepository.findById(id);
        if (optionalIshchi.isPresent()){
            boolean b = ishchiRepository.existsByTelefonRaqami(ishchi.getTelefonRaqami());
            if (b){
                return "Bunday Telefon Raqamdan Ro'yxatdan O'tilgan";
            }
            Ishchi ishchi1 = optionalIshchi.get();
            ishchi1.setIsmi(ishchi.getIsmi());
            ishchi1.setLavozimi(ishchi.getLavozimi());
            ishchi1.setTelefonRaqami(ishchi.getTelefonRaqami());
            ishchi1.setManzili(ishchi.getManzili());
            ishchi1.setMaoshi(ishchi.getMaoshi());
            ishchiRepository.save(ishchi1);
            return "Malumot Tahrirlandi";
        }
        return "Bunday Ishchi Mavjud Emas";
    }
    public String delete2(Integer id){
        Optional<Ishchi> optionalIshchi = ishchiRepository.findById(id);
        if (optionalIshchi.isPresent()){
            ishchiRepository.deleteById(id);
            return "Malumot O'chirildi";
        }
        return "Malumot Topilmadi";
    }
}
