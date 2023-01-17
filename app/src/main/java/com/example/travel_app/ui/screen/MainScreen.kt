package com.example.travel_app.ui.screen

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidViewBinding
import com.example.travel_app.databinding.ContentMainBinding
import com.example.travel_app.ui.theme.Travel_AppTheme
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen(drawerNavPaths: Map<String, () -> Unit>, topBarNavPaths: Map<String, () -> Unit>, appTitle: MutableState<String>) {
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    val openCloseDrawer: () -> Unit = {
        scope.launch {
            scaffoldState.drawerState.apply {
                if (isClosed) open() else close()
            }
        }
    }

    Scaffold(
        scaffoldState = scaffoldState,
        drawerContent = {
            AppDrawer(drawerNavPaths, openCloseDrawer, appTitle)
        },
        topBar = { TopBar(topBarNavPaths, openCloseDrawer, appTitle) }
    ) {
        AndroidViewBinding(ContentMainBinding::inflate)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Travel_AppTheme {
        MainScreen(emptyMap(), emptyMap(), remember { mutableStateOf("Travel App") })
    }
}