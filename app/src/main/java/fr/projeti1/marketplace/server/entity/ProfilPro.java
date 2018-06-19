package fr.projeti1.marketplace.server.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "PROFILPRO")
public class ProfilPro {
    @PrimaryKey(autoGenerate = true)
    private Long idProfilPro;

    @ColumnInfo(name = "PROP_NUM_PRO")
    private Long numeroPro;

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

    // Insérer ici le fragment compétence ?

    @ColumnInfo(name = "PROP_NUM_TEL")
    private Long numeroTelephone;

    @ColumnInfo(name = "PROP_ADR_MAIL")
    private String mail;

    @ColumnInfo(name = "PROP_ADR")
    private String Adresse;

    @ColumnInfo(name = "PROP_VILLE")
    private String Ville;

    @ColumnInfo(name = "PROP_CP")
    private Long codePostal;

    public Long getIdProfilPro() {
        return idProfilPro;
    }

    public void setIdProfilPro(Long idProfilPro) {
        this.idProfilPro = idProfilPro;
    }

    public Long getNumeroPro() {
        return numeroPro;
    }

    public void setNumeroPro(Long numeroPro) {
        this.numeroPro = numeroPro;
    }

    public String getNomPro() {
        return nomPro;
    }

    public void setNomPro(String nomPro) {
        this.nomPro = nomPro;
    }

    public String getPrenomPro() {
        return prenomPro;
    }

    public void setPrenomPro(String prenomPro) {
        this.prenomPro = prenomPro;
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

    public Long getNumeroTelephone() {
        return numeroTelephone;
    }

    public void setNumeroTelephone(Long numeroTelephone) {
        this.numeroTelephone = numeroTelephone;
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
}
