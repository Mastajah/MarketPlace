package fr.projeti1.marketplace.interfaceS.DTO;

import android.os.Parcel;
import android.os.Parcelable;

public class AnnonceDTO implements Parcelable{

    private Long id;
    private Long numeroAnnonce;
    private String titre;
    private String description;
    private ParticulierDTO particulierDTO;
    private String ville;
    private String adresse;
    private String codePostale;
    private String dateCreation;
    private String dateCloture;

    public AnnonceDTO() {

    }

    protected AnnonceDTO(Parcel in) {
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readLong();
        }
        if (in.readByte() == 0) {
            numeroAnnonce = null;
        } else {
            numeroAnnonce = in.readLong();
        }
        titre = in.readString();
        description = in.readString();
        particulierDTO = in.readParcelable(ParticulierDTO.class.getClassLoader());
        ville = in.readString();
        adresse = in.readString();
        codePostale = in.readString();
        dateCreation = in.readString();
        dateCloture = in.readString();
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(String dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String getDateCloture() {
        return dateCloture;
    }

    public void setDateCloture(String dateCloture) {
        this.dateCloture = dateCloture;
    }
    //private CompetenceDTO competenceDTO;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNumeroAnnonce() {
        return numeroAnnonce;
    }

    public void setNumeroAnnonce(Long numeroAnnonce) {
        this.numeroAnnonce = numeroAnnonce;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ParticulierDTO getParticulierDTO() {
        return particulierDTO;
    }

    public void setParticulierDTO(ParticulierDTO particulierDTO) {
        this.particulierDTO = particulierDTO;
    }

    public String getVille() { return ville; }

    public void setVille(String ville) { this.ville = ville; }

    public String getCodePostale() {return codePostale; }

    public void setCodePostale(String codePostale) {this.codePostale = codePostale; }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (id == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(id);
        }
        if (numeroAnnonce == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(numeroAnnonce);
        }
        dest.writeString(titre);
        dest.writeString(description);
        dest.writeParcelable(particulierDTO, flags);
        dest.writeString(ville);
        dest.writeString(adresse);
        dest.writeString(codePostale);
        dest.writeString(dateCreation);
        dest.writeString(dateCloture);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<AnnonceDTO> CREATOR = new Creator<AnnonceDTO>() {
        @Override
        public AnnonceDTO createFromParcel(Parcel in) {
            return new AnnonceDTO(in);
        }

        @Override
        public AnnonceDTO[] newArray(int size) {
            return new AnnonceDTO[size];
        }
    };
}
