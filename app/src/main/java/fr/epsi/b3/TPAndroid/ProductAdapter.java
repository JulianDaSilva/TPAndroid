package fr.epsi.b3.TPAndroid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

import fr.epsi.b3.TPAndroid.model.Produit;

public class ProductAdapter extends ArrayAdapter<Produit> {

    public ProductAdapter(@NonNull Context context, int resource, @NonNull List<Produit> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater layoutInflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = layoutInflater.inflate(R.layout.ProductLayout, null);

        TextView textViewProductName = convertView.findViewById(R.id.textViewProductName);
        TextView textViewProductDescr = convertView.findViewById(R.id.textViewProductDescr);

        Produit produit = getItem(position);

        textViewProductName.setText(produit.getName());
        textViewProductDescr.setText(produit.getDescription());
        return convertView;
    }
}
