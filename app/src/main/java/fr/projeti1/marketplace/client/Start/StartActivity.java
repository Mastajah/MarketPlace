package fr.projeti1.marketplace.client.Start;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import fr.projeti1.marketplace.client.MVPPattern.Activity;
import fr.projeti1.marketplace.R;
import fr.projeti1.marketplace.client.Map.MapsActivity;
import fr.projeti1.marketplace.client.annonce.consulterAnnonce.ConsulterAnnonce;
import fr.projeti1.marketplace.client.annonce.modifierAnnonce.ModifierAnnonce;

public class StartActivity extends AppCompatActivity {

    private ImageView play;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_activity);

        this.play = (ImageView) findViewById(R.id.play);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent connection = new Intent(getApplicationContext(), MapsActivity.class);
                startActivity(connection);
                finish();
            }
        });
    }
}
