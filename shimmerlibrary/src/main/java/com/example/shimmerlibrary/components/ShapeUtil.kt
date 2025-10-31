package com.example.shimmerlibrary.components

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape

internal fun shapeToClip(
    shape: ShimmerShape
): Shape {
    return when (shape) {
        ShimmerShape.Circle -> CircleShape
        ShimmerShape.Oval -> OvalShape
        ShimmerShape.Rectangle -> RectangleShape
        is ShimmerShape.RoundedRectangle -> RoundedCornerShape(shape.cornerRadius)
        is ShimmerShape.CustomShape -> shape.customShape
    }
}