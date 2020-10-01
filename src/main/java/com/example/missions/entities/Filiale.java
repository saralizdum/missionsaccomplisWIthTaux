package com.example.missions.entities;

import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "Filiale")
public class Filiale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;



    @NotNull
    @Size(max = 250)
    private String Nom;

    @OneToMany(mappedBy = "filiale", cascade = CascadeType.ALL)
    private Set<Mission> missions;

    public Filiale() {
    }



    public Filiale(@Size(max = 250) String nom, Set<Mission> missions) {
        Nom = nom;
        this.missions = missions;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public Set<Mission> getMissions() {
        return missions;
    }

    public void setMissions(Set<Mission> missions) {
        this.missions = missions;
    }
}
