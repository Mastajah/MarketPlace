package fr.projeti1.marketplace.client.Start;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.Date;

import fr.projeti1.marketplace.R;
import fr.projeti1.marketplace.client.Start.menu.MenuTmpActivity;
import fr.projeti1.marketplace.interfaceS.DTO.ParticulierDTO;
import fr.projeti1.marketplace.interfaceS.DTO.ProfilProDTO;
import fr.projeti1.marketplace.server.database.AppDataBase;
import fr.projeti1.marketplace.server.service.ParticulierService;
import fr.projeti1.marketplace.server.service.ProfilProService;

public class StartActivity extends AppCompatActivity {

    private ImageView play;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_activity);

        // Instanciation de la BDD
        //AppDataBase.getAppDatabase(getApplicationContext());

        // Initialisation d'un compte particulier et d'un profil pro
        // initParticulierEtProfilPro();

        this.play = (ImageView) findViewById(R.id.play);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent connection = new Intent(getApplicationContext(), MenuTmpActivity.class);
                startActivity(connection);
                finish();
            }
        });
    }

    private void initParticulierEtProfilPro() {

        // Compte particulier
        ParticulierDTO particulierDTO = new ParticulierDTO();
        particulierDTO.setNumeroClient(12l);
        particulierDTO.setNomClient("DELPRATRA");
        particulierDTO.setPrenomClient("Jack");
        particulierDTO.setDateNaissance(new Date(13439061));
        particulierDTO.setNumeroTelephone(33648842536l);
        particulierDTO.setMail("jack.delpratra@gmali.com");
        particulierDTO.setMotDePasse("1234");
        particulierDTO.setAdresse("84 rue des gambettes");
        particulierDTO.setVille("Toulouse");
        particulierDTO.setCodePostal(31000l);

        // Déclaration de l'intent
        Intent intentParticulierService = new Intent(getApplicationContext(), ParticulierService.class);

        // Mets les données dans les extras de l'intent
        // Sachant que le 1er extra, on va mettre le nom de la fonction
        // Plus les données que tu veux transferer coté Serveur
        intentParticulierService.putExtra("nomFonction","creerParticulier");
        intentParticulierService.putExtra("particulierDTO",particulierDTO);

        // startService(nom de ton intent)
        startService(intentParticulierService);
        // Appel asynchrone, ici l'instance tourne toujours, on attends le renvoi des données du serveur

        //Déclaration du listener (receiver)
        CreerParticulierReceiver creerParticulierReceiver = new CreerParticulierReceiver();
        registerReceiver(creerParticulierReceiver, null);

        //Profil professionnel
        ProfilProDTO profilProDTO = new ProfilProDTO();
        profilProDTO.setNumeroPro(555l);
        profilProDTO.setNomPro("DELACASSE");
        profilProDTO.setPrenomPro("Henry");
        profilProDTO.setNomSociete("DELACASSE COMPANY");
        profilProDTO.setSiretSociete(81412145800015l);
        profilProDTO.setNumDecennale("2556788");
        profilProDTO.setNumeroTelephone(33561829999l);
        profilProDTO.setMail("henry.delacasse@yahou.fr");
        profilProDTO.setMotDePasse("4321");
        profilProDTO.setAdresse("48 rue des orangers");
        profilProDTO.setVille("Toulouse");
        profilProDTO.setCodePostal(31000l);

        // Déclaration de l'intent
        Intent intentProfilProService = new Intent(getApplicationContext(), ProfilProService.class);

        // Mets les données dans les extras de l'intent
        // Sachant que le 1er extra, on va mettre le nom de la fonction
        // Plus les données que tu veux transferer coté Serveur
        intentProfilProService.putExtra("nomFonction","creerProfilPro");
        intentProfilProService.putExtra("profilProDTO",profilProDTO);

        // startService(nom de ton intent)
        startService(intentProfilProService);
        // Appel asynchrone, ici l'instance tourne toujours, on attends le renvoi des données du serveur

        //Déclaration du listener (receiver)
        CreerProfilProReceiver  creerProfilProReceiver = new CreerProfilProReceiver();
        registerReceiver(creerProfilProReceiver, null);
    }

    public class CreerParticulierReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            // On fait rien
        }
    }

    public class CreerProfilProReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            //On fait rien
        }
    }
}
