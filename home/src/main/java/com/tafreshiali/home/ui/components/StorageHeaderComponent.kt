package com.tafreshiali.home.ui.components

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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tafreshiali.filemanager.R

@Composable
fun StorageHeaderComponent(
    modifier: Modifier = Modifier,
    headerIcon: Int = R.drawable.ic_storage_status,
    title: String
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(15.dp)
    ) {
        Image(
            modifier = Modifier.size(24.dp),
            painter = painterResource(id = headerIcon),
            contentDescription = "Header Icon"
        )

        Text(text = title, color = Color.White)
    }
}

@Preview(showBackground = true)
@Composable
fun StorageHeaderComponentPreview() {
    StorageHeaderComponent(title = "Phone Storage Info")
}