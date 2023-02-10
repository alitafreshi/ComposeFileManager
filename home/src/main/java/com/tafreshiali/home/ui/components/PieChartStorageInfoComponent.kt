package com.tafreshiali.home.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.github.tehras.charts.piechart.PieChart
import com.github.tehras.charts.piechart.PieChartData
import com.github.tehras.charts.piechart.animation.simpleChartAnimation
import com.github.tehras.charts.piechart.renderer.SimpleSliceDrawer

@Composable
fun PieChartStorageInfoComponent(
    modifier: Modifier = Modifier,
    pieChartStorageInfoProperties: PieChartStorageInfoProperties
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        PieChart(
            pieChartData = pieChartStorageInfoProperties.pieChartData,
            // Optional properties.
          /*  modifier = Modifier.size(0.5F),*/
            animation = simpleChartAnimation(),
            sliceDrawer = SimpleSliceDrawer()
        )

        Text(
            text = pieChartStorageInfoProperties.title,
            style = pieChartStorageInfoProperties.titleTextStyle
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PieChartStorageInfoPreview() {
    PieChartStorageInfoComponent(
        pieChartStorageInfoProperties = PieChartStorageInfoProperties(
            pieChartData = PieChartData(
                slices = listOf(
                    PieChartData.Slice(value = 30F, color = Color.Red),
                    PieChartData.Slice(value = 70F, color = Color.Blue)
                )
            ),
            title = "50%",
            titleTextStyle = TextStyle(color = Color.White, fontSize = 10.sp)
        )
    )
}

data class PieChartStorageInfoProperties(
    val title: String,
    val titleTextStyle: TextStyle,
    val pieChartData: PieChartData,
)