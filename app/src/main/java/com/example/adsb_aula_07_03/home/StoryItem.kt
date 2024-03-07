package com.example.adsb_aula_07_03.home

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.adsb_aula_07_03.R

@Preview(
    showBackground = true,
)
@Composable
fun StoryItemPreview() {
    StoryItem(
        text = "Story 1"
    )
}

@Composable
fun StoryItem(
    @DrawableRes image: Int = R.drawable.dunas,
    text: String = "Story #"
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
            painter = painterResource(id = image),
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