package org.izv.jcl.basicuserinterface

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
    val textField = remember {mutableStateOf("")}
    // textField es del tipo MutableState<String>, mutable
    var textString by remember {mutableStateOf("")}
    // textField2 es del tipo String, inmutable

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        TextField(
            value = textField.value,
            modifier = Modifier,
            onValueChange = {textField.value = it},
            //lambda-expresion a la que le llega un parámetro
            //puedo omitir el nombre del parametro y usar su
            //nombre predeterminado que es, en todoas las
            //lambda expresiones: it
            //parametro -> textFieldValue.value = parametro
            label = {Text("Insert your text: ")}
        )
//        TextField(
//            value = textField2,
//            modifier = Modifier,
//            onValueChange = {textField2 = it}
//
//
//        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                if (textField.value.isEmpty()) {
                    textString = ""
                } else {
                    textString = String.format("Hello %s", textField.value)
                }
            },
            modifier = Modifier.fillMaxWidth(),
        ) {
            Text("click")
        }

        Spacer(modifier = Modifier.height(16.dp))


        Text (
            text = if (textString.isEmpty()) "Hello ..." else textString,
            style = MaterialTheme.typography.bodyLarge,
            color = if (textString.isEmpty()) Color.Gray else Color.Black
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Counter() {
    var count by remember{mutableStateOf(0)}
    Column{
        Text(text = "Count: $count")
        Button(onClick = {count++}){
            Text(text = "Increment")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BasicUserInterfaceTheme {
        MainScreen()
    }
}