package com.tafreshiali.filemanager.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.tafreshiali.filemanager.ui.theme.PrimaryBlue700

@Composable
fun HomeScreen() {

}


@Composable
private fun PhoneStorageAnalyzerWidget(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(color = PrimaryBlue700, shape = RoundedCornerShape(15))
    ) {

    }
}

