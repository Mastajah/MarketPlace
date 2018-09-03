package fr.projeti1.marketplace.client.annonce.modifierAnnonce;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import fr.projeti1.marketplace.R;
import fr.projeti1.marketplace.client.MVPPattern.Activity;
import fr.projeti1.marketplace.client.Start.menu.MenuTmpActivity;
import fr.projeti1.marketplace.client.annonce.consulterAnnonce.ConsulterAnnonce;
import fr.projeti1.marketplace.interfaceS.DTO.AnnonceDTO;
import fr.projeti1.marketplace.interfaceS.DTO.ParticulierDTO;

/**
 * Vue de la modification d'annonce
 */
public class ModifierAnnonce extends Activity<ModifierAnnoncePresenterCallback> implements ModifierAnnonceDisplay{

    /**
     * Elements IHM que l'on va custom
     */
    private TextView libelleTitreCreerModifAnnonce;
    private TextView numClientCreaModif;
    private EditText textfieldNomClient;
    private EditText textfieldPrenomClient;
    private EditText textfieldNumTel;
    private EditText textfieldTitreAnnonce;
    private EditText textfieldDescrption;
    private EditText textfieldAdresse;
    private EditText textfieldVille;
    private EditText textfieldCodepostal;
    private EditText statutAnnonce;
    private Button buttonValider;
    private Button menuTmp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.creer_modifier_annonce);

        presenter = new ModifierAnnoncePresenter(this);
        //Ici on affiche direct car consultation, et on a déja alimenté le model
        bind();
    }

    /**
     * Initialisation de la vue
     */
    @Override
    public void initView() {
        super.initView();
        statutAnnonce=findViewById(R.id.statutAnnonceCreaModif);
        libelleTitreCreerModifAnnonce = findViewById(R.id.libelleTitreCreerModifAnnonce);
        libelleTitreCreerModifAnnonce.setText("Modifier une annonce");
        numClientCreaModif = findViewById(R.id.numClientCreaModif);
        textfieldNomClient = findViewById(R.id.textfieldNomClient);
        textfieldPrenomClient = findViewById(R.id.textfieldPrenomClient);
        textfieldNumTel = findViewById(R.id.textfieldNumTel);
        textfieldTitreAnnonce = findViewById(R.id.textfieldTitreAnnonce);
        textfieldDescrption = findViewById(R.id.textfieldDescrption);
        textfieldAdresse = findViewById(R.id.textfieldAdresse);
        textfieldVille = findViewById(R.id.textfieldVille);
        textfieldCodepostal = findViewById(R.id.textfieldCodepostal);
        buttonValider = findViewById(R.id.valider_creer_annonce);
        buttonValider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.doModifier();
            }
        });
        menuTmp = findViewById(R.id.menu_tmp_button_CreaModif);
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
        AnnonceDTO annonceDTO = presenter.getModel().getAnnonceDTO();
        ParticulierDTO particulierDTO = annonceDTO.getParticulierDTO();

        //On set les éléments IHM
        statutAnnonce.setText(annonceDTO.getStatut());
        numClientCreaModif.setText(String.valueOf(particulierDTO.getNumeroClient()));
        textfieldNomClient.setText(particulierDTO.getNomClient());
        textfieldPrenomClient.setText(particulierDTO.getPrenomClient());
        textfieldNumTel.setText(String.valueOf(particulierDTO.getNumeroTelephone()));
        textfieldTitreAnnonce.setText(annonceDTO.getTitre());
        textfieldDescrption.setText(annonceDTO.getDescription());
        textfieldAdresse.setText(particulierDTO.getAdresse());
        textfieldVille.setText(particulierDTO.getVille());
        textfieldCodepostal.setText(String.valueOf(particulierDTO.getCodePostal()));
    }

    public void flush(){
        //On instancie les DTO
        AnnonceDTO annonceDTO = new AnnonceDTO();
        ParticulierDTO particulierDTO = new ParticulierDTO();

        //On récupère les informations de la vue en remplissant les DTO
        particulierDTO.setNomClient(textfieldNomClient.getText().toString());
        particulierDTO.setPrenomClient(textfieldPrenomClient.getText().toString());
        particulierDTO.setNumeroTelephone(Long.parseLong(textfieldNumTel.getText().toString()));
        particulierDTO.setAdresse(textfieldAdresse.getText().toString());
        particulierDTO.setVille(textfieldVille.getText().toString());
        particulierDTO.setCodePostal(Long.parseLong(textfieldCodepostal.getText().toString()));
        annonceDTO.setStatut(statutAnnonce.getText().toString());
        annonceDTO.setTitre(textfieldTitreAnnonce.getText().toString());
        annonceDTO.setDescription(textfieldDescrption.getText().toString());
        annonceDTO.setParticulierDTO(particulierDTO);

        //On alimente le model
        presenter.getModel().setAnnonceDTO(annonceDTO);
    }

    public void goToConsulter(Long idAnnonce){
        //Affichage dans consultation annonce

        //On déclare un intent pour aller sur une autre activité: ici consultation annonce
        Intent modifierToConsulter = new Intent(ModifierAnnonce.this, ConsulterAnnonce.class);

        //On met un paramètre qui se met dans l'extra du intent
        //De base, que les types de base de java, On peut faire passer un objet sérialisable => Cours La communication entre composants d'OpenClassRoom
        modifierToConsulter.putExtra("idAnnonce",idAnnonce);
        //On la lance(ConsulterAnnonce)
        startActivity(modifierToConsulter);
        //On ferme celle la (ModifierAnnonce)
        finish();
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
