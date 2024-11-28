package com.example.android_map

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.android_map.ui.theme.Android_mapTheme

@OptIn(ExperimentalMaterial3Api::class) // Indica que se está utilizando una API experimental
@Composable
fun MainScreen(viewModel: ModelView) {
    // Obtener el valor actual de la consulta de búsqueda desde el ViewModel
    val searchQuery by viewModel.searchQuery.collectAsState()

    Scaffold(
        topBar = {
            // Barra superior con texto
            TopAppBar(
                title = { Text("Buscador \uD83D\uDCCD") }
            )
        },
        content = { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize() // Ocupa el tamaño disponible
                    .padding(innerPadding) // Añade padding interno
                    .padding(16.dp) // Añade padding adicional
            ) {
                // Campo de texto del buscador
                TextField(
                    value = searchQuery, // Valor actual del campo de texto
                    onValueChange = { viewModel.actualizarBusqueda(it) }, // Actualiza el valor en el ViewModel
                    label = { Text("Introduce una ubicación") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(16.dp))
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(1f)
                ) {
                    // Aquí va a ir el mapa
                }
            }
        }
    )
}

// Vista previa
@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    Android_mapTheme {
        MainScreen(ModelView())
    }
}