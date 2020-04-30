package fr.epsi.b3.TPAndroid;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import fr.epsi.b3.TPAndroid.model.Personne;

public class DetailsActivity extends TPAndroidActivity {

    private String url = "";

    public static void display(TPAndroidActivity activity, Personne personne){
        Intent intent = new Intent(activity, DetailsActivity.class);
        intent.putExtra("personne", personne);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infosdetail);

        if(getIntent().getExtras() != null){
            Personne personne = (Personne) getIntent().getExtras().get("personne");
            if(personne != null){
                setTitle(personne.getFirstname()+" "+personne.getNom());
            }
        }
    }

    private void setInfos(String lastName, String firstName, String email, String linkedin, Integer avatar){
        TextView textViewLastName=findViewById(R.id.textViewLastName);
        TextView textViewFirstName=findViewById(R.id.textViewFirstName);
        TextView textViewEmail=findViewById(R.id.textViewEmail);
        TextView buttonLinkedIn=findViewById(R.id.buttonLinkedIn);
        ImageView imgViewAvatar=findViewById(R.id.avatar);
        if(textViewLastName != null){
            textViewLastName.setText(lastName);
        }
        if(textViewFirstName != null){
            textViewFirstName.setText(firstName);
        }
        if(textViewEmail != null){
            textViewEmail.setText(email);
        }
        if(buttonLinkedIn != null){
            this.url = linkedin;
        }
        if(imgViewAvatar != null){
            imgViewAvatar.setImageResource(avatar);
        }
    }

    private void goTo(String url){
        Uri uriUrl = Uri.parse(url);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }
}
