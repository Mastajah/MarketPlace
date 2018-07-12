package fr.projeti1.marketplace.client.annonce.modifierAnnonce;

import fr.projeti1.marketplace.client.MVPPattern.ActivityPresenter;
import fr.projeti1.marketplace.interfaceS.DTO.AnnonceDTO;
import fr.projeti1.marketplace.interfaceS.DTO.ParticulierDTO;

public class ModifierAnnoncePresenter extends ActivityPresenter<ModifierAnnonceModel, ModifierAnnonceDisplay> implements ModifierAnnoncePresenterCallback {

    //private AnnonceService annonceService;

    public ModifierAnnoncePresenter(ModifierAnnonce view) {
        super(view);
        view.setPresenter(this);
        initPresenter();
    }

    private void initPresenter(){
        model = new ModifierAnnonceModel();

        //Normalement Appel serveur lors de l'init en consultation
        //Pour test, on alimente le DTO
        AnnonceDTO annonceDTO = new AnnonceDTO();
        annonceDTO.setNumeroAnnonce(12L);
        annonceDTO.setTitre("Compteur en rade");
        annonceDTO.setDescription("Le compteur marche plus");
        ParticulierDTO particulierDTO = new ParticulierDTO();
        particulierDTO.setNumeroClient(15L);
        particulierDTO.setNomClient("ESPADES");
        particulierDTO.setPrenomClient("Richard");
        particulierDTO.setNumeroTelephone(0615151515L);
        particulierDTO.setAdresse("45 rue du champ");
        particulierDTO.setVille("Toulouse");
        particulierDTO.setCodePostal(31000L);
        annonceDTO.setParticulierDTO(particulierDTO);
        model.setAnnonceDTO(annonceDTO);

        view.initView();
    }

    @Override
    public void doModifier(){
        view.flush();
        AnnonceDTO inputDTO = model.getAnnonceDTO();
        // AnnonceService.modifierAnnonce(inputDTO);
        view.goToConsulter(inputDTO.getId());
    }

    public ModifierAnnonceModel getModel() {
        return model;
    }
}
