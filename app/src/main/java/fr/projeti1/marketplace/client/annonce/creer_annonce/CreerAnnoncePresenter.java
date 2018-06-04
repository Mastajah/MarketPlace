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
        // Par exemple, sur le clic 'valider', on fait un flush()
        // Puis on fait appel à notre service qui fait appel à notre DAO
        // Plusieurs appels peuvent se faire si pas grosse requête
        // On récupère sous la forme DTO un objet métier ou plusieurs
        // Puis on set le model : mModel.setAnnonceDTO(annonceDTO) et mModel.setClientDTO(clientDTO)
        // annonceDTO et client DTO que l'on a récupéré des requêtes
        // Et on fait un bind pour tout afficher IHM ou on déclare un Intent pour changer d'activité
        mView.bind();
    }

    public CreerAnnonceModel getModel() {
        return mModel;
    }
}
