package com.example.a4adsb_29_02

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.a4adsb_29_02.ui.theme._4ADSB_29_02Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            _4ADSB_29_02Theme {

            }
        }
    }
}

data class Story(
    val id: Int,
    val text: String,
    val imagem: Int = R.drawable.img_primeira
)

val storys = listOf(
    Story(
        id = 1,
        imagem = R.drawable.img_primeira,
        text = "Novidades"
    ),
    Story(
        id = 2,
        imagem = R.drawable.img_primeira,
        text = "Séries"
    ),
    Story(
        id = 3,
        imagem = R.drawable.img_primeira,
        text = "Docs"
    ),
    Story(
        id = 4,
        imagem = R.drawable.img_primeira,
        text = "Ação"
    ),
    Story(
        id = 5,
        imagem = R.drawable.img_primeira,
        text = "Aventura"
    ),
)

@Composable
fun StoryItemList() {
    LazyRow(
        horizontalArrangement =
        Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(
            horizontal = 16.dp
        )
    ) {
        items(storys) { story ->
            StoryItem(
                imagem = story.imagem,
                text = story.text
            )
        }
    }
    /*
        NÃO FAÇA ISSO ->
            Row {
                List(3) {
                    StoryItem(
                        R.drawable.img_primeira,
                        "Story ${it+1}"
                    )
                }
            }
     */
}

data class Movie(
    val id: Int,
    @DrawableRes
    val image: Int = R.drawable.peixes
)

val movies = listOf(
    Movie(1),
    Movie(2),
    Movie(3)
)

@Preview(showBackground = true)
@Composable
fun MovieItemRowPreview() {
    MovieItemRow()
}

@Composable
fun MovieItemRow() {
    Column {
        Text(
            modifier = Modifier.padding(start = 16.dp),
            text = "Medievais",
            style = MaterialTheme.typography.titleLarge
        )
        Spacer(modifier = Modifier.height(4.dp))
        LazyRow(
            contentPadding = PaddingValues(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(movies) { movie ->
                Image(
                    modifier = Modifier.clip(
                        RoundedCornerShape(10.dp)
                    ),
                    painter =
                    painterResource(id = movie.image),
                    contentDescription = null
                )
            }
        }
    }
}

@Preview(
    showBackground = true,
    widthDp = 300
)
@Composable
fun StoryItemListPreview() {
    StoryItemList()
}

@Composable
fun StoryItem(
    @DrawableRes imagem: Int,
    text: String
) {
    Column(
        horizontalAlignment =
        Alignment.CenterHorizontally
    ) {
        Image(
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(80.dp)
                .clip(CircleShape),
            painter = painterResource(id = imagem),
            contentDescription = null
        )
        Text(
            modifier = Modifier
                .padding(top = 8.dp),
            text = text,
            style = MaterialTheme.typography.titleSmall
        )
    }
}

@Preview(
    showBackground = true,
)
@Composable
fun StoryItemPreview() {
    StoryItem(
        imagem = R.drawable.img_primeira,
        text = "Story 1"
    )
}