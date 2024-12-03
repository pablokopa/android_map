package com.example.android_map

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
                title = {
                    Text(
                        "BUSCADOR DE UBICACIÓN",
                        fontSize = 22.sp,
                        color = Color.DarkGray,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center,
                    )
                }
            )
        },
        content = { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize() // Ocupa el tamaño disponible
                    .padding(innerPadding) // Añade padding interno
                    .padding(horizontal = 18.dp, vertical = 6.dp) // Añade padding adicional
            ) {
                // Campo de texto del buscador
                TextField(
                    value = searchQuery, // Valor actual del campo de texto
                    onValueChange = { viewModel.actualizarBusqueda(it) }, // Actualiza el valor en el ViewModel
                    label = { Text("Introduce una ubicación") },
                    modifier = Modifier.fillMaxWidth(),
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color.LightGray,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        focusedLabelColor = Color.DarkGray, // Cambia el color del texto del label cuando está enfocado
                        unfocusedLabelColor = Color.DarkGray // Cambia el color del texto del label cuando no está enfocado
                    )
                )
                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = { viewModel.enviarBusqueda() },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF008000)),
                    shape = RectangleShape
                ) {
                    Text(
                        "Enviar",
                        color = Color.White,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
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