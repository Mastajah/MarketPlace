package fr.projeti1.marketplace.client.Avis.ModifierAvis;

import fr.projeti1.marketplace.client.MVPPattern.ActivityPresenter;

public class ModifierAvisPresenter extends ActivityPresenter<ModifierAvisModel,ModifierAvisDisplay> implements ModifierAvisPresenterCallBack {

    public ModifierAvisPresenter (ModifierAvis view){
        super(view);
        view.setPresenter(this);
        initPresenter();
    }

    private void initPresenter(){
        model = new ModifierAvisModel();
        view.initView();
    }

    @Override
    public void onClickValiderModif(){
        //remplir
    }

    @Override
    public ModifierAvisModel getModel(){
        return model;
    }
}
