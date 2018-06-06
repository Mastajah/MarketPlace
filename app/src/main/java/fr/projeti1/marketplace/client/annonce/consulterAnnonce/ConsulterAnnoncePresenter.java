package fr.projeti1.marketplace.client.annonce.consulterAnnonce;

import fr.projeti1.marketplace.client.MVPPattern.ActivityPresenter;
import fr.projeti1.marketplace.interfaceS.DTO.AnnonceDTO;
import fr.projeti1.marketplace.interfaceS.DTO.ClientDTO;

public class ConsulterAnnoncePresenter extends ActivityPresenter{

    //private AnnonceService annonceService;

    private ConsulterAnnonce mView;
    private ConsulterAnnonceModel mModel;

    //Maintenant nom client en exemple, plus tard idAnnonce
    private String nomClient;

    //On construisant la classe, on alimente direct l'idAnnonce plus tard, maintenant nomClient
    public ConsulterAnnoncePresenter(ConsulterAnnonce view,String nomClient) {
        super(view);
        // En attendant que le pattern soit mieux
        this.mView = view;
        this.nomClient = nomClient;
        initPresenter();
    }

    private void initPresenter(){
        this.mModel = new ConsulterAnnonceModel();

        //Normalement Appel serveur lors de l'init en consultation
        //Pour test, on alimente le DTO
        AnnonceDTO annonceDTO = new AnnonceDTO();
        annonceDTO.setNumeroAnnonce(12L);
        annonceDTO.setTitre("Compteur en rade");
        annonceDTO.setDescription("Le compteur marche plus");
        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setNumeroClient(15L);
        clientDTO.setNomClient("ESPADES");
        clientDTO.setPrenomClient("Richard");
        clientDTO.setNumeroTelephone(0615151515L);
        clientDTO.setAdresse("45 rue du champ");
        clientDTO.setVille("Toulouse");
        clientDTO.setCodePostal(31000L);
        annonceDTO.setClientDTO(clientDTO);
        mModel.setAnnonceDTO(annonceDTO);

        mView.initView();
    }

    public ConsulterAnnonceModel getModel() {
        return this.mModel;
    }

    public String getNomClient() {
        return nomClient;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }
}
