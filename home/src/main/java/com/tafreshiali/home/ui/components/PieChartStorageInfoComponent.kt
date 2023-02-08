package com.tafreshiali.home.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.github.tehras.charts.piechart.PieChart
import com.github.tehras.charts.piechart.PieChartData
import com.github.tehras.charts.piechart.animation.simpleChartAnimation
import com.github.tehras.charts.piechart.renderer.SimpleSliceDrawer

@Composable
fun PieChartStorageInfoComponent(
    modifier: Modifier = Modifier
) {
    Box(
         modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        PieChart(
            pieChartData = PieChartData(
                listOf(
                    PieChartData.Slice(value = 30F, color = Color.Red),
                    PieChartData.Slice(value = 70F, color = Color.Blue)
                )
            ),
            // Optional properties.
            modifier = Modifier.size(50.dp),
            animation = simpleChartAnimation(),
            sliceDrawer = SimpleSliceDrawer()
        )

        Text(text = "50%",color = Color.White, fontSize = 10.sp)
    }
}

@Preview(showBackground = true)
@Composable
fun PieChartStorageInfoPreview() {
    PieChartStorageInfoComponent()
}