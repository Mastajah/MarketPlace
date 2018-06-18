package fr.projeti1.marketplace.client.Avis.CreerAvis;

import fr.projeti1.marketplace.client.MVPPattern.ActivityPresenter;
import fr.projeti1.marketplace.client.MVPPattern.ActivityContract;
import fr.projeti1.marketplace.interfaceS.DTO.AvisDTO;

public class CreerAvisPresenter extends ActivityPresenter <CreerAvisModel,CreerAvisDisplay> implements CreerAvisPresenterCallBack {


    public CreerAvisPresenter(CreerAvis view) {
        super(view);
        view.setPresenter(this);
        initPresenter();
    }

    private void initPresenter() {
        model = new CreerAvisModel();
        view.initView();
    }

    @Override
    public void onClickValider() {
        //remplir ici
    }

    @Override
    public CreerAvisModel getModel() {
        return model ;
    }
}


