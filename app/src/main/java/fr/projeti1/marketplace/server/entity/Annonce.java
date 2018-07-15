package fr.projeti1.marketplace.server.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverter;

import java.util.List;

@Entity(tableName = "ANNONCE")
public class Annonce {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "ANN_SEQ")
    private Long idAnnonce;

    @ColumnInfo(name = "ANN_NUM_ANN")
    private Long numeroAnnonce;

    @ColumnInfo(name = "ANN_TIT_ANN")
    private String titre;

    @ColumnInfo(name = "ANN_DES_ANN")
    private String description;

    @ColumnInfo(name = "ANN_ADD_ANN")
    private String adresse;

    @ColumnInfo(name = "ANN_VIL_ANN")
    private String ville;

    @ColumnInfo(name = "ANN_LON_ANN")
    private float longitude;

    @ColumnInfo(name = "ANN_LAT_ANN")
    private float latitude;

    @ColumnInfo(name = "ANN_CP_ANN")
    private String codePostal;

    @ColumnInfo(name = "ANN_DATE_CREA")
    private String dateCreation;

    @ColumnInfo(name = "ANN_DATE_CLO")
    private String dateCloture;

    @ColumnInfo(name = "ANN_STAT_ANN")
    private String statut;

    @Ignore
    private Long idParticulier;

    @Ignore
    private List<Competence> competence;

    public Annonce(){

    }

    public Long getIdAnnonce() {
        return idAnnonce;
    }

    public void setIdAnnonce(Long idAnnonoce) {
        this.idAnnonce = idAnnonoce;
    }

    public Long getNumeroAnnonce() {
        return numeroAnnonce;
    }

    public void setNumeroAnnonce(Long numeroAnnonce) {
        this.numeroAnnonce = numeroAnnonce;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(String dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String getDateCloture() {
        return dateCloture;
    }

    public void setDateCloture(String dateCloture) {
        this.dateCloture = dateCloture;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public Long getIdParticulier() {
        return idParticulier;
    }

    public void setIdParticulier(Long idParticulier) {
        this.idParticulier = idParticulier;
    }

    public List<Competence> getCompetence() {
        return competence;
    }

    public void setCompetence(List<Competence> competence) {
        this.competence = competence;
    }
}
