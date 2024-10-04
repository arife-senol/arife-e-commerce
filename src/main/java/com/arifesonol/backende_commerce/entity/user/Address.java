package com.arifesonol.backende_commerce.entity.user;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "address", schema = "fsweb")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @NotBlank(message = "Name alanı boş olamaz")
    @Size(min = 3, max = 45, message = "Name min 3 max 45 karakter olmalıdır")
    @Column(name = "name")
    private String name;

    @NotBlank(message = "Surname alanı boş olamaz")
    @Size(min = 3, max = 45, message = "Surname min 3 max 45 karakter olmalıdır")
    @Column(name = "surname")
    private String surname;

    @NotBlank(message = "City alanı boş olamaz")
    @Size(min = 3, max = 45, message = "City min 3 max 45 karakter olmalıdır")
    @Column(name = "city")
    private String city;

    @NotBlank(message = "District alanı boş olamaz")
    @Size(min = 3, max = 20, message = "District min 3 max 20 karakter olmalıdır")
    @Column(name = "district")
    private String district;


    @Size(min = 3, max = 30, message = "neighborhood min 20 max 100 olmalıdır")
    @Column(name = "neighborhood")
    private String neighborhood;


    @Size(min = 20, max = 100, message = "Addres min 20 max 100 olmalıdır")
    @Column(name = "address")
    private String address;

    @NotBlank(message = "title boş olamaz")
    @Size(min = 5, max = 10, message = "Title min 5 max 10 olmalıdır")
    @Column(name = "title")
    private String title;

    @NotBlank(message = "Phone boş olamaz")
    @Size(min = 9, max = 20, message = "Phone  10 karakter olmalıdır")
    @Column(name = "phone")
    private String phone;


}
