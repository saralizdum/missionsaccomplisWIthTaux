package com.example.missions.entities;

import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "Mission")
public class Mission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;


    @NotNull
    @Size(max = 250)
    private String intitule;

    @NotNull
    @Size(max = 250)
    private String chefmission;

    @NotNull
    @Size(max = 250)
    private String responsableaudite;

    @OneToMany(mappedBy = "mission", cascade = CascadeType.ALL)
    private Set<Suivis> suivis;

    public Mission(@Size(max = 250) String intitule,@Size(max = 250) String responsableaudite, @Size(max = 250) String chefmission) {

        this.intitule=intitule;
        this.chefmission=chefmission;
        this.responsableaudite=responsableaudite;
    }

   public Mission() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public String getChefmission() {
        return chefmission;
    }

    public void setChefmission(String chefmission) {
        this.chefmission = chefmission;
    }

    public String getResponsableaudite() {
        return responsableaudite;
    }

    public void setResponsableaudite(String responsableaudite) {
        this.responsableaudite = responsableaudite;
    }

    public Set<Suivis> getSuivis() {
        return suivis;
    }

    public void setSuivis(Set<Suivis> suivis) {
        this.suivis = suivis;
    }
}
