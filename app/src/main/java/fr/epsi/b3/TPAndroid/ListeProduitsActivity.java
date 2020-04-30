package fr.epsi.b3.TPAndroid;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.Normalizer;
import java.util.ArrayList;

import fr.epsi.b3.TPAndroid.model.Produit;
import fr.epsi.b3.TPAndroid.model.Rayon;


public class ListeProduitsActivity extends TPAndroidActivity {

    private Rayon rayon;
    private String urlApi;
    private ArrayAdapter<Produit> arrayAdapter;
    private ArrayList<Produit> produits;

    public static void display(TPAndroidActivity activity, Rayon rayon){
        Intent intent = new Intent(activity, ListeProduitsActivity.class);
        intent.putExtra("rayon", rayon);
        activity.startActivity(intent);
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layoutlisteproduits);
        getRayonExtra();
        produits = new ArrayList<>();

        ListView listViewProducts = findViewById(R.id.listeProduits);
        arrayAdapter = new ProductAdapter(this, R.layout.ProductLayout, produits);
        listViewProducts.setAdapter(arrayAdapter);

        new HttpService(urlApi, new HttpService.HttpServiceListener() {
            @Override
            public void apiDone(String result) {
                initListeProducts(result);
            }

            @Override
            public void apiError(Exception e) {
                displayToast(e.getMessage());
            }
        }).execute();

    }

    private void getRayonExtra(){
        if(getIntent().getExtras() != null){
            rayon = (Rayon) getIntent().getExtras().get("rayon");
            if (rayon != null) {
                String nameRayon = rayon.getTitle();
                setTitle(nameRayon);
                nameRayon = Normalizer.normalize(nameRayon, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "").toLowerCase();
                urlApi="http://djemam.com/epsi/"+nameRayon+".json";
            }
        }else{
            setTitle("Rayon");
            displayToast("Pas de rayon disponible");
        }
    }

    private void initListeProducts(String data){
        try {
            JSONObject jsonObject = new JSONObject(data);
            JSONArray jsonArray = jsonObject.getJSONArray("items");
            for(int i = 0; i<jsonArray.length(); i++){
                Produit produit = new Produit(jsonArray.getJSONObject(i));
                produits.add(produit);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        arrayAdapter.notifyDataSetChanged();
    }
}
