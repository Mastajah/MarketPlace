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
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeLong(numeroAnnonce);
        dest.writeString(adresse);
        dest.writeString(codePostale);
        dest.writeString(ville);
        dest.writeString(dateCloture);
        dest.writeString(dateCreation);
        dest.writeString(description);
        dest.writeParcelable(particulierDTO,flags);
        dest.writeString(titre);
    }

    public static final Parcelable.Creator<AnnonceDTO> CREATOR = new Parcelable.Creator<AnnonceDTO>()
    {
        @Override
        public AnnonceDTO createFromParcel(Parcel source)
        {
            return new AnnonceDTO(source);
        }

        @Override
        public AnnonceDTO[] newArray(int size)
        {
            return new AnnonceDTO[size];
        }
    };

    public AnnonceDTO(Parcel in) {
        this.id = in.readLong();
        this.numeroAnnonce = in.readLong();
        this.adresse = in.readString();
        this.codePostale = in.readString();
        this.ville = in.readString();
        this.dateCloture = in.readString();
        this.dateCreation = in.readString();
        this.titre = in.readString();
        this.description = in.readString();
        this.particulierDTO = in.readParcelable(ParticulierDTO.class.getClassLoader());
    }
}
