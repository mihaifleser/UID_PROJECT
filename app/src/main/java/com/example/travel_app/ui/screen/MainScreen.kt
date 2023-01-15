package com.example.travel_app.ui.screen

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidViewBinding
import com.example.travel_app.databinding.ContentMainBinding
import com.example.travel_app.ui.theme.Travel_AppTheme
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen(navClicks: List<() -> Unit>) {
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
            AppDrawer(navClicks, openCloseDrawer)
        },
        topBar = { TopBar(openCloseDrawer) }
    ) {
        AndroidViewBinding(ContentMainBinding::inflate)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Travel_AppTheme {
        MainScreen(emptyList())
    }
}