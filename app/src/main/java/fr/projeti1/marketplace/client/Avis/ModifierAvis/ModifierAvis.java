package fr.projeti1.marketplace.client.Avis.ModifierAvis;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import fr.projeti1.marketplace.R;
import fr.projeti1.marketplace.client.MVPPattern.Activity;
import fr.projeti1.marketplace.interfaceS.DTO.AvisDTO;

public class ModifierAvis extends Activity<ModifierAvisPresenterCallBack> implements ModifierAvisDisplay{

    protected EditText nomPro;
    protected EditText nomSociete;
    protected EditText nomClient;
    protected EditText prenomClient;
    protected EditText numAnnonce;
    protected EditText resumeIntervention;
    protected EditText descriptionAvis;
    protected Button validerModifierAvis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.modifier_avis);
        presenter = new ModifierAvisPresenter(this);
    }

    @Override
    public void initView() {
        super.initView();
        nomPro = findViewById(R.id.modifier_avis_nom_pro);
        nomSociete = findViewById(R.id.modifier_avis_nom_societe);
        nomClient = findViewById(R.id.modifier_avis_nom_client);
        prenomClient = findViewById(R.id.modifier_avis_prenom_client);
        numAnnonce = findViewById(R.id.modifier_avis_num_annonce);
        resumeIntervention = findViewById(R.id.modifier_avis_resume);
        descriptionAvis = findViewById(R.id.modifier_avis_description);
        validerModifierAvis = findViewById(R.id.valider_modifier_avis);
        validerModifierAvis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onClickValiderModif();
            }
        });
    }

    public void bind(){
        //Pas appelé ici
    }

    public void flush(){
        //On instancie le DTO
        AvisDTO avisDTO = new AvisDTO();

        //On récupère les informations de la vue en remplissant le DTO
        avisDTO.setNomPro(nomPro.getText().toString());
        avisDTO.setNomSociete(nomSociete.getText().toString());
        avisDTO.setNomClient(nomClient.getText().toString());
        avisDTO.setPrenomClient(prenomClient.getText().toString());
        avisDTO.setNumAnnonce(Long.parseLong(numAnnonce.getText().toString()));
        avisDTO.setResumeIntervention(resumeIntervention.getText().toString());
        avisDTO.setDescriptionAvis(descriptionAvis.getText().toString());

        // on alimente le model
        presenter.getModel().setModifyAvisDTO(avisDTO);
    }


    @Override
    public void consult(Long idAvis){

    }
}
