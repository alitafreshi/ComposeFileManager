package com.tafreshiali.home.ui.components


import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun CustomLinearProgressbarComponent(
    modifier: Modifier = Modifier,
    progressCount: Float,
    iconId: Int,
    title: String,
    backgroundColor: Color = Color.White,
    progressBackGroundColor: Color,
    progressbarHeight: Dp = 17.dp,
    progressBarShape: Shape = RoundedCornerShape(9.dp),
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        LinearProgressbarTitleComponent(
            modifier = Modifier.weight(1F),
            iconId = iconId,
            title = title,
            horizontalArrangementMode = Arrangement.spacedBy(5.dp),
        )

        LinearProgressbarComponent(
            modifier = Modifier.weight(1F),
            progressCount = progressCount,
            backgroundColor = backgroundColor,
            progressBackGroundColor = progressBackGroundColor,
            progressbarHeight = progressbarHeight,
            progressBarShape = progressBarShape
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CustomLinearProgressbarComponentPreview() {
    CustomLinearProgressbarComponent(
        progressCount = 0.5F,
        iconId = com.tafreshiali.filemanager.R.drawable.ic_play,
        title = "Video",
        backgroundColor = Color.Black,
        progressBackGroundColor = Color.Blue,

        )
}


@Composable
fun LinearProgressbarTitleComponent(
    modifier: Modifier = Modifier,
    iconId: Int,
    title: String,
    horizontalArrangementMode: Arrangement.Horizontal = Arrangement.SpaceAround
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = horizontalArrangementMode
    ) {
        Image(
            modifier = Modifier.size(24.dp),
            painter = painterResource(id = iconId),
            contentDescription = "Icon"
        )

        Text(text = title, color = Color.White, fontSize = 10.sp)
    }
}

@Preview(showBackground = true )
@Composable
fun LinearProgressbarTitleComponentPreview() {
    LinearProgressbarTitleComponent(
        iconId = com.tafreshiali.filemanager.R.drawable.ic_play,
        title = "Video"
    )
}


@Composable
fun LinearProgressbarComponent(
    modifier: Modifier = Modifier,
    backgroundColor: Color = Color.Black,
    progressBackGroundColor: Color = Color.Blue,
    progressbarHeight: Dp = 17.dp,
    progressBarShape: Shape = RoundedCornerShape(9.dp),
    progressCount: Float
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(progressbarHeight)
    ) {
        // for the background of the ProgressBar
        Box(
            modifier = Modifier
                .fillMaxSize()
                .clip(progressBarShape)
                .background(backgroundColor)
        )
        // for the progress of the ProgressBar
        Box(
            modifier = Modifier
                .fillMaxWidth(progressCount)
                .fillMaxHeight()
                .clip(progressBarShape)
                .background(progressBackGroundColor)
                .animateContentSize()
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LinearProgressbarPreview() {
    LinearProgressbarComponent(progressCount = 0.6F)
}