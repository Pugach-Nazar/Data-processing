package com.example.lab5.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "lab5Table")
public class MachineGun {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String photoUrl;
    private String description;
    private int amount;

    public MachineGun() {
    }

    public MachineGun(int amount, String description, String photoUrl, String name, int id) {
        this.amount = amount;
        this.description = description;
        this.photoUrl = photoUrl;
        this.name = name;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
