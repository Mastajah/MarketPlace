package fr.projeti1.marketplace.interfaceS.DTO;

import android.os.Parcel;
import android.os.Parcelable;

public class CompetenceDTO implements Parcelable{

    private Long idComp;

    private String libelle;

    private String description;

    public CompetenceDTO(){

    }

    protected CompetenceDTO(Parcel in) {
        if (in.readByte() == 0) {
            idComp = null;
        } else {
            idComp = in.readLong();
        }
        libelle = in.readString();
        description = in.readString();
    }

    public Long getIdComp() {
        return idComp;
    }

    public void setIdComp(Long idComp) {
        this.idComp = idComp;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (idComp == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(idComp);
        }
        dest.writeString(libelle);
        dest.writeString(description);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<CompetenceDTO> CREATOR = new Creator<CompetenceDTO>() {
        @Override
        public CompetenceDTO createFromParcel(Parcel in) {
            return new CompetenceDTO(in);
        }

        @Override
        public CompetenceDTO[] newArray(int size) {
            return new CompetenceDTO[size];
        }
    };
}
