package fr.projeti1.marketplace.client.ProfilPro.ConsulterProfil;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import fr.projeti1.marketplace.client.MVPPattern.Activity;
import fr.projeti1.marketplace.R;
import fr.projeti1.marketplace.interfaceS.DTO.ProfilProDTO;


public class ConsulterProfil extends Activity{

    protected ConsulterProfilPresenter consultProfilPresenter;

    private TextView numDepanneur;
    private TextView nomPro;
    private TextView prenomPro;
    private TextView nomSociete;
    private TextView numSiret;
    private TextView numDecennale;
    private TextView numTel;
    private TextView mail;
    private TextView competences;//changer pour correspondre au fragment
    private TextView adresse;
    private TextView ville;
    private TextView codePostal;
    private Button supprimerProfilPro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.modifier_profil_pro);

        //Ici on récupère l'id du Profil en le récupérant dans l'intent
        Long exemple = 123l;
        consultProfilPresenter = new ConsulterProfilPresenter(this,exemple);
    }

    @Override
    public void initView() {
        super.initView();
        nomPro = findViewById(R.id.consulter_nom);
        prenomPro = findViewById(R.id.consulter_prenom);
        nomSociete = findViewById(R.id.consulter_nom_societe);
        numSiret= findViewById(R.id.consulter_siret);
        numDecennale = findViewById(R.id.consulter_decennale);
        competences = findViewById(R.id.consulter_competence);
        numTel = findViewById(R.id.consulter_telephone);
        mail = findViewById(R.id.consulter_mail);
        adresse = findViewById(R.id.consulter_adresse);
        ville = findViewById(R.id.consulter_ville);
        codePostal = findViewById(R.id.consulter_code_postal);
        supprimerProfilPro = findViewById(R.id.supprimer_profil_pro);
        supprimerProfilPro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                consultProfilPresenter.supprimerProfilPro();
            }
        });
    }

    public void bind(){
        // récupération des données du modèle
        ProfilProDTO profilproDTO = consultProfilPresenter.getConsultProfilModel().getConsultProfilProDTO();

        //insertion des données dans la vue
        numDepanneur.setText(String.valueOf(profilproDTO.getNumeroPro()));
        nomPro.setText(profilproDTO.getNomPro());
        prenomPro.setText(profilproDTO.getPrenomPro());
        nomSociete.setText(profilproDTO.getNomSociete());
        numSiret.setText(String.valueOf(profilproDTO.getSiretSociete()));
        numDecennale.setText(String.valueOf(profilproDTO.getNumDecennale()));
        //competences; faire avec fragment
        numTel.setText(String.valueOf(profilproDTO.getNumeroTelephone()));
        mail.setText(profilproDTO.getMail());
        adresse.setText(profilproDTO.getAdresse());
        ville.setText(profilproDTO.getVille());
        codePostal.setText(String.valueOf(profilproDTO.getCodePostal()));
    }

    public void flush(){
        //Pas appellé ici
    }

}
