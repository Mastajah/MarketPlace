package fr.projeti1.marketplace.client.Avis.CreerAvis;

import fr.projeti1.marketplace.client.MVPPattern.ActivityPresenter;

public class CreerAvisPresenter extends ActivityPresenter {

    protected CreerAvis createAvisView;
    protected CreerAvisModel createAvisModel;

    public CreerAvisPresenter (CreerAvis vue){
        super(vue);
        // En attendant que le pattern soit mieux
        this.createAvisView = vue;
        initPresenter();
    }

    private void initPresenter(){
        createAvisModel = new CreerAvisModel();
        createAvisView.initView();
    }

    public void onClick(android.view.View view){
        //remplir ici
    }

    public CreerAvis getCreateAvisView() {
        return createAvisView;
    }

    public void setCreateAvisView(CreerAvis createAvisView) {
        this.createAvisView = createAvisView;
    }

    public CreerAvisModel getCreateAvisModel() {
        return createAvisModel;
    }

    public void setCreateAvisModel(CreerAvisModel createAvisModel) {
        this.createAvisModel = createAvisModel;
    }
}
