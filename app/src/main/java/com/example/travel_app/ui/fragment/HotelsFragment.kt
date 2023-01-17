package com.example.travel_app.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import com.example.travel_app.ui.screen.HotelsScreen
import com.example.travel_app.ui.theme.Travel_AppTheme

class HotelsFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return ComposeView(requireContext()).apply {
            setContent {
                Travel_AppTheme {
                    HotelsScreen()
                }
            }
        }
    }
}