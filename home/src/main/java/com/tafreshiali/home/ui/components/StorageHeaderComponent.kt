package com.tafreshiali.home.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tafreshiali.home.R

@Composable
fun StorageHeaderComponent(
    modifier: Modifier = Modifier,
    headerState: StorageHeaderState
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(15.dp)
    ) {
        Image(
            modifier = Modifier.size(24.dp),
            painter = painterResource(id = headerState.headerIcon),
            contentDescription = "Header Icon"
        )

        Text(text = headerState.title, style = headerState.titleFontsStyle)
    }
}

@Preview(showBackground = true)
@Composable
fun StorageHeaderComponentPreview() {
    StorageHeaderComponent(
        headerState = StorageHeaderState(
            headerIcon = R.drawable.ic_storage_status,
            title = "Phone Storage Info",
            titleFontsStyle = TextStyle(color = Color.White)
        )
    )
}

data class StorageHeaderState(
    @DrawableRes val headerIcon: Int,
    val title: String,
    val titleFontsStyle: TextStyle
)