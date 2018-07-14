package fr.projeti1.marketplace.server.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.util.List;

@Entity(tableName = "PROFILPRO")
public class ProfilPro {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "PROP_SEQ")
    private Long id;

    @ColumnInfo(name = "PROP_NUM_PRO")
    private Long numero;

    @ColumnInfo(name = "PROP_NOM_PRO")
    private String nomPro;

    @ColumnInfo(name = "PROP_PREN_PRO")
    private String prenomPro;

    @ColumnInfo(name = "PROP_NOM_SOC")
    private String nomSociete;

    @ColumnInfo(name = "PROP_SIRET")
    private Long siretSociete;

    @ColumnInfo(name = "PROP_DEC")
    private String numDecennale;

    @ColumnInfo(name = "PROP_NUM_TEL")
    private Long numeroTel;

    @ColumnInfo(name = "PROP_ADR_MAIL")
    private String mail;

    @ColumnInfo(name = "PROP_ADR")
    private String Adresse;

    @ColumnInfo(name = "PROP_VILLE")
    private String Ville;

    @ColumnInfo(name = "PROP_CP")
    private Long codePostal;

    @Embedded
    private List<Avis> avisList;

    public ProfilPro(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public String getNomPro() {
        return nomPro;
    }

    public void setNomPro(String nom) {
        this.nomPro = nom;
    }

    public String getPrenomPro() {
        return prenomPro;
    }

    public void setPrenomPro(String prenom) {
        this.prenomPro = prenom;
    }

    public String getNomSociete() {
        return nomSociete;
    }

    public void setNomSociete(String nomSociete) {
        this.nomSociete = nomSociete;
    }

    public Long getSiretSociete() {
        return siretSociete;
    }

    public void setSiretSociete(Long siretSociete) {
        this.siretSociete = siretSociete;
    }

    public String getNumDecennale() {
        return numDecennale;
    }

    public void setNumDecennale(String numDecennale) {
        this.numDecennale = numDecennale;
    }

    public Long getNumeroTel() {
        return numeroTel;
    }

    public void setNumeroTel(Long numeroTel) {
        this.numeroTel = numeroTel;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getAdresse() {
        return Adresse;
    }

    public void setAdresse(String adresse) {
        Adresse = adresse;
    }

    public String getVille() {
        return Ville;
    }

    public void setVille(String ville) {
        Ville = ville;
    }

    public Long getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(Long codePostal) {
        this.codePostal = codePostal;
    }

    public List<Avis> getAvisList() {
        return avisList;
    }

    public void setAvisList(List<Avis> avisList) {
        this.avisList = avisList;
    }
}
