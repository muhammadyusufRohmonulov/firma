package com.example.firma.firmaData.controller;

import com.example.firma.firmaData.model.Firma;
import com.example.firma.firmaData.service.FirmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("firma")
public class FirmaController {
    @Autowired
    FirmaService firmaService;
    @PostMapping("/insert")
    public HttpEntity<?> addData(@Valid @RequestBody Firma firma){
        boolean b = firmaService.addData2(firma);
        if (b){
            return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).body("Bunday Firma Avval Ro'yxatdan O'tgan");
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
    @GetMapping(value = "/read/{id}")
    public HttpEntity<?> view(@PathVariable Integer id){
        return ResponseEntity.ok(firmaService.view(id));
    }
    @PutMapping(value = "/edit/{id}")
    public HttpEntity<?> update(@PathVariable Integer id,@RequestBody Firma firma){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(firmaService.update(id, firma));
    }
    @DeleteMapping(value = "/delete/{id}")
    public HttpEntity<?> delete(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(firmaService.delete(id));
    }
}
