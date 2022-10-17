package dev.seriy0904.blogv2.ui.createblog

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@Composable
fun CreateBlog() {
    val context = LocalContext.current
    val tittle = rememberSaveable { mutableStateOf("") }
    val description = rememberSaveable { mutableStateOf("") }
    Column(
        Modifier
            .fillMaxWidth()
            .padding(top = 20.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            label = { Text(text = "Blog tittle") },
            modifier = Modifier.padding(bottom = 10.dp),
            value = tittle.value,
            onValueChange = { tittle.value = it })
        TextField(
            label = { Text(text = "Blog description") },
            value = description.value,
            onValueChange = { description.value = it })
    }
    Column(Modifier.fillMaxSize(), verticalArrangement = Arrangement.Bottom, horizontalAlignment = Alignment.End) {
        Button(modifier = Modifier.padding(all = 10.dp),onClick = {
            Toast.makeText(context, "Blog is not save)", Toast.LENGTH_SHORT).show()
        }) {
            Text(text = "Save")
        }
    }
}