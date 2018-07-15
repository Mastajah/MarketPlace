package fr.projeti1.marketplace.server.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverter;

import java.util.Date;
import java.util.List;

@Entity(tableName = "PARTICULIER")
public class Particulier {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "PAR_SEQ")
    private Long id;

    @ColumnInfo(name = "PAR_NUM_PAR")
    private Long numero;

    @ColumnInfo(name = "PAR_NOM_PAR")
    private String nom;

    @ColumnInfo(name = "PAR_PRE_PAR")
    private String prenom;

    @ColumnInfo(name = "PAR_DDN_PAR")
    private Date dateNaissance;

    @ColumnInfo(name = "PAR_TEl_PAR")
    private Long numeroTel;

    @ColumnInfo(name = "PAR_MAIl_PAR")
    private String mail;

    @ColumnInfo(name = "PAR_MT_PAS")
    private String motDePasse;

    @ColumnInfo(name = "PAR_ADR_PAR")
    private String adresse;

    @ColumnInfo(name = "PAR_COD_POS")
    private Long codePostal;

    @ColumnInfo(name = "PAR_VILLE")
    private String ville;

    @Embedded(prefix = "par_")
    private List<Annonce> annonces;

    public Particulier(){

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

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
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

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Long getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(Long codePostal) {
        this.codePostal = codePostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public List<Annonce> getAnnonces() {
        return annonces;
    }

    public void setAnnonces(List<Annonce> annonces) {
        this.annonces = annonces;
    }
}
