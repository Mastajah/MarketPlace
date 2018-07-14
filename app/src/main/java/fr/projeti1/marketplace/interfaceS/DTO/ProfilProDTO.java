package fr.projeti1.marketplace.interfaceS.DTO;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class ProfilProDTO implements Parcelable{

    private Long numeroPro;
    private String nomPro;
    private String prenomPro;
    private String nomSociete;
    private Long siretSociete;
    private String numDecennale;
    private String competence; // modifier pour correspondre au fragment compétence
    private Long numeroTelephone;
    private String mail;
    private String Adresse;
    private String Ville;
    private Long codePostal;

    public ProfilProDTO(){

    }

    protected ProfilProDTO(Parcel in) {
        if (in.readByte() == 0) {
            numeroPro = null;
        } else {
            numeroPro = in.readLong();
        }
        nomPro = in.readString();
        prenomPro = in.readString();
        nomSociete = in.readString();
        if (in.readByte() == 0) {
            siretSociete = null;
        } else {
            siretSociete = in.readLong();
        }
        numDecennale = in.readString();
        competence = in.readString();
        if (in.readByte() == 0) {
            numeroTelephone = null;
        } else {
            numeroTelephone = in.readLong();
        }
        mail = in.readString();
        Adresse = in.readString();
        Ville = in.readString();
        if (in.readByte() == 0) {
            codePostal = null;
        } else {
            codePostal = in.readLong();
        }
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

    public String getCompetence() {
        return competence;
    }

    public void setCompetence(String competence) {
        this.competence = competence;
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

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (numeroPro == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(numeroPro);
        }
        dest.writeString(nomPro);
        dest.writeString(prenomPro);
        dest.writeString(nomSociete);
        if (siretSociete == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(siretSociete);
        }
        dest.writeString(numDecennale);
        dest.writeString(competence);
        if (numeroTelephone == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(numeroTelephone);
        }
        dest.writeString(mail);
        dest.writeString(Adresse);
        dest.writeString(Ville);
        if (codePostal == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(codePostal);
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ProfilProDTO> CREATOR = new Creator<ProfilProDTO>() {
        @Override
        public ProfilProDTO createFromParcel(Parcel in) {
            return new ProfilProDTO(in);
        }

        @Override
        public ProfilProDTO[] newArray(int size) {
            return new ProfilProDTO[size];
        }
    };
}
