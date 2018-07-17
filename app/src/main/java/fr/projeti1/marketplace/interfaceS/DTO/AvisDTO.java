package fr.projeti1.marketplace.interfaceS.DTO;

import android.os.Parcel;
import android.os.Parcelable;

public class AvisDTO implements Parcelable{

    protected Long id;
    protected Long numAvis;
    //protected String nomPro;
    //protected String nomSociete;
    //protected String nomClient;
    //protected String prenomClient;
    //protected Long numAnnonce;
    //protected String resumeIntervention;

    protected String descriptionAvis;
    protected long notePrestation;
    protected ParticulierDTO particulierDTO;
    protected ProfilProDTO profilProDTO;

    //protected AnnonceDTO annonceDTO;


    public AvisDTO(){

    }

    protected AvisDTO(Parcel in) {
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readLong();
        }

        if (in.readByte() == 0) {
            numAvis = null;
        } else {
            numAvis = in.readLong();
        }
        notePrestation = in.readLong();
        descriptionAvis = in.readString();

        /*nomPro = in.readString();
        nomSociete = in.readString();
        nomClient = in.readString();
        prenomClient = in.readString();
        if (in.readByte() == 0) {
            numAnnonce = null;
        } else {
            numAnnonce = in.readLong();
        }
        resumeIntervention = in.readString();
        */

    }

//Getters et Setters:


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNumAvis() {
        return numAvis;
    }

    public void setNumAvis(Long numAvis) {
        this.numAvis = numAvis;
    }

    public String getDescriptionAvis() {
        return descriptionAvis;
    }

    public void setDescriptionAvis(String descriptionAvis) {
        this.descriptionAvis = descriptionAvis;
    }
    public long getNotePrestation() {
        return notePrestation;
    }

    public void setNotePrestation(long notePrestation) {
        this.notePrestation = notePrestation;
    }
    /*
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
*/


    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (id == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(id);
        }

        if (numAvis == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(numAvis);
        }
        dest.writeString(descriptionAvis);
        dest.writeLong(notePrestation);
        /*
        dest.writeString(nomPro);
        dest.writeString(nomSociete);
        dest.writeString(nomClient);
        dest.writeString(prenomClient);
        if (numAnnonce == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(numAnnonce);
        }
        dest.writeString(resumeIntervention);
        */

    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<AvisDTO> CREATOR = new Creator<AvisDTO>() {
        @Override
        public AvisDTO createFromParcel(Parcel in) {
            return new AvisDTO(in);
        }

        @Override
        public AvisDTO[] newArray(int size) {
            return new AvisDTO[size];
        }
    };
}
