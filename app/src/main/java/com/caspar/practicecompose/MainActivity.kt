package com.caspar.practicecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    private val boxHeight = 200.dp

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val thibautPainter = painterResource(id = R.drawable.thibautpinot)
            val chrisPainter = painterResource(id = R.drawable.chris_froome)
            val thibaut = resources.getString(R.string.thibaut_pinot)
            val chris = resources.getString(R.string.chris_froome)
            val paddingDP = 5.dp
            val firstItemPercentage = 0.5f

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.DarkGray),
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(paddingDP, paddingDP, paddingDP, 0.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth(firstItemPercentage)
                            .padding(0.dp, 0.dp, paddingDP, 0.dp)
                    ) {
                        ImageCard(painter = thibautPainter, contentDescription = thibaut, title = thibaut)
                    }
                    Box(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        ImageCard(painter = chrisPainter, contentDescription = chris, title = chris)
                    }
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(paddingDP, paddingDP, paddingDP, 0.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth(firstItemPercentage)
                            .padding(0.dp, 0.dp, paddingDP, 0.dp)
                    ) {
                        ImageCard(painter = chrisPainter, contentDescription = chris, title = chris)
                    }

                    Box(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        ImageCard(painter = thibautPainter, contentDescription = thibaut, title = thibaut)
                    }
                }
            }
        }
    }
}

@Composable
fun ImageCard(
    painter: Painter,
    contentDescription: String,
    title: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp)
    ) {
        Box(
            modifier = Modifier.height(200.dp),
        ) {
            // bottom/background image
            Image(
                painter = painter,
                contentDescription = contentDescription,
                contentScale = ContentScale.Crop
            )

            // gradient layer
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            listOf(Color.Transparent, Color.Black),
                            startY = 400f
                        )
                    )
            ) {

            }

            // text layer
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp),
                contentAlignment = Alignment.BottomStart
            ) {
                Text(title, style = TextStyle(color = Color.White, fontSize = 16.sp))
            }
        }
    }
}