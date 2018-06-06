package fr.projeti1.marketplace.client.ProfilPro.CreerProfil;

import fr.projeti1.marketplace.client.MVPPattern.ActivityPresenter;

public class CreerProfilPresenter extends ActivityPresenter {
    protected CreerProfil createProfilView;
    protected CreerProfilModel createProfilModel;

    public CreerProfilPresenter (CreerProfil vue){
        super(vue);
        // En attendant que le pattern soit mieux
        this.createProfilView = vue;
        initPresenter();
    }

    private void initPresenter(){
        createProfilModel = new CreerProfilModel();
        createProfilView.initView();
    }

    public void onClick(android.view.View view){
        //remplir ici
    }

    public CreerProfil getCreateProfilView() {
        return createProfilView;
    }

    public void setCreateProfilView(CreerProfil createProfilView) {
        this.createProfilView = createProfilView;
    }

    public CreerProfilModel getCreateProfilModel() {
        return createProfilModel;
    }

    public void setCreateProfilModel(CreerProfilModel createProfilModel) {
        this.createProfilModel = createProfilModel;
    }
}
