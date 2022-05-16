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
public class Ishchi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    @NotNull(message = "Ismini Kiriting")
    private String ismi;
    @Column(nullable = false,unique = true)
    @NotNull(message = "Telefon Raqamini Kiriting")
    private String telefonRaqami;
    @Column(nullable = false)
    @NotNull(message = "Maoshini Kiriting")
    private Double maoshi;
    @Column(nullable = false)
    @NotNull(message = "Lavozimini Kiriting")
    private String lavozimi;
    @Column(nullable = false)
    @NotNull(message = "Manzilini Kiriting")
    private String manzili;
}
