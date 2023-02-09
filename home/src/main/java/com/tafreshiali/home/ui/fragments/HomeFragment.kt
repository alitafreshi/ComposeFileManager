package com.tafreshiali.home.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import com.tafreshiali.home.ui.components.StorageCompleteGeneralInfoComponent
import com.tafreshiali.ui.compose_theme.PrimaryBlue700

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = ComposeView(context = requireContext()).apply {
        setContent {
            StorageCompleteGeneralInfoComponent(containerBackGround = PrimaryBlue700)
        }
    }
}