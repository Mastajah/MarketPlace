package fr.projeti1.marketplace.interfaceS.DTO;

import android.os.Parcel;
import android.os.Parcelable;

public class AvisDTO implements Parcelable{

    protected Long numAvis;
    protected String nomPro;
    protected String nomSociete;
    protected String nomClient;
    protected String prenomClient;
    protected Long numAnnonce;
    protected String resumeIntervention;
    protected String descriptionAvis;

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(numAvis);
        dest.writeString(nomPro);
        dest.writeString(nomSociete);
        dest.writeString(nomClient);
        dest.writeString(prenomClient);
        dest.writeLong(numAnnonce);
        dest.writeString(resumeIntervention);
        dest.writeString(descriptionAvis);
    }

    public static final Parcelable.Creator<AvisDTO> CREATOR = new Parcelable.Creator<AvisDTO>()
    {
        @Override
        public AvisDTO createFromParcel(Parcel source)
        {
            return new AvisDTO(source);
        }

        @Override
        public AvisDTO[] newArray(int size)
        {
            return new AvisDTO[size];
        }
    };

    public AvisDTO(Parcel in) {
        this.numAvis = in.readLong();
        this.nomPro = in.readString();
        this.nomSociete = in.readString();
        this.nomClient = in.readString();
        this.prenomClient = in.readString();
        this.numAnnonce = in.readLong();
        this.resumeIntervention = in.readString();
        this.descriptionAvis = in.readString();
    }
}
