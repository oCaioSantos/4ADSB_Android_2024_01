package com.example.adsb_aula_07_03.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.adsb_aula_07_03.R

@Preview(
    showBackground = true,
    widthDp = 300
)
@Composable
fun StoryItemRowPreview() {
    StoryItemRow()
}

@Composable
fun StoryItemRow(
    modifier: Modifier = Modifier
) {
    LazyRow(
        modifier = modifier,
        horizontalArrangement =
        Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(
            horizontal = 16.dp
        )
    ) {
        items(Story.getMockList()) { story ->
            StoryItem(
                image = story.image,
                text = story.text
            )
        }
    }
}

data class Story(
    val id: Int,
    val text: String,
    val image: Int = R.drawable.dunas
) {
    companion object {
        fun getMockList(): List<Story> {
            return List(5) {
                Story(id = it, text = "Story $it")
            }
        }
    }
}

