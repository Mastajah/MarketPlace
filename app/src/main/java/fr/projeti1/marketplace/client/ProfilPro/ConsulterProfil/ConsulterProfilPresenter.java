package fr.projeti1.marketplace.client.ProfilPro.ConsulterProfil;

import fr.projeti1.marketplace.client.MVPPattern.Activity;
import fr.projeti1.marketplace.client.MVPPattern.ActivityPresenter;
import fr.projeti1.marketplace.interfaceS.DTO.ProfilProDTO;

public class ConsulterProfilPresenter extends ActivityPresenter {
    protected ConsulterProfil consultProfilView;
    protected ConsulterProfilModel consultProfilModel;

    //Pareil pour Modifier Profil
    //On garde en mémoire l'id du profil pour l'avoir partout - il sera set dans le onCreate de ConsulterProfil
    //Id du Profil Professionnel
    private Long idProfilPro;

    public ConsulterProfilPresenter(ConsulterProfil vue) {
        super(vue);
        // En attendant que le pattern soit mieux
        this.consultProfilView = vue;
        initPresenter();
    }

     private void initPresenter(){
        consultProfilModel = new ConsulterProfilModel();

        ProfilProDTO dto = new ProfilProDTO();
        dto.setNumeroPro(12L);
        dto.setNomPro("BENSOMBES");
        dto.setPrenomPro("Richard");
        dto.setNomSociete("BESSELAM");
        dto.setSiretSociete(4584598L);
        dto.setNumDecennale("AE457F");
        dto.setNumeroTelephone(0654545454l);
        dto.setMail("richard.bensombes@yahou.fr");
        dto.setAdresse("75 rue des champs");
        dto.setVille("Toulouse");
        dto.setCodePostal(31000L);

        consultProfilModel.setConsultProfilProDTO(dto);

        consultProfilView.initView();
    }

    public void supprimerProfilPro(){
        //Appel service en passant l'id du profil
        //remplir ici
    }

    public ConsulterProfil getConsultProfilView() {
        return consultProfilView;
    }

    public void setConsultProfilView(ConsulterProfil consultProfilView) {
        this.consultProfilView = consultProfilView;
    }

    public ConsulterProfilModel getConsultProfilModel() {
        return consultProfilModel;
    }

    public void setConsultProfilModel(ConsulterProfilModel consultProfilModel) {
        this.consultProfilModel = consultProfilModel;
    }

    public Long getIdProfilPro() {
        return idProfilPro;
    }

    public void setIdProfilPro(Long idProfilPro) {
        this.idProfilPro = idProfilPro;
    }
}
