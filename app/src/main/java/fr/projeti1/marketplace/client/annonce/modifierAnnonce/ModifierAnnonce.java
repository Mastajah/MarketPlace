package fr.projeti1.marketplace.client.annonce.modifierAnnonce;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import fr.projeti1.marketplace.R;
import fr.projeti1.marketplace.client.MVPPattern.Activity;
import fr.projeti1.marketplace.interfaceS.DTO.AnnonceDTO;
import fr.projeti1.marketplace.interfaceS.DTO.ClientDTO;

/**
 * Vue de la modification d'annonce
 */
public class ModifierAnnonce extends Activity{

    protected ModifierAnnoncePresenter mPresenter;

    /**
     * Elements IHM que l'on va custom
     */
    private TextView titreView;
    private EditText textfieldNomClient;
    private EditText textfieldPrenomClient;
    private EditText textfieldNumTel;
    private EditText textfieldTitreAnnonce;
    private EditText textfieldDescrption;
    private EditText textfieldAdresse;
    private EditText textfieldVille;
    private EditText textfieldCodepostal;
    private Button buttonValider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.creer_modifier_annonce);

        mPresenter = new ModifierAnnoncePresenter(this);
    }

    /**
     * Initialisation de la vue
     */
    @Override
    public void initView() {
        super.initView();
        titreView = findViewById(R.id.libelleTitre);
        titreView.setText("Modifier une annonce");
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
                mPresenter.doModifier();
            }
        });
    }

    public void bind(){
        //On récupère les données de notre Model
        AnnonceDTO annonceDTO = mPresenter.getModel().getAnnonceDTO();
        ClientDTO clientDTO = annonceDTO.getClientDTO();

        //On set les éléments IHM
        textfieldNomClient.setText(clientDTO.getNomClient());
        textfieldPrenomClient.setText(clientDTO.getPrenomClient());
        textfieldNumTel.setText(String.valueOf(clientDTO.getNumeroTelephone()));
        textfieldTitreAnnonce.setText(annonceDTO.getTitre());
        textfieldDescrption.setText(annonceDTO.getDescription());
        textfieldAdresse.setText(clientDTO.getAdresse());
        textfieldVille.setText(clientDTO.getVille());
        textfieldCodepostal.setText(String.valueOf(clientDTO.getCodePostal()));
    }

    public void flush(){
        //On instancie les DTO
        AnnonceDTO annonceDTO = new AnnonceDTO();
        ClientDTO clientDTO = new ClientDTO();

        //On récupère les informations de la vue en remplissant les DTO
        clientDTO.setNomClient(textfieldNomClient.getText().toString());
        clientDTO.setPrenomClient(textfieldPrenomClient.getText().toString());
        clientDTO.setNumeroTelephone(Long.parseLong(textfieldNumTel.getText().toString()));
        clientDTO.setAdresse(textfieldAdresse.getText().toString());
        clientDTO.setVille(textfieldVille.getText().toString());
        clientDTO.setCodePostal(Long.parseLong(textfieldCodepostal.getText().toString()));
        annonceDTO.setTitre(textfieldTitreAnnonce.getText().toString());
        annonceDTO.setDescription(textfieldDescrption.getText().toString());
        annonceDTO.setClientDTO(clientDTO);

        //On alimente le model
        mPresenter.getModel().setAnnonceDTO(annonceDTO);

    }
}
