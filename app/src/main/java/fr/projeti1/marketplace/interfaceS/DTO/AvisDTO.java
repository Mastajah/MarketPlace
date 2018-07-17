package fr.projeti1.marketplace.interfaceS.DTO;

import android.os.Parcel;
import android.os.Parcelable;

import fr.projeti1.marketplace.server.entity.ProfilPro;

public class AvisDTO implements Parcelable{

    protected Long id;
    protected Long numAvis;
    protected String descriptionAvis;
    protected long notePrestation;
    protected ParticulierDTO particulierDTO;
    protected ProfilProDTO profilProDTO;

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
        particulierDTO = in.readParcelable(ParticulierDTO.class.getClassLoader());
        profilProDTO = in.readParcelable(ProfilPro.class.getClassLoader());

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

    public ParticulierDTO getParticulierDTO() {
        return particulierDTO;
    }

    public void setParticulierDTO(ParticulierDTO particulierDTO) {
        this.particulierDTO = particulierDTO;
    }

    public ProfilProDTO getProfilProDTO() {
        return profilProDTO;
    }

    public void setProfilProDTO(ProfilProDTO profilProDTO) {
        this.profilProDTO = profilProDTO;
    }

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
