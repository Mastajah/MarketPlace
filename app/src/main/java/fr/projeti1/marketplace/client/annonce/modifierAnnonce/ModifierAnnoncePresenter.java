package fr.projeti1.marketplace.client.annonce.modifierAnnonce;

import fr.projeti1.marketplace.client.MVPPattern.ActivityPresenter;
import fr.projeti1.marketplace.interfaceS.DTO.AnnonceDTO;

public class ModifierAnnoncePresenter extends ActivityPresenter {

    //private AnnonceService annonceService;

    protected ModifierAnnonce mView;
    protected ModifierAnnonceModel mModel;

    public ModifierAnnoncePresenter(ModifierAnnonce view) {
        super(view);
        initPresenter();
    }

    private void initPresenter(){
        mModel = new ModifierAnnonceModel();
        mView.initView();
    }

    public void doModifier(){
        mView.flush();
        AnnonceDTO inputDTO = mModel.getAnnonceDTO();
        // AnnonoceService.modifierAnnonce(inputDTO);
    }

    public ModifierAnnonceModel getModel() {
        return mModel;
    }
}
