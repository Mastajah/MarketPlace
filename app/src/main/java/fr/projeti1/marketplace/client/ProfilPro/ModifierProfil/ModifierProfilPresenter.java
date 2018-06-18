package fr.projeti1.marketplace.client.ProfilPro.ModifierProfil;

import fr.projeti1.marketplace.client.MVPPattern.ActivityPresenter;


public class ModifierProfilPresenter extends ActivityPresenter<ModifierProfilModel,ModifierProfilDisplay> implements ModifierProfilPresenterCallBack {

    public ModifierProfilPresenter (ModifierProfil vue){
        super(vue);
        vue.setPresenter(this);
        initPresenter();
    }

    private void initPresenter(){
        model= new ModifierProfilModel();
        view.initView();
    }

    public void onClickValiderModif(){
        //remplir ici
    }

    @Override
    public ModifierProfilModel getModel(){
        return this.model;
    }
}
