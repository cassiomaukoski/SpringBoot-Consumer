package br.com.maukoski.cassio.springbootconsumer.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Person {
    private Integer id;
    private String name;
    private LocalDate birthDate;
    private Integer height;


    public Person() {}

    public Person(Integer id, String name, String birthDate, Integer height) {
        this.id = id;
        this.name = name;
        this.birthDate = LocalDate.parse(birthDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        this.height = height;
    }

    public Integer getId() {
        return id;
    }

    public Integer setId(Integer id) {
        return this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    @JsonIgnore
    public String getBirthDateString() {
        return birthDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    @JsonIgnore
    public String getBirthDateIso() {
        return birthDate == null ? null : birthDate.format(DateTimeFormatter.ISO_LOCAL_DATE);
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @JsonIgnore
    public void setBirthDateIso(String birthDate) {
        this.birthDate = LocalDate.parse(birthDate, DateTimeFormatter.ISO_LOCAL_DATE);
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }
}
