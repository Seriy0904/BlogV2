package dev.seriy0904.blogv2.ui.createblog

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import dev.seriy0904.blogv2.domain.viewModel.BlogListViewModel
import dev.seriy0904.blogv2.ui.utils.BlogListModel
import dev.seriy0904.blogv2.ui.utils.BlogNavigationActions

@Composable
fun CreateBlog(navController: NavHostController) {
    val focusManager = LocalFocusManager.current
    val vm: BlogListViewModel = viewModel()
    val context = LocalContext.current
    val navigationActions = remember(navController) {
        BlogNavigationActions(navController)
    }
    val tittle = rememberSaveable { mutableStateOf("") }
    val description = rememberSaveable { mutableStateOf("") }
    Column(
        Modifier
            .fillMaxWidth()
            .padding(top = 30.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            label = { Text(text = "Blog tittle") },
            modifier = Modifier.padding(bottom = 20.dp),
            value = tittle.value,
            onValueChange = { tittle.value = it },
            singleLine = true,
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
            keyboardActions = KeyboardActions(onNext = {
                if (tittle.value.isNotEmpty())
                    focusManager.moveFocus(
                        focusDirection = FocusDirection.Next,
                    )
            })
        )
        TextField(
            label = { Text(text = "Blog description") },
            value = description.value,
            onValueChange = { description.value = it }
        )
        Column(
            Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.End
        ) {
            Button(modifier = Modifier.padding(all = 10.dp), onClick = {
                if (tittle.value.isEmpty() || description.value.isEmpty()) Toast.makeText(
                    context, "Blog is not save)", Toast.LENGTH_SHORT
                ).show()
                else vm.addBlog(BlogListModel(tittle = tittle.value, description = description.value))
                navigationActions.navigateToHome()
            }) {
                Text(text = "Save")
            }
        }
    }
}