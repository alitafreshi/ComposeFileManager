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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tafreshiali.home.R

@Composable
fun CustomLinearProgressbarComponent(
    modifier: Modifier = Modifier,
    customLinearProgressbarProperties: CustomLinearProgressbarProperties
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        LinearProgressbarTitleComponent(
            modifier = Modifier.weight(1F),
            linearProgressbarTitleProperties = customLinearProgressbarProperties.linearProgressbarTitleProperties
        )

        LinearProgressbarComponent(
            modifier = Modifier.weight(1F),
            linearProgressbarProperties = customLinearProgressbarProperties.linearProgressbarProperties
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CustomLinearProgressbarComponentPreview() {
    CustomLinearProgressbarComponent(
        customLinearProgressbarProperties = CustomLinearProgressbarProperties(
            linearProgressbarTitleProperties = LinearProgressbarTitleProperties(
                iconId = R.drawable.ic_play,
                title = "Video",
                titleTextStyle = TextStyle(color = Color.White),
                horizontalArrangementMode = Arrangement.spacedBy(5.dp)
            ),
            linearProgressbarProperties = LinearProgressbarProperties(
                backgroundColor = Color.Black,
                progressbarHeight = 15.dp,
                progressCount = 0.5F,
                progressBackGroundColor = Color.Blue,
                progressBarShape = RoundedCornerShape(9.dp)
            )
        )

    )
}

data class CustomLinearProgressbarProperties(
    val linearProgressbarTitleProperties: LinearProgressbarTitleProperties,
    val linearProgressbarProperties: LinearProgressbarProperties
)


@Composable
fun LinearProgressbarTitleComponent(
    modifier: Modifier = Modifier,
    linearProgressbarTitleProperties: LinearProgressbarTitleProperties
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = linearProgressbarTitleProperties.horizontalArrangementMode
    ) {
        Image(
            modifier = Modifier.size(24.dp),
            painter = painterResource(id = linearProgressbarTitleProperties.iconId),
            contentDescription = "Icon"
        )

        Text(
            text = linearProgressbarTitleProperties.title,
            style = linearProgressbarTitleProperties.titleTextStyle
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LinearProgressbarTitleComponentPreview() {
    LinearProgressbarTitleComponent(
        linearProgressbarTitleProperties = LinearProgressbarTitleProperties(
            iconId = R.drawable.ic_play,
            title = "Video",
            titleTextStyle = TextStyle(color = Color.White, fontSize = 10.sp),
            horizontalArrangementMode = Arrangement.SpaceAround
        )
    )
}

data class LinearProgressbarTitleProperties(
    val iconId: Int,
    val title: String,
    val titleTextStyle: TextStyle,
    val horizontalArrangementMode: Arrangement.Horizontal
)


@Composable
fun LinearProgressbarComponent(
    modifier: Modifier = Modifier,
    linearProgressbarProperties: LinearProgressbarProperties
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(linearProgressbarProperties.progressbarHeight)
    ) {
        // for the background of the ProgressBar
        Box(
            modifier = Modifier
                .fillMaxSize()
                .clip(linearProgressbarProperties.progressBarShape)
                .background(linearProgressbarProperties.backgroundColor)
        )
        // for the progress of the ProgressBar
        Box(
            modifier = Modifier
                .fillMaxWidth(linearProgressbarProperties.progressCount)
                .fillMaxHeight()
                .clip(linearProgressbarProperties.progressBarShape)
                .background(linearProgressbarProperties.progressBackGroundColor)
                .animateContentSize()
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LinearProgressbarPreview() {
    LinearProgressbarComponent(
        linearProgressbarProperties = LinearProgressbarProperties(
            backgroundColor = Color.Black,
            progressbarHeight = 15.dp,
            progressCount = 0.5F,
            progressBackGroundColor = Color.Blue,
            progressBarShape = RoundedCornerShape(9.dp)
        )
    )
}

data class LinearProgressbarProperties(
    val backgroundColor: Color,
    val progressBackGroundColor: Color,
    val progressbarHeight: Dp,
    val progressBarShape: Shape,
    val progressCount: Float
)