package fr.projeti1.marketplace.client.annonce.consulterAnnonce;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import fr.projeti1.marketplace.R;
import fr.projeti1.marketplace.client.MVPPattern.Activity;
import fr.projeti1.marketplace.client.Start.menu.MenuTmpActivity;
import fr.projeti1.marketplace.interfaceS.DTO.AnnonceDTO;
import fr.projeti1.marketplace.interfaceS.DTO.ParticulierDTO;

/**
 * Vue de la consultation d'annonce
 */
public class ConsulterAnnonce extends Activity<ConsulterAnnoncePresenterCallback> implements ConsulterAnnonceDisplay {

    /**
     * Elements IHM que l'on va custom
     */
    private TextView libelleTitreConsult;
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
        presenter = new ConsulterAnnoncePresenter(this,intent.getLongExtra("idAnnonce",0l));
        bind();
    }

    /**
     * Initialisation de la vue
     */
    @Override
    public void initView() {
        super.initView();
        libelleTitreConsult = findViewById(R.id.libelleTitreConsult);
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

    @Override
    public void bind(){
        //On récupère les données de notre Model
        AnnonceDTO annonceDTO = this.presenter.getModel().getAnnonceDTO();
        ParticulierDTO particulierDTO = annonceDTO.getParticulierDTO();

        //On set les éléments IHM
        libelleTitreConsult.setText("Detail de l\'annonce n°" + String.valueOf(annonceDTO.getNumeroAnnonce()));
        numClientConsult.setText(String.valueOf(particulierDTO.getNumeroClient()));
        nomClientConsult.setText(particulierDTO.getNomClient());
        prenomClientConsult.setText(particulierDTO.getPrenomClient());
        numTelConsult.setText(String.valueOf(particulierDTO.getNumeroTelephone()));
        titreAnnonceConsult.setText(annonceDTO.getTitre());
        descriptionConsult.setText(annonceDTO.getDescription());
        adresseConsult.setText(particulierDTO.getAdresse());
        villeConsult.setText(particulierDTO.getVille());
        codePostalConsult.setText(String.valueOf(particulierDTO.getCodePostal()));
    }

    @Override
    public void flush(){
        //Pas appellé ici
    }

    // Besoin du oontext dans le presenter
    public Context getContext(){
        return this.getApplicationContext();
    }

    // L'activité est ici, et seule l'activité a la main sur la fonction startService() donc aussi définie dans le display
    public void startIntentService(Intent intentService){
        startService(intentService);
    }

    // L'activité est ici, et seule l'activité a la main sur la fonction startService() donc aussi définit dans le display
    public void registerListener(BroadcastReceiver receiver){
        registerListener(receiver);
    }
}
