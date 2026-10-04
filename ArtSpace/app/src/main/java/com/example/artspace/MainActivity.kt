package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtSpaceScreen()
                }
            }
        }
    }
}

@Composable
fun ArtSpaceScreen(modifier: Modifier = Modifier) {
    // Состояние текущей картины: 1, 2 или 3
    var currentArtwork by remember { mutableIntStateOf(1) }

    val imageResource = when (currentArtwork) {
        1 -> R.drawable.artwork1
        2 -> R.drawable.artwork2
        else -> R.drawable.artwork3
    }

    val title = when (currentArtwork) {
        1 -> "Sailing Under the Bridge"
        2 -> "Still Life of Blue Rose"
        else -> "Sunset on the Horizon"
    }

    val artist = when (currentArtwork) {
        1 -> "Kat Kuan"
        2 -> "Owen Scott"
        else -> "Elena Rostova"
    }

    val year = when (currentArtwork) {
        1 -> "2017"
        2 -> "2021"
        else -> "2023"
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .statusBarsPadding()
            .safeDrawingPadding()
            .padding(horizontal = 24.dp, vertical = 16.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        // Ограничиваем максимальную ширину контента, чтобы на планшете он не растягивался на весь экран
        Column(
            modifier = Modifier
                .widthIn(max = 450.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ArtworkWall(
                imageResource = imageResource,
                contentDescription = title
            )

            Spacer(modifier = Modifier.height(32.dp))

            ArtworkDescriptor(
                title = title,
                artist = artist,
                year = year
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Кнопки навигации с круговой прокруткой (1 -> 2 -> 3 -> 1)
        DisplayController(
            onPreviousClick = {
                currentArtwork = if (currentArtwork == 1) 3 else currentArtwork - 1
            },
            onNextClick = {
                currentArtwork = if (currentArtwork == 3) 1 else currentArtwork + 1
            },
            modifier = Modifier.widthIn(max = 450.dp)
        )
    }
}

@Composable
fun ArtworkWall(
    imageResource: Int,
    contentDescription: String,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp),
        shadowElevation = 10.dp,
        color = Color.White
    ) {
        Image(
            painter = painterResource(id = imageResource),
            contentDescription = contentDescription,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(min = 280.dp, max = 400.dp)
                .padding(32.dp)
        )
    }
}

@Composable
fun ArtworkDescriptor(
    title: String,
    artist: String,
    year: String,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier.fillMaxWidth(),
        color = Color(0xFFECEBF4)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = title,
                fontSize = 24.sp,
                fontWeight = FontWeight.Light,
                color = Color.Black
            )
            Row(
                modifier = Modifier.padding(top = 4.dp)
            ) {
                Text(
                    text = artist,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
                Text(
                    text = " ($year)",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Light,
                    color = Color.DarkGray
                )
            }
        }
    }
}

@Composable
fun DisplayController(
    onPreviousClick: () -> Unit,
    onNextClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        Button(
            onClick = onPreviousClick,
            modifier = Modifier.weight(1f)
        ) {
            Text(text = "Previous")
        }
        Button(
            onClick = onNextClick,
            modifier = Modifier.weight(1f)
        ) {
            Text(text = "Next")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ArtSpaceScreenPreview() {
    ArtSpaceTheme {
        ArtSpaceScreen()
    }
}