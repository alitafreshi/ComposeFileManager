package com.tafreshiali.home.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun StorageCompleteGeneralInfoComponent(
    modifier: Modifier = Modifier,
    containerBackGround: Color
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(color = containerBackGround, shape = RoundedCornerShape(8.dp))
            .padding(15.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {

        StorageHeaderComponent(title = "Storage General Info")

        Divider(modifier = Modifier
            .fillMaxWidth()
            .height(0.6.dp)
            .background(Color.White))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            PieChartStorageInfoComponent(modifier = Modifier.weight(0.5F))

            Column(
                modifier = Modifier.weight(1F),
                verticalArrangement = Arrangement.spacedBy(15.dp)
            ) {
                CustomLinearProgressbarComponent(
                    progressCount = 0.5F,
                    iconId = com.tafreshiali.filemanager.R.drawable.ic_play,
                    title = "Video",
                    progressBackGroundColor = Color.Blue,
                    progressbarHeight = 8.dp
                )

                CustomLinearProgressbarComponent(
                    progressCount = 0.7F,
                    iconId = com.tafreshiali.filemanager.R.drawable.ic_play,
                    title = "Documents",
                    progressBackGroundColor = Color.Yellow,
                    progressbarHeight = 8.dp

                )

                CustomLinearProgressbarComponent(
                    progressCount = 0.3F,
                    iconId = com.tafreshiali.filemanager.R.drawable.ic_play,
                    title = "Music",
                    progressBackGroundColor = Color.Red,
                    progressbarHeight = 8.dp
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun StorageCompleteGeneralInfoComponentPreview() {
    StorageCompleteGeneralInfoComponent(containerBackGround = Color.Black)

}