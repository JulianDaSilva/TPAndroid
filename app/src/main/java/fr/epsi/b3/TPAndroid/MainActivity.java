package fr.epsi.b3.TPAndroid;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

public class MainActivity extends TPAndroidActivity implements View.OnClickListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        super.onCreate(savedInstanceState);
        setTitle("Home");
        findViewById(R.id.buttonInfos).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonInfos:
                InformationsActivity.display(MainActivity.this);
                break;
        }
    }
}
