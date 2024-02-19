package com.example.a1502_4adsb

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.a1502_4adsb.ui.theme._1502_4ADSBTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            _1502_4ADSBTheme {
                App()
            }
        }
    }
}

@Composable
fun App() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
    ) {
        Text(
            text = "Calculadora IMC SPTECH",
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    vertical = 30.dp
                )
        )
        var nome by remember {
            mutableStateOf("")
        }
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = nome,
            onValueChange = {
                nome = it
            },
            label = {
                Text("Nome")
            },
            placeholder = {
                Text("Digite o seu nome completo")
            }
        )
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            var altura by remember {
                mutableStateOf("")
            }
            OutlinedTextField(
                modifier = Modifier.weight(.5f),
                value = altura,
                onValueChange = {
                    altura = it
                },
                label = {
                    Text("Altura (cm)")
                },
                placeholder = {
                    Text("Digite a sua altura")
                }
            )
            Spacer(modifier = Modifier.width(16.dp))
            var peso by remember {
                mutableStateOf("")
            }
            OutlinedTextField(
                modifier = Modifier.weight(.5f),
                value = peso,
                onValueChange = {
                    peso = it
                },
                label = {
                    Text("Peso (kg)")
                },
                placeholder = {
                    Text("Digite o seu peso")
                }
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Button(
            modifier = Modifier.align(alignment = Alignment.End),
            onClick = { /*TODO*/ }) {
            Text(text = "Calcular")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AppPreview() {
    _1502_4ADSBTheme {
        App()
    }
}