package com.odesa.notify.ui

import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.odesa.notify.ui.home.HomeViewModel
import com.odesa.notify.ui.theme.NotifyTheme
import android.graphics.Color

class MainActivity : ComponentActivity() {

    private val viewModel: HomeViewModel by viewModels()

    override fun onCreate( savedInstanceState: Bundle? ) {
        super.onCreate( savedInstanceState )
//        enableEdgeToEdge(
//            SystemBarStyle.auto( Color.TRANSPARENT, Color.TRANSPARENT )
//        )
        setContent {
            NotifyTheme {
                val uiState by viewModel.uiState.collectAsState()

                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NotifyApp()
                }
            }
        }
    }
}


const val GRID_VIEW = Activity.RESULT_FIRST_USER + 1
const val LIST_VIEW = Activity.RESULT_FIRST_USER + 2
const val SIMPLE_LIST_VIEW = Activity.RESULT_FIRST_USER + 3
