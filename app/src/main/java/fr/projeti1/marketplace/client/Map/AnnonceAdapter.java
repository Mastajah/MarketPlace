package fr.projeti1.marketplace.client.Map;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.LinkedList;
import java.util.List;

import fr.projeti1.marketplace.R;
import fr.projeti1.marketplace.interfaceS.DTO.AnnonceDTO;

public class AnnonceAdapter extends ArrayAdapter<AnnonceDTO> {
    private final Context context;
    private List<AnnonceDTO> listAnnonces;

    public AnnonceAdapter(Context context, int ressource, List<AnnonceDTO> listAnnonces){
        super(context, ressource,listAnnonces);
        this.context = context;
        this.listAnnonces = listAnnonces;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //return super.getView(position, convertView, parent);

        TextView viewTitle = (TextView) convertView.findViewById(R.id.listview_item_title);
        viewTitle.setText(listAnnonces.get(position).getTitre());
        viewTitle.setTag(listAnnonces.get(position).getTitre());
        return convertView;
    }
}
