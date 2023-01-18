package com.example.travel_app.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.travel_app.R

@Composable
fun WeatherScreen() {
    Surface(modifier = Modifier.fillMaxSize()) {
        WeatherMain()
    }
}

@Composable
fun WeatherMain() {
    val isLightTheme = MaterialTheme.colors.isLight
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "12.09.2023",
            style = MaterialTheme.typography.caption,
        )
        Spacer(modifier = Modifier.size(4.dp))
        Row(modifier = Modifier.wrapContentSize(), verticalAlignment = Alignment.CenterVertically) {
            ReusableImage(
                image = if (isLightTheme) {
                    R.drawable.ic_location_light
                } else {
                    R.drawable.ic_location_dark
                },
                contentScale = ContentScale.Fit,
                contentDesc = "Location Icon",
                modifier = Modifier
                    .size(16.dp)
                    .padding(end = 4.dp)
            )
            Text(
                text = "Barcelona, Spain",
                style = MaterialTheme.typography.body2,
            )
        }

        Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center) {
            Box(
                modifier = Modifier
                    .wrapContentHeight()
                    .fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    ReusableImage(
                        image =
                        if (isLightTheme) {
                            R.drawable.ic_world_map_light
                        } else {
                            R.drawable.ic_world_map_dark
                        },
                        contentScale = ContentScale.Fit,
                        contentDesc = "Background",
                        modifier = Modifier.offset(y = (-20).dp)
                    )
                }
                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    ReusableImage(
                        image = R.drawable.ic_cloud_zappy,
                        contentScale = ContentScale.Fit,
                        contentDesc = "Weather img",
                        modifier = Modifier
                            .size(250.dp)
                            .padding(top = 40.dp, bottom = 20.dp)
                    )
                    Text(text = "Cloudy", style = MaterialTheme.typography.subtitle1)
                    Spacer(modifier = Modifier.size(4.dp))
                    Row(modifier = Modifier.wrapContentSize()) {
                        Text(
                            text = "18",
                            style = MaterialTheme.typography.h1,
                            modifier = Modifier.offset(y = (-24).dp)
                        )
                        ReusableImage(
                            image = R.drawable.ic_degree,
                            contentScale = ContentScale.Fit,
                            contentDesc = "Degree Icon",
                            modifier = Modifier
                        )
                    }
                    Text(
                        text = "Cloudy with a chance of meatballs",
                        style = MaterialTheme.typography.body1,
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.size(16.dp))
                }
            }
            DailyWeatherList()
        }
    }
}

@Composable
fun DailyWeatherList() {
    val weathersUpdate: List<Triple<String, String, String>> = listOf(
        Triple("00:00:00", "29.0", "wind"),
        Triple("02:30:00", "26.6", "rain"),
        Triple("04:00:00", "27.8", "thunder"),
        Triple("06:30:00", "29.3", "angledRain"),
        Triple("08:00:00", "25.5", "wind"),
        Triple("10:30:00", "26.8", "angledRain"),
    )
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(3.dp),
        modifier = Modifier.padding(5.dp)
    ) {
        weathersUpdate.map { item(key = it.first) { DailyWeatherItem(weatherUpdate = it) } }
    }
}

@Composable
fun DailyWeatherItem(weatherUpdate: Triple<String, String, String>) {
    Card(
        modifier = Modifier
            .wrapContentSize()
            .padding(4.dp),
        elevation = 1.dp,
        shape = MaterialTheme.shapes.small
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(top = 8.dp, bottom = 8.dp, start = 16.dp, end = 16.dp)
        ) {
            ReusableImage(
                image = when (weatherUpdate.third) {
                    "wind" -> R.drawable.ic_moon_cloud_fast_wind
                    "rain" -> R.drawable.ic_moon_cloud_mid_rain
                    "angledRain" -> R.drawable.ic_sun_cloud_angled_rain
                    "thunder" -> R.drawable.ic_zaps
                    else -> R.drawable.ic_moon_cloud_fast_wind
                },
                contentScale = ContentScale.Fit,
                contentDesc = "Weather Icon",
                modifier = Modifier
                    .size(64.dp)
                    .padding(bottom = 4.dp)
            )
            Text(
                text = weatherUpdate.first,
                style = MaterialTheme.typography.caption,
                modifier = Modifier.padding(4.dp)
            )
            Text(
                text = "${weatherUpdate.second}°",
                style = MaterialTheme.typography.body2,
                modifier = Modifier.padding(4.dp)
            )
        }
    }
}

@Composable
fun ReusableImage(image: Int, contentScale: ContentScale, contentDesc: String, modifier: Modifier) {
    val paintImage: Painter = painterResource(id = image)
    Image(
        painter = paintImage,
        contentDescription = contentDesc,
        contentScale = contentScale,
        modifier = modifier
    )
}

@Composable
@Preview
fun WeatherScreenPreview() {
    WeatherScreen()
}