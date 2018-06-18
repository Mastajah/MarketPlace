package fr.projeti1.marketplace.client.ProfilPro.ConsulterProfil;

import fr.projeti1.marketplace.client.MVPPattern.Activity;
import fr.projeti1.marketplace.client.MVPPattern.ActivityPresenter;
import fr.projeti1.marketplace.interfaceS.DTO.ProfilProDTO;

public class ConsulterProfilPresenter extends ActivityPresenter <ConsulterProfilModel,ConsulterProfilDisplay> implements ConsulterProfilPresenterCallBack {

    private Long idProfilPro;

    public ConsulterProfilPresenter(ConsulterProfil vue) {
        super(vue);
        // En attendant que le pattern soit mieux
        vue.setPresenter(this);
        initPresenter();
    }

     private void initPresenter(){
        model = new ConsulterProfilModel();

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

        model.setConsultProfilProDTO(dto);

        view.initView();
    }

    @Override
    public void supprimerProfilPro(){
        //Appel service en passant l'id du profil
        //remplir ici
    }

    @Override
    public ConsulterProfilModel getModel(){
        return model;
    }

    @Override
    public Long getIdProfilPro() {
        return this.idProfilPro;
    }
}
