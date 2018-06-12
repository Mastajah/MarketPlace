package fr.projeti1.marketplace.client.ProfilPro.rechercherProfil;

import android.os.Bundle;
import fr.projeti1.marketplace.R;
import fr.projeti1.marketplace.client.MVPPattern.Activity;

public class RechercherProfilPro extends Activity<RechercherProfilProPresenterCallback> implements RechercherProfilProDisplay {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rechercher_profil_pro);
    }
    /**
     * Initialisation de la vue
     */
    @Override
    public void initView() {
        super.initView();
    }

    @Override
    public void bind(){
    }

    @Override
    public void flush(){
    }
}
