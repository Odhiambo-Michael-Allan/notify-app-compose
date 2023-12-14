package com.odesa.notify_app_compose

import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.odesa.notify_app_compose.ui.components.NotesScreen
import com.odesa.notify_app_compose.ui.theme.NotifyappcomposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NotifyappcomposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NotesScreen()
                }
            }
        }
    }
}

const val GRID_VIEW = Activity.RESULT_FIRST_USER + 1
const val LIST_VIEW = Activity.RESULT_FIRST_USER + 2
const val SIMPLE_LIST_VIEW = Activity.RESULT_FIRST_USER + 3
