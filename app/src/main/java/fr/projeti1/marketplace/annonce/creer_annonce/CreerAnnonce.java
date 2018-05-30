package fr.projeti1.marketplace.annonce.creer_annonce;

import android.os.Bundle;
import android.widget.TextView;
import fr.projeti1.marketplace.MVPPattern.ActivityPresenter;
import fr.projeti1.marketplace.MVPPattern.Activity;
import fr.projeti1.marketplace.R;

public class CreerAnnonce extends Activity {

    private TextView libelleTitre;
    private TextView libelleNumClient;
    private TextView libelleNomClient;
    private TextView libellePrenomClient;
    private TextView libelleNumTel;
    private TextView libelleTitreAnnonce;
    private TextView libelleDescription;
    private TextView libelleCompetences;
    private TextView libelleAdresse;
    private TextView libelleVille;
    private TextView libelleCodePostal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.creer_annonce);
    }

    @Override
    public void initView() {
        super.initView();
        libelleTitre = findViewById(R.id.libelleTitre);
        libelleNumClient = findViewById(R.id.libelleNumClient);
        libelleNomClient = findViewById(R.id.libelleNomClient);
        libellePrenomClient = findViewById(R.id.libellePrenomClient);
        libelleNumTel = findViewById(R.id.libelleNumTel);
        libelleTitreAnnonce = findViewById(R.id.libelleTitreAnnonce);
        libelleDescription = findViewById(R.id.libelleDescription);
        libelleCompetences = findViewById(R.id.libelleCompetences);
        libelleAdresse = findViewById(R.id.libelleAdresse);
        libelleVille = findViewById(R.id.libelleVille);
        libelleCodePostal = findViewById(R.id.libelleCodePostal);
    }
}
