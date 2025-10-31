package com.example.shimmerlibrary.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

enum class ShimmerDirection {

   LeftToRight, RightToLeft,
    TopToBottom, BottomToTop
}

@Composable
fun shimmerBrush(
    direction: ShimmerDirection,
    colors: List<Color>,
    translateAnim: Float
): Brush {
    return when (direction) {
        ShimmerDirection.LeftToRight -> Brush.linearGradient(
            colors = colors,
            start = Offset(translateAnim - 200f, 0f),
            end = Offset(translateAnim, 0f)
        )
        ShimmerDirection.RightToLeft -> Brush.linearGradient(
            colors = colors,
            start = Offset(1000f - translateAnim, 0f),
            end = Offset(-translateAnim, 0f)
        )
        ShimmerDirection.TopToBottom -> Brush.linearGradient(
            colors = colors,
            start = Offset(0f, translateAnim - 200f),
            end = Offset(0f, translateAnim)
        )
        ShimmerDirection.BottomToTop -> Brush.linearGradient(
            colors = colors,
            start = Offset(0f, 1000f - translateAnim),
            end = Offset(0f, -translateAnim)
        )
    }
}
