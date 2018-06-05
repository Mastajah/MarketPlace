package fr.projeti1.marketplace.client.ProfilPro.ConsulterProfil;

import fr.projeti1.marketplace.client.MVPPattern.Activity;
import fr.projeti1.marketplace.client.MVPPattern.ActivityPresenter;

public class ConsulterProfilPresenter extends ActivityPresenter {
    protected ConsulterProfil consultProfilView;
    protected ConsulterProfilModel consultProfilModel;

    public ConsulterProfilPresenter(ConsulterProfil vue) {
        super(vue);
        initPresenter();
    }

     private void initPresenter(){
        consultProfilModel = new ConsulterProfilModel();
        consultProfilView.initView();
    }

    public void onClick(android.view.View view){
        //remplir ici
    }

    public ConsulterProfil getConsultProfilView() {
        return consultProfilView;
    }

    public void setConsultProfilView(ConsulterProfil consultProfilView) {
        this.consultProfilView = consultProfilView;
    }

    public ConsulterProfilModel getConsultProfilModel() {
        return consultProfilModel;
    }

    public void setConsultProfilModel(ConsulterProfilModel consultProfilModel) {
        this.consultProfilModel = consultProfilModel;
    }
}
