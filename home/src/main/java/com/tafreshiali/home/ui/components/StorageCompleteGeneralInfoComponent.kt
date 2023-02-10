package com.tafreshiali.home.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.github.tehras.charts.piechart.PieChartData
import com.tafreshiali.home.R

@Composable
fun StorageCompleteGeneralInfoComponent(
    modifier: Modifier = Modifier,
    containerBackGround: Color,
    pieChartStorageInfoProperties: PieChartStorageInfoProperties,
    mediaStorageInfo: List<CustomLinearProgressbarProperties>

) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(color = containerBackGround, shape = RoundedCornerShape(8.dp))
            .padding(15.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {

        StorageHeaderComponent(
            headerState = StorageHeaderState(
                headerIcon = R.drawable.ic_storage_status,
                title = "Phone Storage Info",
                titleFontsStyle = TextStyle(color = Color.White)
            )
        )

        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .height(0.4.dp)
                .background(Color.White)
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(5.dp)
        ) {

            PieChartStorageInfoComponent(
                modifier = Modifier.weight(0.6F),
                pieChartStorageInfoProperties = pieChartStorageInfoProperties
            )


            Column(
                modifier = Modifier.weight(1F),
                verticalArrangement = Arrangement.spacedBy(15.dp)
            ) {
                mediaStorageInfo.forEach { properties ->
                    CustomLinearProgressbarComponent(customLinearProgressbarProperties = properties)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun StorageCompleteGeneralInfoComponentPreview() {
    StorageCompleteGeneralInfoComponent(
        containerBackGround = Color.Black,
        pieChartStorageInfoProperties = PieChartStorageInfoProperties(
            title = "50%",
            titleTextStyle = TextStyle(color = Color.White, fontSize = 17.sp),
            pieChartData = PieChartData(
                slices = listOf(
                    PieChartData.Slice(value = 30F, color = Color.Red),
                    PieChartData.Slice(value = 70F, color = Color.Blue)
                )
            )
        ),
        mediaStorageInfo = listOf(
            CustomLinearProgressbarProperties(
                linearProgressbarProperties = LinearProgressbarProperties(
                    backgroundColor = Color.White,
                    progressBackGroundColor = Color.Blue,
                    progressbarHeight = 8.dp,
                    progressBarShape = RoundedCornerShape(10.dp),
                    progressCount = 0.5F
                ),
                linearProgressbarTitleProperties = LinearProgressbarTitleProperties(
                    iconId = R.drawable.ic_play,
                    title = "Video",
                    titleTextStyle = TextStyle(color = Color.White, fontSize = 8.sp),
                    horizontalArrangementMode = Arrangement.spacedBy(5.dp)
                )
            ),

            CustomLinearProgressbarProperties(
                linearProgressbarProperties = LinearProgressbarProperties(
                    backgroundColor = Color.White,
                    progressBackGroundColor = Color.Yellow,
                    progressbarHeight = 8.dp,
                    progressBarShape = RoundedCornerShape(10.dp),
                    progressCount = 0.7F
                ),
                linearProgressbarTitleProperties = LinearProgressbarTitleProperties(
                    iconId = R.drawable.ic_play,
                    title = "Documents",
                    titleTextStyle = TextStyle(color = Color.White, fontSize = 8.sp),
                    horizontalArrangementMode = Arrangement.spacedBy(5.dp)
                )
            ),

            CustomLinearProgressbarProperties(
                linearProgressbarProperties = LinearProgressbarProperties(
                    backgroundColor = Color.White,
                    progressBackGroundColor = Color.Red,
                    progressbarHeight = 8.dp,
                    progressBarShape = RoundedCornerShape(10.dp),
                    progressCount = 0.3F
                ),
                linearProgressbarTitleProperties = LinearProgressbarTitleProperties(
                    iconId = R.drawable.ic_play,
                    title = "Music",
                    titleTextStyle = TextStyle(color = Color.White, fontSize = 8.sp),
                    horizontalArrangementMode = Arrangement.spacedBy(5.dp)
                )
            )
        )
    )

}