package com.example.android_map

import androidx.lifecycle.ViewModel
import com.google.android.gms.maps.CameraUpdateFactory
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class ModelView : ViewModel() {
    private val _busqueda = MutableStateFlow("") // MutableStateFlow para almacenar la consulta de búsqueda
    val searchQuery: StateFlow<String> = _busqueda // Para que la consulta de búsqueda sea observable

    private var googleMap: GoogleMap? = null

    // Función para actualizar la consulta de búsqueda
    fun actualizarBusqueda(newQuery: String) {
        _busqueda.value = newQuery
    }

    // Función para enviar la consulta de búsqueda
    fun enviarBusqueda() {
        val location = obtenerUbicacionDesdeBusqueda(_busqueda.value)
        location?.let {
            googleMap?.clear()
            googleMap?.addMarker(MarkerOptions().position(it).title("Resultado de búsqueda"))
            googleMap?.moveCamera(CameraUpdateFactory.newLatLngZoom(it, 10f))
        }
    }

    // Función para establecer el GoogleMap
    fun setGoogleMap(map: GoogleMap) {
        googleMap = map
    }

    // Función para obtener una ubicación desde una búsqueda
    private fun obtenerUbicacionDesdeBusqueda(query: String): LatLng? {
        return LatLng(-34.0, 151.0) // Ejemplo de ubicación
    }
}