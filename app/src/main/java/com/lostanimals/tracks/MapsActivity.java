package com.lostanimals.tracks;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.lostanimals.tracks.utils.BundleManager;

import java.util.Objects;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {
	LatLng postLocation;
	
	void setPostLocation(LatLng postLocation) {
		this.postLocation = postLocation;
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_maps);
		SupportMapFragment mapFragment;
		mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
		
		if (mapFragment != null) {
			mapFragment.getMapAsync(this);
		}
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
		
		// Add a marker in Sydney and move the camera
		//postLocation = new LatLng(-34, 151);
		LatLng postLocation = new LatLng(Double.parseDouble(Objects.requireNonNull(BundleManager.mPostBundle.getString("lat"))), Double.parseDouble(Objects.requireNonNull(BundleManager.mPostBundle.getString("lng"))));
		googleMap.addMarker(new MarkerOptions().position(postLocation).title("Location of missing animal."));
		googleMap.moveCamera(CameraUpdateFactory.newLatLng(postLocation));
	}
}
