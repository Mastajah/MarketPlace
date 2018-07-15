package fr.projeti1.marketplace.interfaceS.DTO;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

public class ParticulierDTO implements Parcelable {

    private Long id;
    private Long numeroClient;
    private String nomClient;
    private String prenomClient;
    private Date dateNaissance;
    private Long numeroTelephone;
    private String mail;
    private String motDePasse;
    private String Adresse;
    private String Ville;
    private Long codePostal;

    public ParticulierDTO(){

    }


    protected ParticulierDTO(Parcel in) {
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readLong();
        }
        if (in.readByte() == 0) {
            numeroClient = null;
        } else {
            numeroClient = in.readLong();
        }
        nomClient = in.readString();
        prenomClient = in.readString();
        if (in.readByte() == 0) {
            numeroTelephone = null;
        } else {
            numeroTelephone = in.readLong();
        }
        mail = in.readString();
        motDePasse = in.readString();
        Adresse = in.readString();
        Ville = in.readString();
        if (in.readByte() == 0) {
            codePostal = null;
        } else {
            codePostal = in.readLong();
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNumeroClient() {
        return numeroClient;
    }

    public void setNumeroClient(Long numeroClient) {
        this.numeroClient = numeroClient;
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

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
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

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
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
        if (id == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(id);
        }
        if (numeroClient == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(numeroClient);
        }
        dest.writeString(nomClient);
        dest.writeString(prenomClient);
        if (numeroTelephone == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(numeroTelephone);
        }
        dest.writeString(mail);
        dest.writeString(motDePasse);
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

    public static final Creator<ParticulierDTO> CREATOR = new Creator<ParticulierDTO>() {
        @Override
        public ParticulierDTO createFromParcel(Parcel in) {
            return new ParticulierDTO(in);
        }

        @Override
        public ParticulierDTO[] newArray(int size) {
            return new ParticulierDTO[size];
        }
    };
}
