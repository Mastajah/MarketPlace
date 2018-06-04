package fr.projeti1.marketplace.ProfilPro.CreerProfil;

import android.os.Bundle;
import android.widget.TextView;
import fr.projeti1.marketplace.MVPPattern.Activity;
import fr.projeti1.marketplace.R;

public class CreerProfil extends Activity{

    private TextView libelleTitre;
    private TextView libelleNumDepanneur;
    private TextView libelleNumClient;
    private TextView libelleNomClient;
    private TextView libellePrenomClient;
    private TextView libelleNomSociete;
    private TextView libelleNumSiret;
    private TextView libelleNumDecennale;
    private TextView libelleNumTel;
    private TextView libelleMail;
    private TextView libelleCompetences;
    private TextView libelleAdresse;
    private TextView libelleVille;
    private TextView libelleCodePostal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.creer_pofil_pro);
    }

    @Override
    public void initView() {
        super.initView();
        /*libelleTitre = findViewById(R.id.libelleTitre);
        libelleNumClient = findViewById(R.id.libelleNumClient);
        libelleNomClient = findViewById(R.id.libelleNomClient);
        libellePrenomClient = findViewById(R.id.libellePrenomClient);
        libelleNumTel = findViewById(R.id.libelleNumTel);
        = findViewById(R.id.libelleTitreAnnonce);
         = findViewById(R.id.libelleDescription);
        libelleCompetences = findViewById(R.id.libelleCompetences);
        libelleAdresse = findViewById(R.id.libelleAdresse);
        libelleVille = findViewById(R.id.libelleVille);
        libelleCodePostal = findViewById(R.id.libelleCodePostal);*/
    }

}
