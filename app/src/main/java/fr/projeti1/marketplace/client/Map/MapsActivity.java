package fr.projeti1.marketplace.client.Map;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.drawable.AnimationDrawable;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;

import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import fr.projeti1.marketplace.R;
import fr.projeti1.marketplace.interfaceS.DTO.AnnonceDTO;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private static final int LOCATION_PERMISSION_REQUEST_CODE = 123;
    private static final String TAG = "MapActivity";
    private static final float DEFAULT_ZOOM = 15f; // Zoom map utilisé par défault

    //Variables:
    private FusedLocationProviderClient mFusedLocationProviderClient;
    private GoogleMap mMap;
    private boolean isLocationPermissionGranted = false;

    //Widgets
    private EditText mSearchText; //Texte saisie dans la barre de recherche

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Retrieve the content view that renders the map.
        setContentView(R.layout.activity_maps);
        getLocationPermission();
    }

    /**
     * Manipule la Map une fois disponible.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {

        Toast.makeText(this,"La Map est prête", Toast.LENGTH_SHORT).show();
        Log.d(TAG,"OnMapReady : La Map est prête");
        mMap = googleMap;
        if(isLocationPermissionGranted){
            getDeviceLocation();

            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                    != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this,
                    Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                return;
            }

            mMap.setMyLocationEnabled(true);
            mMap.getUiSettings().setMyLocationButtonEnabled(true);
            init();

        }

        /** Exemple de position de marqueur:
         // Add a marker in Sydney and move the camera
         LatLng sydney = new LatLng(-34, 151);
         mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
         mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
         */
    }



    public void initMap(){
        Log.d(TAG,"initMap : Initialisation de la Map");
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    protected void init(){
        Log.d(TAG, "init: initialisation de l'outil de recherche sur map");
        mSearchText = findViewById(R.id.input_search);
        /*
        //Création d'annonce fictive pour affichage des marqueur suite à la recherche:
        AnnonceDTO annonceDTO1 = new AnnonceDTO();
        annonceDTO1.setNumeroAnnonce(1L);
        annonceDTO1.setTitre("Compteur en rade");
        annonceDTO1.setDescription("Le compteur marche plus");
        annonceDTO1.setNumVoie(20);
        annonceDTO1.setRue("Quai de Tounis");
        annonceDTO1.setCodePostale("31000");
        annonceDTO1.setVille("Toulouse");

        AnnonceDTO annonceDTO2 = new AnnonceDTO();
        annonceDTO2.setNumeroAnnonce(2L);
        annonceDTO2.setTitre("Radiateur en rade");
        annonceDTO2.setDescription("Le Radiateur ne marche plus");
        annonceDTO2.setNumVoie(1);
        annonceDTO2.setRue("Rue de Metz");
        annonceDTO2.setCodePostale("31000");
        annonceDTO2.setVille("Toulouse");

        final List<AnnonceDTO> listAnnonce = new ArrayList<AnnonceDTO>();
        listAnnonce.add(annonceDTO1);
        listAnnonce.add(annonceDTO2);

        mSearchText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int actionId, KeyEvent keyEvent) {
                //Gere la possibilité d'appuyer sur enter ou le retour pour lancer la recherche
                if(actionId == EditorInfo.IME_ACTION_SEARCH
                        || actionId == EditorInfo.IME_ACTION_DONE
                        || keyEvent.getAction() == KeyEvent.ACTION_DOWN
                        || keyEvent.getAction() == KeyEvent.KEYCODE_ENTER){

                    //execute la methode de recherche
                    geoLocate(listAnnonce);
                }
                fermeClavierSaisie();

                return false;
            }
        });
        */

    }

    /**
     * Methode de géolocalisation d'une saisie de recherche
     * entré dans la barre de recherche mSearchText

    protected void geoLocate(List<AnnonceDTO> listAnnonce){

        //RechercherAnnonce rechercherAnnonce = new RechercherAnnonce();

        Log.d(TAG, "geoLocate: geolocalisation");
        // Recupère le String saisie dans la barre de recherche
        String searchString = mSearchText.getText().toString();

        Geocoder geocoder = new Geocoder(MapsActivity.this);

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

        Geocoder geocoder = new Geocoder(MapsActivity.this);
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
     */
    protected void getDeviceLocation(){

        Log.d(TAG,"getDeviceLocation : recupere la location de l'appareil");
        mFusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);

        try{
            Task location = mFusedLocationProviderClient.getLastLocation();
            location.addOnCompleteListener(new OnCompleteListener() {
                @Override
                public void onComplete(@NonNull Task task) {
                    if (task.isSuccessful()) {
                        Log.d(TAG, "onComplete: Localisation Trouvée");
                        Location currentLocation = (Location) task.getResult();
                        moveCamera(new LatLng(currentLocation.getLatitude(), currentLocation.getLongitude()),
                                DEFAULT_ZOOM, "Ma Position");
                    } else {
                        Log.d(TAG, "onComplete: location actuelle is vide");
                        Toast.makeText(MapsActivity.this, "Localisation introuvable", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }catch(SecurityException e){
            Log.d(TAG,"getDeviceLocation: SecurityException: "+ e.getMessage());
        }
    }

    protected void moveCamera(LatLng latLng, float zoom, String title){
        Log.d(TAG, "moveCamera: deplace l'ecran vers la latitude: "+latLng.latitude + ", longitude: "+ latLng.longitude);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, zoom));
        /*
        if(!title.equals("Ma Position")){
            //Ajoute le curseur sur le position trouvée
            MarkerOptions options = new MarkerOptions()
                    .position(latLng)
                    .title(title);
            mMap.addMarker(options);
        }
        */
        fermeClavierSaisie();

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        Log.d(TAG,"onRequestPermissionResult: methode appélée");
        isLocationPermissionGranted = false;
        switch (requestCode){
            case LOCATION_PERMISSION_REQUEST_CODE:{
                if(grantResults.length > 0) {
                    for (int i = 0; i <grantResults.length; i++){
                        if(grantResults[i] != PackageManager.PERMISSION_GRANTED) {
                            isLocationPermissionGranted = false;
                            Log.d(TAG, "onRequestPermissionResult : Permission non accordée");
                            return;
                        }
                    }
                    isLocationPermissionGranted = true;
                    Log.d(TAG,"onRequestPermissionResult: Permission accordée");
                    initMap();
                }
            }
        }
    }

    protected void getLocationPermission(){
        Log.d(TAG, "getLocationPermission : recupère les permissions");
        String[] permissions = {Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION};

        if(ContextCompat.checkSelfPermission(this.getApplicationContext(),
                permissions[0]) == PackageManager.PERMISSION_GRANTED){
            if(ContextCompat.checkSelfPermission(this.getApplicationContext(),
                    permissions[1]) == PackageManager.PERMISSION_GRANTED){
                isLocationPermissionGranted = true;
                initMap();
            }else{
                ActivityCompat.requestPermissions(this,
                        permissions,
                        LOCATION_PERMISSION_REQUEST_CODE);
            }
        }else {
            ActivityCompat.requestPermissions(this,
                    permissions,
                    LOCATION_PERMISSION_REQUEST_CODE);
        }
    }

    protected void fermeClavierSaisie(){
        //this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        Log.d(TAG, "fermeClavierSaisie: Fermeture du clavier effective");
    }

}
