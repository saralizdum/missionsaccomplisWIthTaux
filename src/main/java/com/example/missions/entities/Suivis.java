package com.example.missions.entities;

import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "Suivis")
public class Suivis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;

    @Lob
    private  String constats;
    @Lob
    private  String rec;
    @NotNull
    @Size(max = 250)
    private String statut;
    @NotNull
    private Double tauxavancement;

    @NotNull
    private Integer ponderation;
    @NotNull
    @Size(max = 250)
    private String deadline;

    @NotNull
    @Size(max = 250)
    private String incharge;

    @Lob
    private String materialisation;
    @NotNull
    @Size(max = 250)
    private String process;
//
//    @OneToMany(mappedBy = "suivis", cascade = CascadeType.ALL)
//    private Set<Recommandation> recommandations;

    @ManyToOne
    @JoinColumn(name = "suivi_mission_id")
    private Mission mission;

    public Suivis(String constats,@Size(max = 250) String process ) {

        this.process=process;
        this.constats=constats;
    }

    public Suivis() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getConstats() {
        return constats;
    }

    public void setConstats(String constats) {
        this.constats = constats;
    }

    public String getProcess() {
        return process;
    }

    public void setProcess(String process) {
        this.process = process;
    }

//    public Set<Recommandation> getRecommandations() {
//        return recommandations;
//    }
//

    public String getRec() {
        return rec;
    }

    public void setRec(String rec) {
        this.rec = rec;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
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

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
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
//    public void setRecommandations(Set<Recommandation> recommandations) {
//        this.recommandations = recommandations;
//    }

    public Mission getMission() {
        return mission;
    }

    public void setMission(Mission mission) {
        this.mission = mission;
    }
}
