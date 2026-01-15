package org.izv.jcl.sourcecodeloader

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import org.izv.jcl.sourcecodeloader.ui.compose.MainScreen
import org.izv.jcl.sourcecodeloader.ui.theme.SourceCodeLoaderTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SourceCodeLoaderTheme {
                MainScreen()
            }
        }
    }
}

//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Text(
//        text = "Hello $name!",
//        modifier = modifier
//    )
//}
//
//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    SourceCodeLoaderTheme {
//        Greeting("Android")
//    }
//}