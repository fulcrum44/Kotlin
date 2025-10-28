package org.izv.jcl.pantalla3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.izv.jcl.pantalla3.ui.theme.Pantalla3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Pantalla3Theme {
                Surface (
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    PantallaTres()
                }
            }
        }
    }
}

@Composable
fun PantallaTres(modifier: Modifier = Modifier) {
    DisplayContentPantallaTres()
}

@Composable
fun DisplayContentPantallaTres(modifier: Modifier = Modifier) {
    Column(modifier = Modifier.fillMaxSize()) {
        Row(modifier = Modifier.weight(weight = 1f)) {
            Column(modifier = Modifier
                .weight(weight = 1f)
                .padding(16.dp)
                .background(color = Color(0xFFEADDFF))
                .fillMaxSize(),
                verticalArrangement = Arrangement.Center , horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "Text composable",
                    textAlign = TextAlign.Justify,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 16.dp)
                )

                Text(
                    text = "Displays text and follows the recommended Material Design guidelines.",
                    textAlign = TextAlign.Justify,
                )
            }

            Column(modifier = Modifier
                .weight(weight = 1f)
                .padding(16.dp)
                .background(color = Color(0xFFD0BCFF))
                .fillMaxSize(),
                verticalArrangement = Arrangement.Center , horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "Image composable",
                    textAlign = TextAlign.Justify,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 16.dp)
                )

                Text(
                    text = "Creates a composable that lays out and draws a given Painter class object.",
                    textAlign = TextAlign.Justify,
                )
            }

        }

        Row(modifier = Modifier.weight(weight = 1f)) {
            Column(modifier = Modifier
                .weight(weight = 1f)
                .padding(16.dp)
                .background(color = Color(0xFFB69DF8))
                .fillMaxSize(),
                verticalArrangement = Arrangement.Center , horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "Row composable",
                    textAlign = TextAlign.Justify,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 16.dp)
                )

                Text(
                    text = "A layout composable that places its children in a horizontal sequence.",
                    textAlign = TextAlign.Justify,
                )
            }

            Column(modifier = Modifier
                .weight(weight = 1f)
                .padding(16.dp)
                .background(color = Color(0xFFF6EDFF))
                .fillMaxSize(),
                verticalArrangement = Arrangement.Center , horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "Column composable",
                    textAlign = TextAlign.Justify,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 16.dp)
                )

                Text(
                    text = "A layout composable that places its children in a vertical sequence.",
                    textAlign = TextAlign.Justify,
                )
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Pantalla3Theme {
        PantallaTres()
    }
}