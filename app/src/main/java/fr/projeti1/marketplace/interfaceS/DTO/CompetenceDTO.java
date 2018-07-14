package fr.projeti1.marketplace.interfaceS.DTO;

import android.os.Parcel;
import android.os.Parcelable;

public class CompetenceDTO implements Parcelable{

    private Long idComp;

    private String libelle;

    private String description;

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
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(idComp);
        dest.writeString(libelle);
        dest.writeString(description);
    }

    public static final Parcelable.Creator<CompetenceDTO> CREATOR = new Parcelable.Creator<CompetenceDTO>()
    {
        @Override
        public CompetenceDTO createFromParcel(Parcel source)
        {
            return new CompetenceDTO(source);
        }

        @Override
        public CompetenceDTO[] newArray(int size)
        {
            return new CompetenceDTO[size];
        }
    };

    public CompetenceDTO(Parcel in) {
        this.idComp = in.readLong();
        this.libelle = in.readString();
        this.description = in.readString();
    }
}
