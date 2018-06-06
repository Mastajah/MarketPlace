package fr.projeti1.marketplace.client.annonce.creerAnnonce;

import fr.projeti1.marketplace.client.MVPPattern.ActivityPresenter;
import fr.projeti1.marketplace.interfaceS.DTO.AnnonceDTO;

public class CreerAnnoncePresenter extends ActivityPresenter {

    //private AnnonceService annonceService;

    protected CreerAnnonce mView;
    protected CreerAnnonceModel mModel;

    public CreerAnnoncePresenter(CreerAnnonce view) {
        super(view);
        // En attendant que le pattern soit mieux
        this.mView = view;
        initPresenter();
    }

    private void initPresenter(){
        mModel = new CreerAnnonceModel();
        mView.initView();
    }

    public void doValider(){
        mView.flush();
        AnnonceDTO inputDTO = mModel.getAnnonceDTO();
        // AnnonoceService.creerAnnonce(inputDTO);
    }

    public CreerAnnonceModel getModel() {
        return mModel;
    }
}
