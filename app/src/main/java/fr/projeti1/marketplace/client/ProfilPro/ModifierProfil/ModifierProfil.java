package fr.projeti1.marketplace.client.ProfilPro.ModifierProfil;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import fr.projeti1.marketplace.client.MVPPattern.Activity;
import fr.projeti1.marketplace.R;
import fr.projeti1.marketplace.interfaceS.DTO.ProfilProDTO;


public class ModifierProfil extends Activity {

    protected ModifierProfilPresenter modifyProfilPresenter;

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
        setContentView(R.layout.modifier_profil_pro);

        modifyProfilPresenter = new ModifierProfilPresenter(this);
    }

    @Override
    public void initView() {
        super.initView();
        nomPro = findViewById(R.id.modifier_nom);
        prenomPro = findViewById(R.id.modifier_prenom);
        nomSociete = findViewById(R.id.modifier_nom_societe);
        numSiret= findViewById(R.id.modifier_siret);
        numDecennale = findViewById(R.id.modifier_decennale);
        competences = findViewById(R.id.modifier_spinner_competence);
        numTel = findViewById(R.id.modifier_telephone);
        mail = findViewById(R.id.modifier_mail);
        adresse = findViewById(R.id.modifier_adresse);
        ville = findViewById(R.id.modifier_ville);
        codePostal = findViewById(R.id.modifier_code_postal);
        validerProfilPro = findViewById(R.id.valider_modifier_profil_pro);
        validerProfilPro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                modifyProfilPresenter.onClick(v);
            }
        });
    }

    public void bind(){
        // récupération des données du modèle
        ProfilProDTO profilproDTO = modifyProfilPresenter.getModifyProfilModel().getModifyProfilProDTO();

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
        //On instancie le DTO
        ProfilProDTO profilProDTO = new ProfilProDTO();

        //On récupère les informations de la vue en remplissant le DTO
        profilProDTO.setNomPro(nomPro.getText().toString());
        profilProDTO.setPrenomPro(prenomPro.getText().toString());
        profilProDTO.setNomSociete(nomSociete.getText().toString());
        profilProDTO.setSiretSociete(Long.parseLong(numSiret.getText().toString()));
        profilProDTO.setNumDecennale(numDecennale.getText().toString());
        profilProDTO.setCompetence(competences.getSelectedItem().toString());
        profilProDTO.setNumeroTelephone(Long.parseLong(numTel.getText().toString()));
        profilProDTO.setMail(mail.getText().toString());
        profilProDTO.setAdresse(adresse.getText().toString());
        profilProDTO.setVille(ville.getText().toString());
        profilProDTO.setCodePostal(Long.parseLong(codePostal.getText().toString()));

        // finir avec l'envoi du DTO au modèle
    }
}
