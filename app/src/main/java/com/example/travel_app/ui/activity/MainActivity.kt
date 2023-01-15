package com.example.travel_app.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.travel_app.R
import com.example.travel_app.ui.screen.MainScreen
import com.example.travel_app.ui.theme.Travel_AppTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(
            ComposeView(this).apply {
                setContent {
                    Travel_AppTheme {
                        // A surface container using the 'background' color from the theme
                        val homeClick: () -> Unit = {
                            findNavController().navigate(R.id.homeFragment)
                            println("Home Pressed")
                        }
                        val fragment1Click: () -> Unit = {
                            findNavController().navigate(R.id.fragment1)
                            println("Fragment1 Pressed")
                        }
                        val navClicks = listOf(homeClick, fragment1Click, { println(3) }, { println(4) }, { println(5) })
                        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                            MainScreen(navClicks)
                        }
                    }
                }
            }
        )
    }

    private fun findNavController(): NavController {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        return navHostFragment.navController
    }
}