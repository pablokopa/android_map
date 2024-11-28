package com.example.android_map

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ModelView : ViewModel() {
    private val _busqueda = MutableStateFlow("") // MutableStateFlow para almacenar la consulta de búsqueda
    val searchQuery: StateFlow<String> = _busqueda // Para que la consulta de búsqueda sea observable

    // Función para actualizar la consulta de búsqueda
    fun actualizarBusqueda(newQuery: String) {
        _busqueda.value = newQuery
    }
}