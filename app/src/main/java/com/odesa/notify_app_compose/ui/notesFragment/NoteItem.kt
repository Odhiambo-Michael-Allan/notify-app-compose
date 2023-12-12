package com.odesa.notify_app_compose.ui.notesFragment

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.odesa.notify_app_compose.R
import com.odesa.notify_app_compose.ui.theme.NotifyappcomposeTheme

@Composable
fun NoteItem(
    title: String,
    description: String,
    modifier: Modifier = Modifier
) {
    OutlinedCard(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        border = BorderStroke( 1.dp, Color( R.color.cardOutlineColor ) ),
    ) {
        Column(
            modifier = modifier
                .padding( 8.dp ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleLarge,
                fontFamily = FontFamily.Monospace,
                modifier = modifier
                    .padding( top = 8.dp, bottom = 8.dp )
            )
            Text(
                text = description,
                fontFamily = FontFamily.Monospace,
                modifier = modifier
                    .padding( top = 8.dp, bottom = 8.dp ) )
        }
    }
}

@Preview( showBackground = true )
@Composable
fun NoteItemPreview() {
    NotifyappcomposeTheme {
        NoteItem(
            title = "Refactor WaterCounter composable by splitting it " +
                    "into two parts: stateful and stateless Counter.",
            description = "The role of the StatelessCounter is to display the count " +
                    "and call a function when you increment the count. To do this," +
                    " follow the pattern described above and pass the state, count" +
                    " (as a parameter to the composable function), and a lambda" +
                    " (onIncrement), that is called when the state needs to be incremented" )
    }
}