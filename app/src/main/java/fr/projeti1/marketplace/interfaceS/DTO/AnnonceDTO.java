package fr.projeti1.marketplace.interfaceS.DTO;

import java.io.Serializable;

public class AnnonceDTO implements Serializable{

    private Long id;
    private Long numeroAnnonce;
    private String titre;
    private String description;
    private ParticulierDTO particulierDTO;
    private String ville;
    private String rue;
    private int numVoie;
    private String codePostale;


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

    public String getRue() { return rue; }

    public int getNumVoie() { return numVoie; }

    public String getVille() { return ville; }

    public void setVille(String ville) { this.ville = ville; }

    public void setRue(String rue) { this.rue = rue; }

    public void setNumVoie(int numVoie) { this.numVoie = numVoie; }

    public String getCodePostale() {return codePostale; }

    public void setCodePostale(String codePostale) {this.codePostale = codePostale; }

    public String adressToString(){
        return getNumVoie() + " " + getRue() + " " + getVille() + " " + getCodePostale();
    }
}
