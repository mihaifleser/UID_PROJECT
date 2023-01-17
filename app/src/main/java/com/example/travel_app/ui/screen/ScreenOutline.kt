package com.example.travel_app.ui.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Luggage
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Thermostat
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.travel_app.ui.activity.MainActivity.Companion.CURRENT_TRIP
import com.example.travel_app.ui.activity.MainActivity.Companion.WEATHER
import com.example.travel_app.ui.theme.Travel_AppTheme

@Composable
fun AppDrawer(drawerNavPaths: Map<String, () -> Unit>, openCloseDrawer: () -> Unit, appTitle: MutableState<String>) {
    Column(
        Modifier
            .fillMaxSize()
            .padding(start = 24.dp, top = 48.dp)
    ) {
        IconButton(onClick = {
        }) {
            Icon(
                Icons.Filled.AccountBox, null, modifier = Modifier
                    .height(100.dp)
                    .width(100.dp)
            )
        }
        drawerNavPaths.forEach { (key, value) ->
            Spacer(Modifier.height(20.dp))
            Text(
                text = key,
                style = MaterialTheme.typography.h4,
                modifier = Modifier
                    .clickable(onClick = {
                        value.invoke()
                        appTitle.value = key
                        openCloseDrawer.invoke()
                    })
                    .fillMaxWidth()
                    .padding(10.dp)
            )

        }
    }
}

@Composable
fun TopBar(topBarNavPaths: Map<String, () -> Unit>, openCloseDrawer: () -> Unit, appTitle: MutableState<String>) {
    TopAppBar(
        elevation = 4.dp,
        title = {
            Text(appTitle.value)
        },
        backgroundColor = MaterialTheme.colors.primarySurface,
        navigationIcon = {
            IconButton(onClick = openCloseDrawer) {
                Icon(Icons.Filled.Menu, null)
            }
        }, actions = {
            IconButton(onClick = {
                topBarNavPaths[WEATHER]?.invoke()
                appTitle.value = WEATHER
            }) {
                Icon(Icons.Filled.Thermostat, null)
            }
            IconButton(onClick = {
                topBarNavPaths[CURRENT_TRIP]?.invoke()
                appTitle.value = CURRENT_TRIP
            }) {
                Icon(Icons.Filled.Luggage, null)
            }
        })
}

@Preview
@Composable
fun AppDrawerPreview() {
    Travel_AppTheme {
        AppDrawer(emptyMap(), {}, remember { mutableStateOf("Travel App") })
    }
}