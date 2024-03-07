package com.example.adsb_aula_07_03.home

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.adsb_aula_07_03.R

data class Movie(
    val id: Int,
    @DrawableRes
    val image: Int,
    val title: String,
    val description: String,
) {
    companion object {
        fun getMockList(): List<Movie> {
            return List(5) {
                val drawable = when (it % 2) {
                    0 -> R.drawable.friends
                    else -> R.drawable.movie
                }
                Movie(
                    id = it,
                    image = drawable,
                    title = "Filme #$it",
                    description = """
                        Ipsum Lorem dolor asimet Ipsum Lorem dolor asimet 
                        Ipsum Lorem dolor asimet Ipsum Lorem dolor asimet 
                        Ipsum Lorem dolor asimet Ipsum Lorem dolor asim
                    """.trimIndent()
                )
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun MovieItemRowPreview() {
    MovieItemRow(title = "Lançamentos", {})
}

@Composable
fun MovieItemRow(
    title: String = "Row #",
    showMovieDialog: (Movie) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            modifier = Modifier.padding(start = 16.dp),
            text = title,
            style = MaterialTheme.typography.titleLarge
        )
        LazyRow(
            contentPadding = PaddingValues(16.dp),
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            items(Movie.getMockList()) { movie ->
                Column(
                    modifier = Modifier.clickable {
                        showMovieDialog(movie)
                    }
                ) {
                    Image(
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .width(88.dp)
                            .height(108.dp)
                            .clip(RoundedCornerShape(3.dp)),
                        painter =
                        painterResource(id = movie.image),
                        contentDescription = null
                    )
                    Text(
                        text = movie.title,
                        style = MaterialTheme.typography.bodySmall
                    )
                }
            }
        }
    }
}