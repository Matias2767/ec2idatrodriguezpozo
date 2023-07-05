package com.example.ec2idatrodriguezpozo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ec2idatrodriguezpozo.databinding.ActivityMapBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapActivity : AppCompatActivity(), OnMapReadyCallback{
    private lateinit var binding: ActivityMapBinding
    private lateinit var googleMap: GoogleMap
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMapBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val fragmentMap = supportFragmentManager.findFragmentById(R.id.fcv_map) as SupportMapFragment
        fragmentMap.getMapAsync(this)
    }

    override fun onMapReady(map: GoogleMap) {
        googleMap = map
        val idatCentroLocation = LatLng(-12.06710294978191, -77.03574911701848)
        googleMap.addMarker(MarkerOptions().position(idatCentroLocation).title("Idat Centro"))


        val museoLarcoLocation = LatLng(-12.072230332417668, -77.07063451201216)
        googleMap.addMarker(MarkerOptions().position(museoLarcoLocation).title("Museo Larco"))

        val museoArqueologiaLocation = LatLng(-12.07722238448158, -77.06215225408054)
        googleMap.addMarker(MarkerOptions().position(museoArqueologiaLocation).title("Museo Nacional de Arqueología, Antropología e Historia del Perú"))

        val limaLocation = LatLng(-12.026254,-77.1529317)
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(limaLocation, 11f))
    }
}