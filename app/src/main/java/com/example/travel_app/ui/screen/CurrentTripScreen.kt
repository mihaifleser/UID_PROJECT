package com.example.travel_app.ui.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.travel_app.R

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
@Preview
fun CurrentTripScreen() {
    val attractions = listOf(
        Triple("Greek Restaurant", "Reservation: 09/08/26 18:00", R.drawable.restaurant),
        Triple("Hotel Transylvania", "Reservation: 10/08/26", R.drawable.hotel),
        Triple("Turkish Exhibition", "Opens: Monday 10:00", R.drawable.museum),
        Triple("Greek Restaurant", "Reservation: 09/08/26 18:00", R.drawable.restaurant),
        Triple("Hotel Transylvania", "Reservation: 10/08/26", R.drawable.hotel),
        Triple("Turkish Restaurant", "Reservation: 09/08/26 18:00", R.drawable.museum),
        Triple("Greek Restaurant", "Reservation: 09/08/26 18:00", R.drawable.restaurant),
        Triple("Hotel Transylvania", "Reservation: 10/08/26", R.drawable.hotel),
        Triple("Turkish Restaurant", "Reservation: 09/08/26 18:00", R.drawable.museum)
    )
    Column(modifier = Modifier.padding(8.dp)) {
        Box {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                attractions.map { item { DocumentItem(it) } }
            }
        }
    }

}

@Composable
fun DocumentItem(info: Triple<String, String, Int>) {

    Surface(
        shape = MaterialTheme.shapes.small,
        elevation = 5.dp,
        modifier = Modifier
            .height(intrinsicSize = IntrinsicSize.Min)
            .fillMaxWidth()
            .padding(16.dp)
    ) {

        Box {
            Column(
                modifier = Modifier
                    .height(intrinsicSize = IntrinsicSize.Min)
                    .fillMaxWidth()
                    .padding(10.dp)
                    .paint(
                        painter = painterResource(id = info.third),
                        contentScale = ContentScale.Crop,
                        colorFilter = ColorFilter.tint(
                            Color.LightGray, blendMode = BlendMode.Hardlight
                        )
                    )
            ) {
                Text(text = info.first, fontSize = 30.sp)
                Row {
                    Text(text = info.second, fontSize = 16.sp)
                }
            }
            Icon(
                Icons.Filled.Visibility, contentDescription = null, modifier = Modifier
                    .align(
                        Alignment.TopEnd
                    )
                    .padding(4.dp)
            )
        }
    }
}

