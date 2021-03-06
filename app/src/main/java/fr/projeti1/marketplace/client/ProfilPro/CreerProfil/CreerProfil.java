package fr.projeti1.marketplace.client.ProfilPro.CreerProfil;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import fr.projeti1.marketplace.client.MVPPattern.Activity;
import fr.projeti1.marketplace.R;
import fr.projeti1.marketplace.interfaceS.DTO.ProfilProDTO;

public class CreerProfil extends Activity<CreerProfilPresenterCallBack> implements CreerProfilDisplay{

    private TextView numDepanneur;
    private EditText nomPro;
    private EditText prenomPro;
    private EditText nomSociete;
    private EditText numSiret;
    private EditText numDecennale;
    private EditText numTel;
    private EditText mail;
    private Spinner competences;//changer pour correspondre au fragment
    private EditText adresse;
    private EditText ville;
    private EditText codePostal;
    private Button validerProfilPro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.creer_profil_prof);

        presenter = new CreerProfilPresenter(this);
    }

    @Override
    public void initView() {
        super.initView();
        numDepanneur = findViewById(R.id.creer_num_depanneur);
        nomPro = findViewById(R.id.creer_nom);
        prenomPro = findViewById(R.id.creer_prenom);
        nomSociete = findViewById(R.id.creer_nom_societe);
        numSiret= findViewById(R.id.creer_siret);
        numDecennale = findViewById(R.id.creer_decennale);
        competences = findViewById(R.id.creer_spinner_competence);
        numTel = findViewById(R.id.creer_telephone);
        mail = findViewById(R.id.creer_mail);
        adresse = findViewById(R.id.creer_adresse);
        ville = findViewById(R.id.creer_ville);
        codePostal = findViewById(R.id.creer_code_postal);
        validerProfilPro = findViewById(R.id.valider_creer_profil_pro);
        validerProfilPro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onClickValider();
            }
        });
    }

    public void bind(){
        //Pas appelé ici
    }

    public void flush(){
        //On instancie le DTO
        ProfilProDTO profilProDTO = new ProfilProDTO();

        //On récupère les informations de la vue en remplissant le DTO
        profilProDTO.setNomPro(nomPro.getText().toString());
        profilProDTO.setPrenomPro(prenomPro.getText().toString());
        profilProDTO.setNomSociete(nomSociete.getText().toString());
        profilProDTO.setSiretSociete(Long.parseLong(numSiret.getText().toString()));
        profilProDTO.setNumDecennale(numDecennale.getText().toString());
        // profilProDTO.setCompetences(competences);
        profilProDTO.setNumeroTelephone(Long.parseLong(numTel.getText().toString()));
        profilProDTO.setMail(mail.getText().toString());
        profilProDTO.setAdresse(adresse.getText().toString());
        profilProDTO.setVille(ville.getText().toString());
        profilProDTO.setCodePostal(Long.parseLong(codePostal.getText().toString()));

        // on alimente le model
        presenter.getModel().setCreateProfilProDTO(profilProDTO);
    }

    @Override
    public void consult(Long idAvis){

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
