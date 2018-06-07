package fr.projeti1.marketplace.interfaceS.DTO;

public class AnnonceDTO{
    private Long numeroAnnonce;
    private String titre;
    private String description;
    private ClientDTO clientDTO;
    private String ville;
    private String rue;
    private int numVoie;
    private String codePostale;

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

    public ClientDTO getClientDTO() {
        return clientDTO;
    }

    public void setClientDTO(ClientDTO clientDTO) {
        this.clientDTO = clientDTO;
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
        return getNumVoie() + " " + getNumVoie() + " " + getVille() + " " + getCodePostale();
    }
}
