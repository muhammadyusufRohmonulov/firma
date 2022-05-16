package com.example.firma.firmaData.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Firma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    @NotNull(message = "Firma Nomini Kiriting")
    private String firmaNomi;
    @Column(nullable = false)
    @NotNull(message = "Boshqaruvchi Ismini Kiriting")
    private String boshqaruvchiIsmi;
    @Column(nullable = false)
    @NotNull(message = "Manzilini Kiriting")
    private String manzil;
}
