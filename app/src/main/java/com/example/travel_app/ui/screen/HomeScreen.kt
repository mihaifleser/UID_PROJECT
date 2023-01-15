package com.example.travel_app.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun HomeScreen() {
    Column {
        Text("Home Screen")
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {    // Must be called with no arguments in order to show a preview on the right.
    HomeScreen()
}