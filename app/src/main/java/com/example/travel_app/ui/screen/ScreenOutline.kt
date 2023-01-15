package com.example.travel_app.ui.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.travel_app.ui.theme.Travel_AppTheme


private val screens = listOf(
    "Home",
    "Fragment 1",
    "Fragment 2",
    "Fragment 3",
    "Fragment 4"
)

@Composable
fun AppDrawer(navClicks: List<() -> Unit>, openCloseDrawer: () -> Unit) {
    Column(
        Modifier
            .fillMaxSize()
            .padding(start = 24.dp, top = 48.dp)
    ) {

        screens.forEachIndexed { index, screen ->
            Spacer(Modifier.height(20.dp))
            Text(
                text = screen,
                style = MaterialTheme.typography.h4,
                modifier = Modifier
                    .clickable(onClick = {
                        navClicks[index].invoke()
                        openCloseDrawer.invoke()
                    })
                    .fillMaxWidth()
                    .padding(10.dp)
            )

        }
    }
}

@Composable
fun TopBar(openCloseDrawer: () -> Unit) {
    TopAppBar(
        elevation = 4.dp,
        title = {
            Text("TravelApp")
        },
        backgroundColor = MaterialTheme.colors.primarySurface,
        navigationIcon = {
            IconButton(onClick = openCloseDrawer) {
                Icon(Icons.Filled.Menu, null)
            }
        }, actions = {
            IconButton(onClick = {/* Do Something*/ }) {
                Icon(Icons.Filled.Share, null)
            }
            IconButton(onClick = {/* Do Something*/ }) {
                Icon(Icons.Filled.Settings, null)
            }
        })
}

@Preview
@Composable
fun AppDrawerPreview() {
    Travel_AppTheme {
        AppDrawer(emptyList()) {}
    }
}