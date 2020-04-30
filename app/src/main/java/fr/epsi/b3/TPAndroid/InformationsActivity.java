package fr.epsi.b3.TPAndroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import fr.epsi.b3.TPAndroid.model.Personne;

public class InformationsActivity extends TPAndroidActivity {

    public static void display(TPAndroidActivity activity) {
        Intent intent = new Intent(activity, InformationsActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infos);
        setTitle("Informations");
        ImageView imageTuning = findViewById(R.id.imageTuning);
        imageTuning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Personne personne = new Personne(
                        "Da Silva",
                        "Julian",
                        "julian.dasilva1@epsi.fr"
                );
                DetailsActivity.display(InformationsActivity.this, personne);
            }
        });
        ImageView imagen64 = findViewById(R.id.imageN64);
        imagen64.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Personne personne = new Personne(
                        "Jean",
                        "PasDePrénom",
                        "jaipasdeprenom@epsi.fr");
                DetailsActivity.display(InformationsActivity.this, personne);
            }
        });
    }
}
