package fr.epsi.b3.TPAndroid;

import android.os.AsyncTask;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class    HttpService extends AsyncTask<Void, Void, Object> {


    interface HttpServiceListener{
        void apiDone(String result);
        void apiError(Exception e);
    }

    private HttpServiceListener httpServiceListener;
    private String urlApi;

    public HttpService(String urlApi, HttpServiceListener httpServiceListener) {
        this.httpServiceListener = httpServiceListener;
        this.urlApi = urlApi;
    }

    @Override
    protected Object doInBackground(Void... voids) {
        return call(urlApi);
    }

    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);
        if(o instanceof Exception){
            httpServiceListener.apiError((Exception)o);
        }
        else
            httpServiceListener.apiDone(o.toString());
    }

    public Object call(String urlStr) {
        try {
            URL url;
            url = new URL(urlStr);
            HttpURLConnection urlConnection;
            if(urlStr.startsWith("https:")){
                urlConnection = (HttpsURLConnection) url.openConnection();
            }
            else{
                urlConnection = (HttpURLConnection) url.openConnection();
            }
            try {
                InputStream in = new BufferedInputStream(urlConnection.getInputStream());
                return convertToString(in);
            } finally {
                urlConnection.disconnect();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return e;
        }
    }

    private String convertToString(InputStream is){
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));

            StringBuilder stringBuilder = new StringBuilder();
            String line;

            String NL = System.getProperty("line.separator");
            while ((line = bufferedReader.readLine()) != null)
            {
                stringBuilder.append(line).append(NL);
            }
            bufferedReader.close();
            return stringBuilder.toString();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
