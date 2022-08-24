package dev.seriy0904.blogv2.ui.recommendations

import androidx.compose.runtime.Composable
import dev.seriy0904.blogv2.ui.utils.BlogList
import dev.seriy0904.blogv2.ui.utils.BlogListModel

@Composable
fun MainRecommendedList(){
    BlogList(getList())
}

private fun getList(): ArrayList<BlogListModel> {
    val arrayList = arrayListOf<BlogListModel>()
    for (i in 0..20) {
        arrayList.add(BlogListModel("Hello", "My name is James $i"))
    }
    return arrayList
}