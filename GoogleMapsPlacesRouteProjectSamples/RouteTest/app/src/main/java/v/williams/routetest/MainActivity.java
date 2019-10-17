package v.williams.routetest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.ArrayList;
import java.util.List;

import v.williams.routetest.HelperClasses.FetchURL;
import v.williams.routetest.HelperClasses.TaskLoadedCallback;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, OnMapReadyCallback, TaskLoadedCallback {
    private GoogleMap map;
    private MarkerOptions place1, place2;
    private Button getDirection;
    private Polyline currentPolyline;

    List <MarkerOptions> markerOptionsList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getDirection = findViewById(R.id.btn);
        getDirection.setOnClickListener(this);

        place1 = new MarkerOptions().position(new LatLng(5.619861, -0.226764)).title("destination 1");
        place2 = new MarkerOptions().position(new LatLng(5.6361227,-0.203339)).title("destination 2");

        markerOptionsList.add(place1);
        markerOptionsList.add(place2);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onClick(View v) {
        new FetchURL(MainActivity.this).execute(getUrl(place1.getPosition(), place2.getPosition(), "driving"), "driving");

    }

    private String getUrl(LatLng origin, LatLng destination, String directionMode) {
        String strOrigin = "origin" + origin.latitude + " , " + origin.longitude;
        String strDest = "destination" + destination.latitude + " , " + destination.longitude;
        String mode = "mode" + directionMode;
        String parameter = strOrigin + "&" + strDest + "&" + mode;
        String format = "json";
        String url = "https://maps.googleapis.com/maps/api/directions/"
                + format + "?" + parameter + "&key=AIzaSyCmOCkXSZSQTG5QC-xntQh4Rni9xqxNOSY";

        return url;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
        map.addMarker(place1);
        map.addMarker(place2);

        showAllMarkers();
    }

    private void showAllMarkers() {
        LatLngBounds.Builder builder = new LatLngBounds.Builder();

        for (MarkerOptions options : markerOptionsList){

            builder.include(options.getPosition());
        }
        LatLngBounds bounds = builder.build();

        int width = getResources().getDisplayMetrics().widthPixels;
        int heigth = getResources().getDisplayMetrics().heightPixels;
        int padding = (int) (width * 0.30);

        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngBounds(bounds, width, heigth, padding);
        map.animateCamera(cameraUpdate);

    }

    @Override
    public void onTaskDone(Object... values) {
        if (currentPolyline != null)
            currentPolyline.remove();

        currentPolyline = map.addPolyline((PolylineOptions) values[0]);

    }
}



















