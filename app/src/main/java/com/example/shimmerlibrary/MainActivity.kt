package com.example.shimmerlibrary

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shimmerlibrary.ShimmerLib.shimmerModAnimation
import com.example.shimmerlibrary.components.ShimmerShape
import com.example.shimmerlibrary.ui.theme.ShimmerLibraryTheme


val brightColorShades = listOf(
    Color.Green.copy(0.9f),
    Color.Green.copy(0.2f),
    Color.Green.copy(0.9f),
)

val textShimmerColor = listOf(
    Color.Cyan,
    Color.Blue,
    Color.Yellow
)


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ShimmerLibraryTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .padding(innerPadding)
                            .padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(15.dp),
                        content = {
                            Text(
                                text = "Shimmer SDK",
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold
                            )

                            LazyRow(
                                content = {
                                    repeat(5) {
                                        item {
                                            Box(modifier = Modifier.padding(10.dp)) {
                                                ShimmerLib.RegularShimmerAnimation(
                                                    shimmerShape = ShimmerShape.Circle,
                                                    modifier = Modifier.size(50.dp)
                                                )
                                            }
                                        }
                                    }
                                }
                            )

                            LazyColumn(
                                content = {
                                    repeat(2) {

                                        item {
                                            Box(modifier = Modifier.padding(10.dp)) {
                                                ShimmerLib.RegularShimmerAnimation(
                                                    shimmerColorShades = brightColorShades,
                                                    shimmerShape = ShimmerShape.Circle,
                                                    modifier = Modifier.size(150.dp)
                                                )
                                            }
                                        }
                                    }
                                }
                            )

                            LazyRow(
                                content = {
                                    repeat(5) {
                                        item {
                                            Box(modifier = Modifier.padding(10.dp)) {
                                                ShimmerLib.RegularShimmerAnimation(
                                                    shimmerShape = ShimmerShape.Oval,
                                                    modifier = Modifier.size(50.dp)
                                                )
                                            }
                                        }
                                    }
                                }
                            )

                            Text(
                                text = "Summer Time",
                                modifier = Modifier.shimmerModAnimation(textShimmerColor)
                            )

                            ShimmerLib.ShimmerText(
                                text = "Joy the Star",
                                shimmerColors = textShimmerColor,
                            )

                        }
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ShimmerLibraryTheme {
        Greeting("Android")
    }
}