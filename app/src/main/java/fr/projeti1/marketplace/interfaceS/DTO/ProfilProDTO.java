package fr.projeti1.marketplace.interfaceS.DTO;

public class ProfilProDTO {

    private Long numeroPro;
    private String nomPro;
    private String prenomPro;
    private String nomSociete;
    private Long siretSociete;
    private String numDecennale;
    private String competence; // modifier pour correspondre au fragment compétence
    private Long numeroTelephone;
    private String mail;
    private String Adresse;
    private String Ville;
    private Long codePostal;

    public ProfilProDTO() {
    }

    public Long getNumeroPro() {
        return numeroPro;
    }

    public void setNumeroPro(Long numeroPro) {
        this.numeroPro = numeroPro;
    }

    public String getNomPro() {
        return nomPro;
    }

    public void setNomPro(String nomPro) {
        this.nomPro = nomPro;
    }

    public String getPrenomPro() {
        return prenomPro;
    }

    public void setPrenomPro(String prenomPro) {
        this.prenomPro = prenomPro;
    }

    public String getNomSociete() {
        return nomSociete;
    }

    public void setNomSociete(String nomSociete) {
        this.nomSociete = nomSociete;
    }

    public Long getSiretSociete() {
        return siretSociete;
    }

    public void setSiretSociete(Long siretSociete) {
        this.siretSociete = siretSociete;
    }

    public String getNumDecennale() {
        return numDecennale;
    }

    public void setNumDecennale(String numDecennale) {
        this.numDecennale = numDecennale;
    }

    public String getCompetence() {
        return competence;
    }

    public void setCompetence(String competence) {
        this.competence = competence;
    }

    public Long getNumeroTelephone() {
        return numeroTelephone;
    }

    public void setNumeroTelephone(Long numeroTelephone) {
        this.numeroTelephone = numeroTelephone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
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
