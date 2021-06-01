package com.example.communitywatermis;

import android.os.Bundle;

import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private static final LatLng mirema = new LatLng(-1.2089417965000073, 36.883485139699744);
    private static final LatLng trm = new LatLng(-1.217344416524468, 36.885487850399734);
    private static final LatLng carrefour = new LatLng(-1.2188358774794172, 36.88834444805225);
    private static final LatLng purified = new LatLng(-1.2206062523832537, 36.88768727596186);



    private Marker mmirema;
    private Marker mtrm;
    private Marker mcarrefour;
    private Marker mpurified;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        List<Marker> markerList = new ArrayList<>();

        mmirema = mMap.addMarker(new MarkerOptions()
                .position(mirema)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE))
                .title("Jibu, Mirema Water Refill Centre"));
        mmirema.setTag(0);
        markerList.add(mmirema);

        mtrm = mMap.addMarker(new MarkerOptions()
                .position(trm)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE))
                .title("Aquaridge Water Refill Station TRM Drive"));
        mtrm.setTag(0);
        markerList.add(mtrm);



        mcarrefour = mMap.addMarker(new MarkerOptions()
                .position(carrefour)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE))
                .title("Urban Waters - TRM, Carrefour Supermarket Premises"));
        mcarrefour.setTag(0);
        markerList.add(mcarrefour);

        mpurified = mMap.addMarker(new MarkerOptions()
                .position(purified)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE))
                .title("Miles Purified Water"));
        mpurified.setTag(0);
        markerList.add(mpurified);


        for (Marker m : markerList) {
            LatLng latlng = new LatLng(m.getPosition().latitude, m.getPosition().longitude);
            mMap.addMarker(new MarkerOptions().position(latlng));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latlng,15));
            //Log.d("Marker:",m.getTitle());
        }

        // Add a marker in Sydney and move the camera
        LatLng nairobiwater = new LatLng(-1.218136484913894, 36.894809651015436);
        mMap.addMarker(new MarkerOptions().position(nairobiwater).title("Our Office, Kasarani"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(nairobiwater));

        mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker marker) {
                //if (marker != null && marker.getTitle().equals("Our Office, Kasarani")) {

                //}
                if (marker != null && marker.getTitle().equals("Jibu, Mirema Water Refill Centre")) {
                    //Intent intent2 = new Intent(MapsActivity.this, SamburuActivity.class);
                    //startActivity(intent2);
                }
                if (marker != null && marker.getTitle().equals("Aquaridge Water Refill Station TRM Drive")) {
                    //Intent intent2 = new Intent(MapsActivity.this, MountKenyaActivity.class);
                    //startActivity(intent2);
                }
                if (marker != null && marker.getTitle().equals("Urban Waters - TRM, Carrefour Supermarket Premises")) {
                    //Intent intent2 = new Intent(MapsActivity.this, FortjesusActivity.class);
                    //startActivity(intent2);
                }
                if (marker != null && marker.getTitle().equals("Ol Pejeta Conservancy")) {
                    //Intent intent2 = new Intent(MapsActivity.this, OlPejetaActivity.class);
                    //startActivity(intent2);
                }
            }

        });
    }
}
