package fr.projeti1.marketplace.client.Start;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import fr.projeti1.marketplace.R;
import fr.projeti1.marketplace.client.Map.MapsActivity;
import fr.projeti1.marketplace.client.ProfilPro.ConsulterProfil.ConsulterProfil;
import fr.projeti1.marketplace.client.ProfilPro.CreerProfil.CreerProfil;
import fr.projeti1.marketplace.client.ProfilPro.ModifierProfil.ModifierProfil;
import fr.projeti1.marketplace.client.annonce.consulterAnnonce.ConsulterAnnonce;
import fr.projeti1.marketplace.client.annonce.creerAnnonce.CreerAnnonce;
import fr.projeti1.marketplace.client.annonce.modifierAnnonce.ModifierAnnonce;

public class MenuTmpActivity extends AppCompatActivity {

    private Button buttonConsulterAnnonce;
    private Button buttonCreerAnnonce;
    private Button buttonModifierAnnonce;
    private Button buttonMap;
    private Button buttonConsulterProfil;
    private Button buttonModifierProfil;
    private Button buttonCreerProfil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_tmp);

        initMenu();
    }

    private void initMenu(){

        buttonConsulterAnnonce = findViewById(R.id.button3);
        buttonCreerAnnonce = findViewById(R.id.button4);
        buttonModifierAnnonce = findViewById(R.id.button2);
        buttonMap = findViewById(R.id.button5);
        buttonConsulterProfil = findViewById(R.id.button6);
        buttonModifierProfil = findViewById(R.id.button8);
        buttonCreerProfil = findViewById(R.id.button7);

        buttonConsulterAnnonce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent connection = new Intent(getApplicationContext(), ConsulterAnnonce.class);
                connection.putExtra("nomClient","Patrick");
                startActivity(connection);
                finish();
            }
        });
        buttonCreerAnnonce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent connection = new Intent(MenuTmpActivity.this, CreerAnnonce.class);
                startActivity(connection);
                finish();
            }
        });
        buttonModifierAnnonce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent connection = new Intent(MenuTmpActivity.this, ModifierAnnonce.class);
                startActivity(connection);
                finish();
            }
        });
        buttonMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent connection = new Intent(MenuTmpActivity.this, MapsActivity.class);
                startActivity(connection);
                finish();
            }
        });
        buttonConsulterProfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent connection = new Intent(MenuTmpActivity.this, ConsulterProfil.class);
                startActivity(connection);
                finish();
            }
        });
        buttonModifierProfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent connection = new Intent(MenuTmpActivity.this, ModifierProfil.class);
                startActivity(connection);
                finish();
            }
        });
        buttonCreerProfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent connection = new Intent(MenuTmpActivity.this, CreerProfil.class);
                startActivity(connection);
                finish();
            }
        });
    }
}
