package dev.seriy0904.blogv2.ui.utils

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import dev.seriy0904.blogv2.domain.viewModel.BlogListViewModel

@Composable
fun BlogList(array: ArrayList<BlogListModel> = arrayListOf()) {
    LazyColumn(Modifier.fillMaxWidth()) {
        array.forEach {
            item { BlogListItem(it) }
        }
    }
}

@Composable
private fun BlogListItem(item: BlogListModel) {
    val vm: BlogListViewModel = viewModel()
    val menuItems = arrayOf("Delete")
    val dropDownMenu = remember { mutableStateOf(false) }
    Row() {
        Column(
            Modifier
                .padding(horizontal = 10.dp)
                .padding(6.dp)
                .weight(1f)
        ) {
            Text(text = item.tittle, style = MaterialTheme.typography.subtitle1)
            Text(text = item.description, style = MaterialTheme.typography.body2)
        }
        IconButton(onClick = { dropDownMenu.value = true }) {
            Icon(imageVector = Icons.Default.MoreVert, contentDescription = "BLOG OPTIONS")
            DropdownMenu(
                expanded = dropDownMenu.value,
                onDismissRequest = { dropDownMenu.value = false }) {
                menuItems.forEach() { s ->
                    DropdownMenuItem(onClick = {
                        dropDownMenu.value = false
                        Log.d("MyTag", item.toString())
                        vm.deleteBlog(item){
                            vm.loadList()
                        }
                    }) {
                        Text(text = AnnotatedString(s))
                    }
                }
            }
        }
    }
    Divider(
        modifier = Modifier.padding(horizontal = 14.dp),
        color = MaterialTheme.colors.onSurface.copy(alpha = 0.08f)
    )
}