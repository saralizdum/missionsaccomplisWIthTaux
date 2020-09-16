package com.example.missions.entities;

import com.sun.istack.NotNull;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "Recommandation")
public class Recommandation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;

    @Lob
    private  String recommandation;

    @NotNull
    private Double tauxavancement;

    @NotNull
    private Integer ponderation;

    @Column
    @Type(type="date")
    private Date deadline;

    @NotNull
    @Size(max = 250)
    private String incharge;

    @Lob
    private String materialisation;

    @ManyToOne
    @JoinColumn(name = "recommandation_suivi_id")
    private Suivis suivis;


    @NotNull
    @Size(max = 250)
    private String statut;

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public Suivis getSuivis() {
        return suivis;
    }

    public void setSuivis(Suivis suivis) {
        this.suivis = suivis;
    }

    public Recommandation(String recommandation, Double tauxavancement, Integer ponderation, String statut, String incharge,Date deadline,String materialisation) {
  this.deadline=deadline;
  this.materialisation=materialisation;
        this.incharge=incharge;
        this.statut=statut;
        this.recommandation = recommandation;
        this.ponderation=ponderation;
        this.tauxavancement=tauxavancement;
    }
    public Recommandation() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRecommandation() {
        return recommandation;
    }

    public void setRecommandation(String recommandation) {
        this.recommandation = recommandation;
    }

    public Double getTauxavancement() {
        return tauxavancement;
    }

    public void setTauxavancement(Double tauxavancement) {
        this.tauxavancement = tauxavancement;
    }

    public Integer getPonderation() {
        return ponderation;
    }

    public void setPonderation(Integer ponderation) {
        this.ponderation = ponderation;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public String getIncharge() {
        return incharge;
    }

    public void setIncharge(String incharge) {
        this.incharge = incharge;
    }

    public String getMaterialisation() {
        return materialisation;
    }

    public void setMaterialisation(String materialisation) {
        this.materialisation = materialisation;
    }
}