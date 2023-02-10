package com.tafreshiali.home.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment
import com.github.tehras.charts.piechart.PieChartData
import com.tafreshiali.home.R
import com.tafreshiali.home.ui.components.*
import com.tafreshiali.ui.compose_theme.PrimaryBlue700

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = ComposeView(context = requireContext()).apply {
        setContent {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = Color.White)
                    .padding(15.dp)
            ) {
                StorageCompleteGeneralInfoComponent(
                    modifier = Modifier.height(IntrinsicSize.Min),
                    containerBackGround = PrimaryBlue700,
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
                                titleTextStyle = TextStyle(color = Color.White, fontSize = 10.sp),
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
                                titleTextStyle = TextStyle(color = Color.White, fontSize = 10.sp),
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
                                titleTextStyle = TextStyle(color = Color.White, fontSize = 10.sp),
                                horizontalArrangementMode = Arrangement.spacedBy(5.dp)
                            )
                        )
                    )
                )
            }

        }
    }
}