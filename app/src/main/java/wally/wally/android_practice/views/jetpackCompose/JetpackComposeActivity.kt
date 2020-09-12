package wally.wally.android_practice.views.jetpackCompose

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview

class JetpackComposeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Greeting("Hello world!")
                Toaster(context = applicationContext)
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}


@Composable
fun Toaster(context: Context) {
    Button(onClick = {
        Toast.makeText(context, "You just clicked a Clickable", Toast.LENGTH_LONG).show()
    }) {
        Text("Show Toast!")
    }
}

@Preview
@Composable
fun PreviewGreeting() {
    Greeting("Android")
}