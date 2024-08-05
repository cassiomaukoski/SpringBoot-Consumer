package br.com.maukoski.cassio.springbootconsumer.model;

public class Person {
    private int id;
    private String name;
    private String birthDate;
    private int height;


    public Person() {
        this.id = 0;
        this.name = "";
        this.birthDate = "";
        this.setHeight(0);
    }

    public Person(int id, String name, String birthDate, int height) {
        this.id = id;
        this.setName(name);
        this.setBirthDate(birthDate);
        this.setHeight(height);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public int getHeight() {
        return height;
    }

    public int setId(int id) {
        return this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
