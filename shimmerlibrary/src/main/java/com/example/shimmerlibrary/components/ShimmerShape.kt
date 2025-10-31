package com.example.shimmerlibrary.components

import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection

sealed class ShimmerShape {
    object Rectangle : ShimmerShape()
    object Circle : ShimmerShape()
    object Oval : ShimmerShape()
    data class RoundedRectangle(val cornerRadius: Dp) : ShimmerShape()
    data class CustomShape(val customShape: Shape) : ShimmerShape()
}

internal object OvalShape : Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline = Outline.Generic(
        Path().apply {
            addOval(Rect(0f, 0f, size.width, size.height))
        }
    )
}