package fr.projeti1.marketplace.client.Avis.ConsulterAvis;

import fr.projeti1.marketplace.client.MVPPattern.ActivityPresenter;

public class ConsulterAvisPresenter extends ActivityPresenter <ConsulterAvisModel,ConsulterAvisDisplay> implements ConsulterAvisPresenterCallBack {

    private Long idAvis;

    public ConsulterAvisPresenter(ConsulterAvisPro view, Long idAvis){
        super(view);
        view.setPresenter(this);
        initPresenter();
    }

    private void initPresenter(){
        this.model = new ConsulterAvisModel();
        //compléter ici en dur pour tester
        view.initView();
    }

    public ConsulterAvisModel getModel(){
        return  this.model;
    }

    @Override
    public Long getIdAvis() {
        return this.idAvis;
    }
}
