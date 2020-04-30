package fr.epsi.b3.TPAndroid;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class TPAndroidActivity extends AppCompatActivity {
    protected TPAndroid TPAndroid;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TPAndroid = (TPAndroid) getApplication();
    }

    protected void setTitle(String title){
        TextView textViewTitle = findViewById(R.id.titre);
        if(textViewTitle != null){
            textViewTitle.setText(title);
        }
    }

    protected void displayToast(String msg){
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }
}
