package com.example.firma.firmaData.controller;

import com.example.firma.firmaData.model.Ishchi;
import com.example.firma.firmaData.repository.IshchiRepository;
import com.example.firma.firmaData.service.IshchiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("ishchi")
public class ishchiController {
    @Autowired
    IshchiService ishchiService;
    @PostMapping(value = "/insert")
    public HttpEntity<?> insert(@Valid @RequestBody Ishchi ishchi){
        boolean b = ishchiService.insert2(ishchi);
        if (b){
            return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).body( "Bunday Ishchi Avval Ro'yxatdan o'tgan");
        }
        return ResponseEntity.status(HttpStatus.OK).body("Malumotlar Bazaga Joylandi");
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
    @GetMapping(value = "/view/{id}")
    public HttpEntity<?> view(@PathVariable Integer id){
        return ResponseEntity.ok(ishchiService.view2(id));
    }
    @PutMapping(value = "/update/{id}")
    public HttpEntity<?> update(@PathVariable Integer id,@RequestBody Ishchi ishchi){
        return ResponseEntity.status(HttpStatus.OK).body(ishchiService.update2(id, ishchi));
    }
    @DeleteMapping(value = "/delete/{id}")
    public HttpEntity<?> delete(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(ishchiService.delete2(id));
    }
}
