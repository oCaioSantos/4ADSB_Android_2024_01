package com.example.adsb_aula_07_03.home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.adsb_aula_07_03.R
import com.example.adsb_aula_07_03.ui.theme.Adsb_aula_07_03Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Adsb_aula_07_03Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HomeScreen()
                }
            }
        }
    }
}

data class Row(
    val id: Int,
    val title: String,
)

private val rows = List(6) {
    when (it % 2) {
        0 -> Row(it, "Categoria $it")
        else -> Row(it, "Categoria $it")
    }
}

@Composable
fun HomeScreen() {
    /*
      TODO: Criar variáveis de controle de estado do Modal
     */
    /*
        TODO: Implementar DrawerLayout
    * */
    Scaffold(
        /*
            TODO: Implementar TopAppBar
         */
    ) { padding ->
        LazyColumn(
            contentPadding = padding
        ) {
            item {
                StoryItemRow(
                    modifier = Modifier
                        .padding(top = 16.dp)
                )
                Spacer(modifier = Modifier.height(32.dp))
            }
            items(rows) { row ->
                Spacer(modifier = Modifier.height(8.dp))
                MovieItemRow(
                    title = row.title,
                    showMovieDialog = { movie ->
                        /* TODO: Atualizar variáveis de controle de estado */
                    }
                )
            }
        }
    }

}

@Preview(
    showBackground = true
)
@Composable
fun HomeScreenPreview() {
    Adsb_aula_07_03Theme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            HomeScreen()
        }
    }
}