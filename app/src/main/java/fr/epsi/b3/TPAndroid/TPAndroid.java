package fr.epsi.b3.TPAndroid;

import android.app.Application;

public class TPAndroid extends Application {

    private String title;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
