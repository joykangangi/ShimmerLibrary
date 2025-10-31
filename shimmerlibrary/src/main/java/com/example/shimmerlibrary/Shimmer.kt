package com.example.shimmerlibrary

import android.annotation.SuppressLint
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.TextStyle
import com.example.shimmerlibrary.components.ShimmerDirection
import com.example.shimmerlibrary.components.ShimmerShape
import com.example.shimmerlibrary.components.shapeToClip
import com.example.shimmerlibrary.components.shimmerBrush

private val shimmerColorShadesDefault = listOf(
    Color.LightGray.copy(0.9f),
    Color.LightGray.copy(0.2f),
    Color.LightGray.copy(0.9f)
)

object ShimmerLib {

    @Composable
    fun RegularShimmerAnimation(
        shimmerColorShades: List<Color> = shimmerColorShadesDefault,
        shimmerShape: ShimmerShape,
        modifier: Modifier,
    ) {
        val transition = rememberInfiniteTransition()
        val translateAnim by transition.animateFloat(
            initialValue = 0f,
            targetValue = 1000f,
            animationSpec = infiniteRepeatable(
                tween(
                    durationMillis = 1200,
                    easing = FastOutSlowInEasing
                ),
                repeatMode = RepeatMode.Restart
            )
        )

        val brush = Brush.linearGradient(
            colors = shimmerColorShades,
            start = Offset(10f, 10f),
            end = Offset(translateAnim, translateAnim)
        )

        ShimmerItem(
            brush = brush,
            shimmerShape = shimmerShape,
            modifier = modifier
        )
    }

    @SuppressLint("SuspiciousModifierThen")
    @Composable
    fun Modifier.shimmerModAnimation(
        shimmerColorShades: List<Color>,
    ): Modifier {
        val transition = rememberInfiniteTransition()
        val translateAnim by transition.animateFloat(
            initialValue = 0f,
            targetValue = 1000f,
            animationSpec = infiniteRepeatable(
                tween(
                    durationMillis = 1200,
                    easing = FastOutSlowInEasing
                ),
                repeatMode = RepeatMode.Restart
            )
        )

        val brush = Brush.linearGradient(
            colors = shimmerColorShades,
            start = Offset(10f, 10f),
            end = Offset(translateAnim, translateAnim)
        )

        return this then background(brush)
    }

    @Composable
    fun ShimmerText(
        text: String,
        shimmerColors: List<Color> = shimmerColorShadesDefault,
        durationMillis: Int = 1200,
        direction: ShimmerDirection = ShimmerDirection.LeftToRight,

        ) {

        val transition = rememberInfiniteTransition(label = "")
        val translateAnim by transition.animateFloat(
            initialValue = 0f,
            targetValue = 1000f,
            animationSpec = infiniteRepeatable(
                animation = tween(durationMillis = durationMillis, easing = LinearEasing),
                repeatMode = RepeatMode.Restart
            ),
            label = ""
        )

        Text(
            text = text,
            style = TextStyle(
                brush = shimmerBrush(
                    direction = direction, colors = shimmerColors, translateAnim = translateAnim
                )
            )

        )

    }

}


@Composable
private fun ShimmerItem(
    brush: Brush,
    shimmerShape: ShimmerShape,
    modifier: Modifier,
) {

    when (shimmerShape) {
        ShimmerShape.Circle -> modifier.clip(CircleShape)
        is ShimmerShape.CustomShape -> modifier
        ShimmerShape.Oval -> modifier
        ShimmerShape.Rectangle -> modifier.clip(RectangleShape)
        is ShimmerShape.RoundedRectangle -> modifier.clip(RoundedCornerShape(shimmerShape.cornerRadius))
    }


    // Creating generic shaped
    Spacer(
        modifier = modifier
            .background(brush = brush, shape = shapeToClip(shimmerShape))
            .clip(shapeToClip(shimmerShape))
    )

}

