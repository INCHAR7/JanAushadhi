package com.mindmatrix.janaushadhifinder

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class StoreLocatorActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_store_locator)

        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        val userLocation = LatLng(12.9716, 77.5946)
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(userLocation, 13f))

        val store1 = LatLng(12.9850, 77.6050)
        val store2 = LatLng(12.9600, 77.5750)
        val store3 = LatLng(12.9420, 77.6100)

        mMap.addMarker(MarkerOptions().position(store1).title("Jan-Aushadhi Kendra - Open Now"))
        mMap.addMarker(MarkerOptions().position(store2).title("Jan-Aushadhi Kendra - Open Now"))
        mMap.addMarker(MarkerOptions().position(store3).title("Jan-Aushadhi Kendra - Open Now"))
    }
}