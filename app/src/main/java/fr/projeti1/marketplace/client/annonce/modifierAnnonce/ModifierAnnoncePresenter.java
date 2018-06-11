package fr.projeti1.marketplace.client.annonce.modifierAnnonce;

import android.content.Intent;

import fr.projeti1.marketplace.client.MVPPattern.ActivityPresenter;
import fr.projeti1.marketplace.client.annonce.consulterAnnonce.ConsulterAnnonce;
import fr.projeti1.marketplace.interfaceS.DTO.AnnonceDTO;
import fr.projeti1.marketplace.interfaceS.DTO.ClientDTO;

public class ModifierAnnoncePresenter extends ActivityPresenter<ModifierAnnonceModel, ModifierAnnonceDisplay> implements ModifierAnnoncePresenterCallback {

    //private AnnonceService annonceService;

    public ModifierAnnoncePresenter(ModifierAnnonce view) {
        super(view);
        // En attendant que le pattern soit mieux
        this.view = view;
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
        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setNumeroClient(15L);
        clientDTO.setNomClient("ESPADES");
        clientDTO.setPrenomClient("Richard");
        clientDTO.setNumeroTelephone(0615151515L);
        clientDTO.setAdresse("45 rue du champ");
        clientDTO.setVille("Toulouse");
        clientDTO.setCodePostal(31000L);
        annonceDTO.setClientDTO(clientDTO);
        model.setAnnonceDTO(annonceDTO);

        view.initView();
    }

    @Override
    public void doModifier(){
        view.flush();
        AnnonceDTO inputDTO = model.getAnnonceDTO();
        // AnnonceService.modifierAnnonce(inputDTO);
        view.goToConsulter(inputDTO.getClientDTO().getNomClient());
    }

    public ModifierAnnonceModel getModel() {
        return model;
    }
}
