package fr.projeti1.marketplace.client.ProfilPro.ConsulterProfil;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import fr.projeti1.marketplace.client.MVPPattern.Activity;
import fr.projeti1.marketplace.R;
import fr.projeti1.marketplace.client.Start.menu.MenuTmpActivity;
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
    private Button menuTmp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.consulter_profil_prof);

        //Ici on récupère l'id du Profil en le récupérant dans l'intent

        consultProfilPresenter = new ConsulterProfilPresenter(this);
        bind();
    }

    @Override
    public void initView() {
        super.initView();
        nomPro = findViewById(R.id.consulter_nom1);
        prenomPro = findViewById(R.id.consulter_prenom1);
        nomSociete = findViewById(R.id.consulter_nom_societe1);
        numSiret= findViewById(R.id.consulter_siret1);
        numDecennale = findViewById(R.id.consulter_decennale1);
        competences = findViewById(R.id.consulter_competence1);
        numTel = findViewById(R.id.consulter_telephone1);
        mail = findViewById(R.id.consulter_mail1);
        adresse = findViewById(R.id.consulter_adresse1);
        ville = findViewById(R.id.consulter_ville1);
        codePostal = findViewById(R.id.consulter_code_postal1);
        supprimerProfilPro = findViewById(R.id.supprimer_profil_pro1);
        supprimerProfilPro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                consultProfilPresenter.supprimerProfilPro();
            }
        });
        menuTmp = findViewById(R.id.retour);
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
        // récupération des données du modèle
        ProfilProDTO profilproDTO = consultProfilPresenter.getConsultProfilModel().getConsultProfilProDTO();

        //insertion des données dans la vue
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
