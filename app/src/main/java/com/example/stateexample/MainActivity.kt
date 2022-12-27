package com.example.stateexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import com.example.stateexample.ui.theme.StateExampleTheme
import androidx.compose.material.*
import androidx.compose.material3.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StateExampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //Greeting("Android")
                    DemoScreen()
                  // FunctionA()
                }
            }
        }
    }
}
@Composable
fun DemoScreen(){
    var textState by remember { mutableStateOf("") }
    val onTextChange = { text : String ->
        textState = text
    }
    MyTextField(text = textState, onTextChange = onTextChange)
   // MyTextField()
}

@Composable
fun MyTextField(text: String, onTextChange : (String) -> Unit){
   /* var textState  = remember { mutableStateOf("") }
    val onTextChange = { text : String ->
        textState.value = text
    }*/
    TextField(

        value = text,
        onValueChange = onTextChange
    )

}
@Composable
fun FunctionA() {
    var switchState by remember { mutableStateOf(true) }
    val onSwitchChange = { value : Boolean ->
        switchState = value
    }

    FunctionB(
        switchState = switchState,
        onSwitchChange = onSwitchChange
    )
}
@Composable
fun FunctionB(switchState: Boolean, onSwitchChange : (Boolean) -> Unit ) {
    Switch(
        checked = switchState,
        onCheckedChange = onSwitchChange
    )
}
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    StateExampleTheme {
       // Greeting("Android")
        DemoScreen()
    }
}