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
import android.os.Bundle
import androidx.compose.ui.viewinterop.AndroidView
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.OnMapReadyCallback

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(viewModel: ModelView) {
    val searchQuery by viewModel.searchQuery.collectAsState()
    var mapView: MapView? by remember { mutableStateOf(null) }

    Scaffold(
        topBar = {
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
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(horizontal = 18.dp, vertical = 6.dp)
            ) {
                TextField(
                    value = searchQuery,
                    onValueChange = { viewModel.actualizarBusqueda(it) },
                    label = { Text("Introduce una ubicaci��n") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp),
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color.LightGray,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        focusedLabelColor = Color.DarkGray,
                        unfocusedLabelColor = Color.DarkGray
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
                AndroidView(
                    factory = { context ->
                        MapView(context).apply {
                            mapView = this
                            onCreate(Bundle())
                            getMapAsync(OnMapReadyCallback { googleMap ->

                            })
                        }
                    },
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(1f)
                )
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