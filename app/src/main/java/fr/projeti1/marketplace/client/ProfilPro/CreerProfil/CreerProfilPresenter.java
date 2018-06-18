package fr.projeti1.marketplace.client.ProfilPro.CreerProfil;

import fr.projeti1.marketplace.client.MVPPattern.ActivityPresenter;

public class CreerProfilPresenter extends ActivityPresenter<CreerProfilModel,CreerProfilDisplay> implements CreerProfilPresenterCallBack {

    public CreerProfilPresenter(CreerProfil vue) {
        super(vue);
        vue.setPresenter(this);
        initPresenter();
    }

    private void initPresenter() {
        model = new CreerProfilModel();
        view.initView();
    }

    @Override
    public void onClickValider() {
        //remplir ici
    }

    @Override
    public CreerProfilModel getModel(){
        return model;
    }
}
