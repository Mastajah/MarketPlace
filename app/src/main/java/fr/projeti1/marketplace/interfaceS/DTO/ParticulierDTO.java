package fr.projeti1.marketplace.interfaceS.DTO;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class ParticulierDTO implements Parcelable {

    private Long id;
    private Long numeroClient;
    private String nomClient;
    private String prenomClient;
    private Long numeroTelephone;
    private String Adresse;
    private String Ville;
    private Long codePostal;

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

    public Long getNumeroTelephone() {
        return numeroTelephone;
    }

    public void setNumeroTelephone(Long numeroTelephone) {
        this.numeroTelephone = numeroTelephone;
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
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeLong(numeroClient);
        dest.writeString(nomClient);
        dest.writeString(prenomClient);
        dest.writeLong(numeroTelephone);
        dest.writeString(Adresse);
        dest.writeString(Ville);
        dest.writeLong(codePostal);
    }

    public static final Parcelable.Creator<ParticulierDTO> CREATOR = new Parcelable.Creator<ParticulierDTO>()
    {
        @Override
        public ParticulierDTO createFromParcel(Parcel source)
        {
            return new ParticulierDTO(source);
        }

        @Override
        public ParticulierDTO[] newArray(int size)
        {
            return new ParticulierDTO[size];
        }
    };

    public ParticulierDTO(Parcel in) {
        this.id = in.readLong();
        this.numeroClient = in.readLong();
        this.nomClient = in.readString();
        this.prenomClient = in.readString();
        this.numeroTelephone = in.readLong();
        this.Adresse = in.readString();
        this.Ville = in.readString();
        this.codePostal = in.readLong();
    }
}
