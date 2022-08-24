package dev.seriy0904.blogv2.ui.utils

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

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
    Column(Modifier.padding(horizontal = 10.dp).padding(6.dp)) {
        Text(text = item.name, style = MaterialTheme.typography.subtitle1)
        Text(text = item.description, style = MaterialTheme.typography.body2)
    }
    Divider(
        modifier = Modifier.padding(horizontal = 14.dp),
        color = MaterialTheme.colors.onSurface.copy(alpha = 0.08f)
    )
}