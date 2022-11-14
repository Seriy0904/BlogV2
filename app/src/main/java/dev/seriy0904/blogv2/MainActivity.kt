package dev.seriy0904.blogv2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import dev.seriy0904.blogv2.ui.BlogApp
import dev.seriy0904.blogv2.ui.utils.GoogleRegistration

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        GoogleRegistration(this) {
            setContent {
                BlogApp()
            }
        }
    }


}
