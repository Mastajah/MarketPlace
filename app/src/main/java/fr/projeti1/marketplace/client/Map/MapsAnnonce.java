package fr.projeti1.marketplace.client.Map;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import fr.projeti1.marketplace.interfaceS.DTO.AnnonceDTO;

public class MapsAnnonce extends MapsActivity {

    private static final String TAG = "MapActivity";
    private static final float DEFAULT_ZOOM = 15f; // Zoom map utilisé par défault

    private GoogleMap mMap;
    private EditText mSearchText;

    protected MapsAnnoncePresenter presenter;

    public void setPresenter(MapsAnnoncePresenter presenter) {
        this.presenter = presenter;
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void initView() {
        super.init();
        // On récupère la liste d'annonce du modèle
        final List<AnnonceDTO> listAnnonce = presenter.getModel().getAnnonceDTOs();

        mSearchText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int actionId, KeyEvent keyEvent) {
                //Gere la possibilité d'appuyer sur enter ou le retour pour lancer la recherche
                if(actionId == EditorInfo.IME_ACTION_SEARCH
                        || actionId == EditorInfo.IME_ACTION_DONE
                        || keyEvent.getAction() == KeyEvent.ACTION_DOWN
                        || keyEvent.getAction() == KeyEvent.KEYCODE_ENTER){

                    //execute la methode de recherche
                    geoLocateAnnonces(listAnnonce);
                    flush();
                }

                return false;
            }
        });
    }

    public  void bind(){
        getDeviceLocation();
    }

    public void flush() {
        fermeClavierSaisie();
    }

    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    /**
     * Methode de géolocalisation d'une saisie de recherche
     * entré dans la barre de recherche mSearchText
     */
    protected void geoLocateAnnonces(List<AnnonceDTO> listAnnonce){

        //RechercherAnnonce rechercherAnnonce = new RechercherAnnonce();

        Log.d(TAG, "geoLocate: geolocalisation");
        // Recupère le String saisie dans la barre de recherche
        String searchString = mSearchText.getText().toString();

        Geocoder geocoder = new Geocoder(MapsAnnonce.this);

        List<Address> list = new ArrayList<>();

        try{
            list = geocoder.getFromLocationName(searchString, 1);
        }catch (IOException e){
            Log.e(TAG, "geoLocate: IOException: " + e.getMessage() );
        }

        //Si la recherche resulte sur un liste avec des résultats
        if(list.size() > 0){
            Address address = list.get(0);
            for(AnnonceDTO annonceDTO : listAnnonce){
                Log.d(TAG,"Ville de l'annonce n°"+annonceDTO.getNumeroAnnonce() + " : "
                        + annonceDTO.getVille());
                // compare le code postale de l'adresse trouvée avec le code postal des annonces enregistrées
                if ((address.getLocality()).equals(annonceDTO.getVille())){
                    //place un marqueur sur toutes les annonces ayant le même
                    //code postal que le l'adresse saisie

                    Address adresseAnnonce = convertStringToAdresse(annonceDTO.adressToString());

                    if (adresseAnnonce != null){
                        MarkerOptions options = new MarkerOptions()
                                .position(new LatLng(adresseAnnonce.getLatitude(), adresseAnnonce.getLongitude()))
                                .title("Annonce n°" + annonceDTO.getNumeroAnnonce());
                        mMap.addMarker(options);
                        Log.d(TAG,"Ajout d'un marqueur à l'adresse" + address);
                    }

                }
                // on recupère l'adresse stockée dans la liste à la position 0
                Log.d(TAG,"geoLocate: l'adresse match avec celle d'une annonce");

            }

            Log.d(TAG, "geoLocate: found a location: " + address.toString());
            //Utilliser la ligne en dessous pour afficher les info de l'adresse directement sur l'appli
            //Toast.makeText(this, address.toString(), Toast.LENGTH_SHORT).show();
            moveCamera(new LatLng(address.getLatitude(),address.getLongitude()),
                    DEFAULT_ZOOM, address.getAddressLine(0));
        }

    }

    private Address convertStringToAdresse(String strAdresse){

        Geocoder geocoder = new Geocoder(MapsAnnonce.this);
        List<Address> list = new ArrayList<>();

        try {
            list = geocoder.getFromLocationName(strAdresse, 1);
        } catch (IOException e) {
            Log.e(TAG,"convertStringToAdresse: IOException: "+e.getMessage());
        }
        if(list.size()>0){
            Address address = list.get(0);
            Log.d(TAG,"convertStringToAdresse: le texte "+strAdresse
                    +"a bien été converti en Adresse " + address);
            return address;
        }
        else return null;
    }

    // Besoin du oontext dans le presenter
    public Context getContext(){
        return this.getApplicationContext();
    }

    // L'activité est ici, et seule l'activité a la main sur la fonction startService() donc aussi définie dans le display
    public void startIntentService(Intent intentService){
        startService(intentService);
    }

    // L'activité est ici, et seule l'activité a la main sur la fonction startService() donc aussi définit dans le display
    public void registerListener(BroadcastReceiver receiver){
        registerListener(receiver);
    }

}
