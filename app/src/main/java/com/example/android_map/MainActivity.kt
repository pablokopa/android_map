package com.example.android_map

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import com.example.android_map.ui.theme.Android_mapTheme

class MainActivity : ComponentActivity() {
    private val viewModel: ModelView by viewModels() // Instancia de ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            Android_mapTheme {
                MainScreen(viewModel)
            }
        }
    }
}