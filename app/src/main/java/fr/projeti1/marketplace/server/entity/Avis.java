package fr.projeti1.marketplace.server.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "AVIS")
public class Avis {

    @PrimaryKey(autoGenerate = true)
    private Long idAvis;

    @ColumnInfo(name = "AVIS_NUM_AVIS")
    private Long numAvis;

    @ColumnInfo(name = "AVIS_NOM_PRO")
    private String nomPro;

    @ColumnInfo(name = "AVIS_NOM_SOC")
    private String nomSociete;

    @ColumnInfo(name = "AVIS_NOM_CLI")
    private String nomClient;

    @ColumnInfo(name = "AVIS_PREN_CLI")
    private String prenomClient;

    @ColumnInfo(name = "AVIS_NUM_ANN") // Clé étrangère, le spécifier ici ?
    private Long numAnnonce;

    @ColumnInfo(name = "AVIS_RES_INT")
    private String resumeIntervention;

    @ColumnInfo(name = "AVIS_DESC_AVIS")
    private String descriptionAvis;

    public Long getIdAvis() {
        return idAvis;
    }

    public void setIdAvis(Long idAvis) {
        this.idAvis = idAvis;
    }

    public Long getNumAvis() {
        return numAvis;
    }

    public void setNumAvis(Long numAvis) {
        this.numAvis = numAvis;
    }

    public String getNomPro() {
        return nomPro;
    }

    public void setNomPro(String nomPro) {
        this.nomPro = nomPro;
    }

    public String getNomSociete() {
        return nomSociete;
    }

    public void setNomSociete(String nomSociete) {
        this.nomSociete = nomSociete;
    }

    public String getNomClient() {
        return nomClient;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

    public String getPrenomClient() {
        return prenomClient;
    }

    public void setPrenomClient(String prenomClient) {
        this.prenomClient = prenomClient;
    }

    public Long getNumAnnonce() {
        return numAnnonce;
    }

    public void setNumAnnonce(Long numAnnonce) {
        this.numAnnonce = numAnnonce;
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
}
