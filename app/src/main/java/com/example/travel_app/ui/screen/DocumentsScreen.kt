package com.example.travel_app.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DocumentsScreen() {
    val documents = listOf(
        Triple("Passport", "54353423564234", "08/09/26"),
        Triple("Drivers Licence", "70769459465345", "24/12/28"),
        Triple("Identity Card", "988540435345456", "16/11/27"),
        Triple("USA Visa", "56843854954353", "28/05/24"),
        Triple("EGIPT Visa", "76475738932454", "20/03/25"),
        Triple("THAILAND Visa", "65543454353", "24/03/23"),
        Triple("COSTA RICA Visa", "56435656635", "17/12/27"),
    )
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = { /* ... */ }) {
                Icon(Icons.Filled.Add, "")
            }
        },
        content = { padding ->
            Column(modifier = Modifier.padding(padding)) {
                Box {
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize()
                    ) {
                        documents.map { item { DocumentItem(it) } }
                    }
                }
            }
        })
}

@Composable
fun DocumentItem(info: Triple<String, String, String>) {

    Surface(
        shape = MaterialTheme.shapes.small,
        elevation = 5.dp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {

        Box {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.LightGray)
                    .padding(10.dp)
            ) {
                Text(text = info.first, fontSize = 30.sp)
                Row {
                    Text(text = "ID: ", fontSize = 16.sp, fontStyle = FontStyle.Italic)
                    Text(text = info.second, fontSize = 16.sp)
                }
                Row {
                    Text(text = "Expiration Date: ", fontSize = 16.sp, fontStyle = FontStyle.Italic)
                    Text(text = info.third, fontSize = 16.sp)
                }
            }
            Icon(
                Icons.Filled.Visibility, contentDescription = null, modifier = Modifier.align(Alignment.TopEnd).padding(4.dp)
            )
        }
    }
}
