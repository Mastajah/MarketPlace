package fr.projeti1.marketplace.client.annonce.consulterAnnonce;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import fr.projeti1.marketplace.R;
import fr.projeti1.marketplace.client.MVPPattern.Activity;
import fr.projeti1.marketplace.client.Start.MenuTmpActivity;
import fr.projeti1.marketplace.interfaceS.DTO.AnnonceDTO;
import fr.projeti1.marketplace.interfaceS.DTO.ClientDTO;

/**
 * Vue de la consultation d'annonce
 */
public class ConsulterAnnonce extends Activity {

    private ConsulterAnnoncePresenter mPresenter;

    /**
     * Elements IHM que l'on va custom
     */
    private TextView numAnnonceConsult;
    private TextView numClientConsult;
    private TextView nomClientConsult;
    private TextView prenomClientConsult;
    private TextView numTelConsult;
    private TextView titreAnnonceConsult;
    private TextView descriptionConsult;
    private TextView adresseConsult;
    private TextView villeConsult;
    private TextView codePostalConsult;
    private Button menuTmp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.consulter_annonce);

        //on récupère l'intent pour récupérer les données qu'on s'est fait passé
        Intent intent = getIntent();
        this.mPresenter = new ConsulterAnnoncePresenter(this,intent.getStringExtra("nomClient"));
        bind();
    }

    /**
     * Initialisation de la vue
     */
    @Override
    public void initView() {
        super.initView();
        numAnnonceConsult = findViewById(R.id.numAnnonceConsult);
        numClientConsult = findViewById(R.id.numClientConsult);
        nomClientConsult = findViewById(R.id.nomClientConsult);
        prenomClientConsult = findViewById(R.id.prenomClientConsult);
        numTelConsult = findViewById(R.id.numTelConsult);
        titreAnnonceConsult = findViewById(R.id.titreAnnonceConsult);
        descriptionConsult = findViewById(R.id.descriptionConsult);
        adresseConsult = findViewById(R.id.adresseConsult);
        villeConsult = findViewById(R.id.villeConsult);
        codePostalConsult = findViewById(R.id.codePostalConsult);
        menuTmp = findViewById(R.id.menu_tmp_button_Consult);
        menuTmp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent connection = new Intent(getApplicationContext(), MenuTmpActivity.class);
                startActivity(connection);
                finish();
            }
        });
    }

    public void bind(){
        //On récupère les données de notre Model
        AnnonceDTO annonceDTO = this.mPresenter.getModel().getAnnonceDTO();
        ClientDTO clientDTO = annonceDTO.getClientDTO();

        //On set les éléments IHM
        numAnnonceConsult.setText(String.valueOf(annonceDTO.getNumeroAnnonce()));
        numClientConsult.setText(String.valueOf(clientDTO.getNumeroClient()));
        //Plus tard alimenté par le DTO, ici c'est un exemple
        nomClientConsult.setText(mPresenter.getNomClient());
        prenomClientConsult.setText(clientDTO.getPrenomClient());
        numTelConsult.setText(String.valueOf(clientDTO.getNumeroTelephone()));
        titreAnnonceConsult.setText(annonceDTO.getTitre());
        descriptionConsult.setText(annonceDTO.getDescription());
        adresseConsult.setText(clientDTO.getAdresse());
        villeConsult.setText(clientDTO.getVille());
        codePostalConsult.setText(String.valueOf(clientDTO.getCodePostal()));
    }

    public void flush(){
        //Pas appellé ici
    }
}
