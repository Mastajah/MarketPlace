package fr.projeti1.marketplace.client.ProfilPro.ModifierProfil;

import fr.projeti1.marketplace.client.MVPPattern.ActivityPresenter;


public class ModifierProfilPresenter extends ActivityPresenter {
    protected ModifierProfil modifyProfilView;
    protected ModifierProfilModel modifyProfilModel;

    public ModifierProfilPresenter (ModifierProfil vue){
        super(vue);
        // En attendant que le pattern soit mieux
        this.modifyProfilView = vue;
        initPresenter();
    }

    private void initPresenter(){
        modifyProfilModel = new ModifierProfilModel();
        modifyProfilView.initView();
    }

    public void onClick(android.view.View view){
        //remplir ici
    }

    public ModifierProfil getModifyProfilView() {
        return modifyProfilView;
    }

    public void setModifyProfilView(ModifierProfil modifyProfilView) {
        this.modifyProfilView = modifyProfilView;
    }

    public ModifierProfilModel getModifyProfilModel() {
        return modifyProfilModel;
    }

    public void setModifyProfilModel(ModifierProfilModel modifyProfilModel) {
        this.modifyProfilModel = modifyProfilModel;
    }
}
