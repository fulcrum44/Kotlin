package org.izv.jcl.basicuserinterface

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.izv.jcl.basicuserinterface.ui.theme.BasicUserInterfaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BasicUserInterfaceTheme {
                MainScreen()
            }
        }
    }
}

//composable

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        DisplayContent(
            modifier = Modifier.padding(innerPadding)
        )
    }
}

@Composable
fun DisplayContent(modifier: Modifier = Modifier) {
    val textFieldValue = remember {mutableStateOf("")}
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        TextField(
            value = textFieldValue.value,
            modifier = Modifier,
            onValueChange = {

            }
        )

        Button(
            onClick = {},
            modifier = Modifier,
        ) {
            Text("click")
        }

        Text("saludo")
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BasicUserInterfaceTheme {
        MainScreen()
    }
}