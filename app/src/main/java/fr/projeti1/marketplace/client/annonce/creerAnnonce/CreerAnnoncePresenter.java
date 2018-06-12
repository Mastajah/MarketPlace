package fr.projeti1.marketplace.client.annonce.creerAnnonce;

import fr.projeti1.marketplace.client.MVPPattern.ActivityContract;
import fr.projeti1.marketplace.client.MVPPattern.ActivityPresenter;
import fr.projeti1.marketplace.interfaceS.DTO.AnnonceDTO;

public class CreerAnnoncePresenter extends ActivityPresenter<CreerAnnonceModel, CreerAnnonceDisplay> implements CreerAnnoncePresenterCallBack {

    //private AnnonceService annonceService;

    public CreerAnnoncePresenter(CreerAnnonce view) {
        super(view);
        view.setPresenter(this);
        initPresenter();
    }

    private void initPresenter(){
        model = new CreerAnnonceModel();
        view.initView();
    }

    @Override
    public void doValider(){
        view.flush();
        AnnonceDTO inputDTO = model.getAnnonceDTO();
        // AnnonceService.creerAnnonce(inputDTO);
        view.goToConsulter(inputDTO.getNumeroAnnonce());
    }

    public CreerAnnonceModel getModel() {
        return model;
    }
}
