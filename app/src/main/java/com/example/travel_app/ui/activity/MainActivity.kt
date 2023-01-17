package com.example.travel_app.ui.activity

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.travel_app.R
import com.example.travel_app.ui.screen.MainScreen
import com.example.travel_app.ui.theme.Travel_AppTheme

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Travel_AppTheme {
                val appTitle = remember { mutableStateOf("Current Trip") }
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    MainScreen(drawerNavPaths, topBarNavPaths, appTitle)
                }
            }
        }
    }

    private fun findNavController(): NavController {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        return navHostFragment.navController
    }

    private val drawerNavPaths: Map<String, () -> Unit> = mapOf(
        HOTELS to {
            findNavController().navigate(R.id.hotelsFragment)
            println("Restaurants Pressed")
        },
        RESTAURANTS to {
            findNavController().navigate(R.id.restaurantsFragment)
            println("RestaurantsFragment Pressed")
        },
        FLIGHTS to {
            findNavController().navigate(R.id.flightsFragment)
            println("FlightsFragment Pressed")
        },
        ATTRACTIONS to {
            findNavController().navigate(R.id.attractionsFragment)
            println("Attractions Pressed")
        },
        LOCAL_GUIDES to {
            findNavController().navigate(R.id.localGuidesFragment)
            println("Local Guides Pressed")
        },
        DOCUMENTS to {
            findNavController().navigate(R.id.documentsFragment)
            println("Documents Pressed")
        }
    )

    private val topBarNavPaths: Map<String, () -> Unit> = mapOf(
        WEATHER to {
            findNavController().navigate(R.id.weatherFragment)
            println("Weather Pressed")
        },
        CURRENT_TRIP to {
            findNavController().navigate(R.id.currentTripFragment)
            println("Current Trip Pressed")
        },
    )

    companion object {
        const val HOTELS = "Hotels"
        const val RESTAURANTS = "Restaurants"
        const val FLIGHTS = "Flights"
        const val ATTRACTIONS = "Attractions"
        const val LOCAL_GUIDES = "Local Guides"
        const val WEATHER = "Weather"
        const val CURRENT_TRIP = "Current Trip"
        const val DOCUMENTS = "Documents"
    }
}