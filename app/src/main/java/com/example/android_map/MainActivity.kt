package com.example.android_map

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import com.example.android_map.ui.theme.Android_mapTheme
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment

class MainActivity : AppCompatActivity(), OnMapReadyCallback {
    private val viewModel: ModelView by viewModels<ModelView>() // Instancia de ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            Android_mapTheme {
                MainScreen(viewModel)
            }
        }

        val mapFragment = supportFragmentManager.findFragmentById(R.id.map_fragment) as? SupportMapFragment
        mapFragment?.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        // Indicar el tipo del mapa
        googleMap.mapType = GoogleMap.MAP_TYPE_NORMAL

        // Activar los controles de zoom
        googleMap.uiSettings.isZoomControlsEnabled = true

        // Pasar el GoogleMap al ViewModel
        viewModel.setGoogleMap(googleMap)
    }
}