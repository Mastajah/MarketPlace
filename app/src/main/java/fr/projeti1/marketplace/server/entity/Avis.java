package fr.projeti1.marketplace.server.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "AVIS",foreignKeys = {@ForeignKey(entity = Particulier.class, parentColumns = "id",childColumns = "particulier"), @ForeignKey(entity = Particulier.class, parentColumns = "id",childColumns = "profilPro")})
public class Avis {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "AVIS_SEQ")
    private Long idAvis;

    @ColumnInfo(name = "AVIS_NUM_AVIS")
    private Long numero;

    @ColumnInfo(name = "AVIS_NOM_PRO")
    private String nom;

    @ColumnInfo(name = "AVIS_NOM_SOC")
    private String nomSociete;

    @ColumnInfo(name = "AVIS_RES_INT")
    private String resumeIntervention;

    @ColumnInfo(name = "AVIS_DESC_AVIS")
    private String descriptionAvis;

    @Embedded
    @ColumnInfo(name = "PROP_PAR_SEQ")
    private Particulier particulier;

    @Embedded
    @ColumnInfo(name = "PROP_PAR_SEQ")
    private ProfilPro profilPro;

    public Long getIdAvis() {
        return idAvis;
    }

    public void setIdAvis(Long idAvis) {
        this.idAvis = idAvis;
    }

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNomSociete() {
        return nomSociete;
    }

    public void setNomSociete(String nomSociete) {
        this.nomSociete = nomSociete;
    }

    public String getResumeIntervention() {
        return resumeIntervention;
    }

    public void setResumeIntervention(String resumeIntervention) {
        this.resumeIntervention = resumeIntervention;
    }

    public String getDescriptionAvis() {
        return descriptionAvis;
    }

    public void setDescriptionAvis(String descriptionAvis) {
        this.descriptionAvis = descriptionAvis;
    }

    public Particulier getParticulier() {
        return particulier;
    }

    public void setParticulier(Particulier particulier) {
        this.particulier = particulier;
    }

    public ProfilPro getProfilPro() {
        return profilPro;
    }

    public void setProfilPro(ProfilPro profilPro) {
        this.profilPro = profilPro;
    }
}
