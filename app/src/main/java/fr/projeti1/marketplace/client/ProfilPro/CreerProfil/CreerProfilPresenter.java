package fr.projeti1.marketplace.client.ProfilPro.CreerProfil;

import fr.projeti1.marketplace.client.MVPPattern.ActivityPresenter;

public class CreerProfilPresenter extends ActivityPresenter {
    protected CreerProfil createProfilView;
    protected CreerProfilModel createProfilModel;

    public CreerProfilPresenter (CreerProfil vue){
        super(vue);
        initPresenter();
    }

    private void initPresenter(){
        createProfilModel = new CreerProfilModel();
        createProfilView.initView();
    }

    public void onClick(android.view.View view){
        //remplir ici
    }

}
