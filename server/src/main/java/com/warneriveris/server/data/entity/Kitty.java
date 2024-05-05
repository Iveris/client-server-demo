package com.warneriveris.server.data.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@NoArgsConstructor
@Entity
@Table(name = "kitty")
@Data
public class Kitty {

    public Kitty(long id, String name, String owner, String eyeColor, Double weight, Integer intelligence, String description) {
        this.id = id;
        this.name = name;
        this.owner = owner;
        this.eyeColor = eyeColor;
        this.weight = weight;
        this.intelligence = intelligence;
        this.description = description;
    }

    @Builder
    public Kitty(String name, String owner, String eyeColor, Double weight, Integer intelligence, String description) {
        this.name = name;
        this.owner = owner;
        this.eyeColor = eyeColor;
        this.weight = weight;
        this.intelligence = intelligence;
        this.description = description;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private String name;
    private String owner;
    @Column(name = "eye-color")
    private String eyeColor;
    private Double weight;
    private Integer intelligence;
    private String description;

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Kitty cat = (Kitty) o;
        return Objects.equals(this.getName(), cat.getName()) &&
                Objects.equals(this.getOwner(), cat.getOwner()) &&
                Objects.equals(this.getEyeColor(), cat.getEyeColor()) &&
                Objects.equals(this.getWeight(), cat.getWeight()) &&
                Objects.equals(this.getIntelligence(), cat.getIntelligence()) &&
                Objects.equals(this.getDescription(), cat.getDescription());
    }

    @Override
    public int hashCode(){
        return Objects.hash(name, owner, eyeColor, weight, intelligence, description);
    }
}
