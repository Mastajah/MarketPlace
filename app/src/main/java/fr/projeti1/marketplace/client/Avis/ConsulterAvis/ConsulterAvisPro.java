package fr.projeti1.marketplace.client.Avis.ConsulterAvis;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import fr.projeti1.marketplace.R;
import fr.projeti1.marketplace.client.MVPPattern.Activity;
import fr.projeti1.marketplace.interfaceS.DTO.AvisDTO;

public class ConsulterAvisPro extends Activity<ConsulterAvisPresenterCallBack> implements ConsulterAvisDisplay{

    protected TextView numAvis;
    protected TextView nomPro;
    protected TextView nomSociete;
    protected TextView nomClient;
    protected TextView prenomClient;
    protected TextView numAnnonce;
    protected TextView resumeIntervention;
    protected TextView descriptionAvis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.consulter_avis_vue_pro);
        //on récupère l'intent pour récupérer les données qu'on s'est fait passé
        Intent intent = getIntent();
        presenter = new ConsulterAvisPresenter(this,intent.getLongExtra("idAnnonce",0l));
        bind();
    }

    @Override
    public void initView() {
        super.initView();
        numAvis = findViewById(R.id.consulter_avis_pro_num);
        nomPro = findViewById(R.id.consulter_avis_pro_nom_pro);
        nomSociete = findViewById(R.id.consulter_avis_pro_nom_societe);
        nomClient = findViewById(R.id.consulter_avis_pro_nom_client);
        prenomClient = findViewById(R.id.consulter_avis_pro_prenom_client);
        numAnnonce = findViewById(R.id.consulter_avis_pro_num_annonce);
        resumeIntervention = findViewById(R.id.consulter_avis_pro_resume);
        descriptionAvis = findViewById(R.id.consulter_avis_pro_description);
    }

    @Override
    public void bind(){
        // on récupère les données du Model
        AvisDTO avisDTO = this.presenter.getModel().getConsultAvisDTO();

        // on set les éléments IHM
        numAvis.setText("Avis N° "+String.valueOf(avisDTO.getNumAvis()));
        nomPro.setText(avisDTO.getNomPro());
        nomSociete.setText(avisDTO.getNomSociete());
        nomClient.setText(avisDTO.getNomClient());
        prenomClient.setText(avisDTO.getPrenomClient());
        numAnnonce.setText(String.valueOf(avisDTO.getNumAnnonce()));
        resumeIntervention.setText(avisDTO.getResumeIntervention());
        descriptionAvis.setText(avisDTO.getDescriptionAvis());
    }

    @Override
    public void flush(){
        //Pas appellé ici
    }

}
