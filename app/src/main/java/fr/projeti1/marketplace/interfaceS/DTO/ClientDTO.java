package fr.projeti1.marketplace.interfaceS.DTO;

public class ClientDTO {

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
}
