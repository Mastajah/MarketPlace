package fr.projeti1.marketplace.client.annonce.creer_annonce;

import fr.projeti1.marketplace.client.MVPPattern.ActivityPresenter;

public class CreerAnnoncePresenter extends ActivityPresenter{

    protected CreerAnnonce mView;
    protected CreerAnnonceModel mModel;

    public CreerAnnoncePresenter(CreerAnnonce view) {
        super(view);
        initPresenter();
    }

    private void initPresenter(){
        mModel = new CreerAnnonceModel();
        mView.initView();
    }

    @Override
    public void onClick(android.view.View view){
        mView.bind();
    }

    public CreerAnnonceModel getModel() {
        return mModel;
    }
}
