package com.example.adsb_aula_07_03.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun DrawerLayoutPreview() {
    DrawerLayout()
}

val list = listOf(
    "Filmes", "Séries",
    "Novidades", "Documentários"
)

@Composable
fun DrawerLayout(
    items: List<String> = list,
    modifier: Modifier = Modifier
) {
    ModalDrawerSheet {
        Surface(
            modifier = modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Column(
                modifier = Modifier
                    .padding(start = 16.dp, top = 16.dp)
            ) {
                for (item in items) {
                    Text(
                        text = item,
                        style = MaterialTheme.typography.headlineLarge
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
        }
    }
}