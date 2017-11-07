package id.sch.smktelkom_mlg.learn.googlemaps_showhockeyapp;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    static final CameraPosition JTG = CameraPosition.builder()
            .target(new LatLng(-7.696598, 112.643703))
            .zoom(15)
            .bearing(0)
            .tilt(45)
            .build();

    GoogleMap m_map;
    boolean mapReady = false;
    MarkerOptions house;
    MarkerOptions quba;
    MarkerOptions pasar;
    MarkerOptions kec;
    MarkerOptions koramil;
    MarkerOptions smp;

    @Override
    public Resources getResources() {
        return super.getResources();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        house = new MarkerOptions()
                .position(new LatLng(-6.886892, 111.654675))
                .title("First Place")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_location_on_black_24dp));

        quba = new MarkerOptions()
                .position(new LatLng(-7.677471, 112.632378))
                .title("Masjid Lumbang Rejo")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_location_on_black_24dp));

        pasar = new MarkerOptions()
                .position(new LatLng(-7.681503, 112.641159))
                .title("Pasar Prigen")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_location_on_black_24dp));

        kec = new MarkerOptions()
                .position(new LatLng(-7.756905, 112.664645))
                .title("Taman Safari Prigen")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_location_on_black_24dp));

        koramil = new MarkerOptions()
                .position(new LatLng(-7.677995, 112.634329))
                .title("MTs Negeri 3 Pasuruan")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_location_on_black_24dp));

        smp = new MarkerOptions()
                .position(new LatLng(-7.700071, 112.624484))
                .title("Air Terjun Kakek Bodo")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_location_on_black_24dp));

        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }

    @Override
    public void onMapReady(GoogleMap map) {
        Toast toast = Toast.makeText(getApplicationContext(), "Map is Ready!", Toast.LENGTH_SHORT);
        toast.show();
        mapReady = true;
        m_map = map;
        m_map.addMarker(house);
        m_map.addMarker(quba);
        m_map.addMarker(pasar);
        m_map.addMarker(kec);
        m_map.addMarker(koramil);
        m_map.addMarker(smp);
        flyTo(JTG);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void flyTo(CameraPosition target) {
        m_map.animateCamera(CameraUpdateFactory.newCameraPosition(target), 10000, null);
    }
}
