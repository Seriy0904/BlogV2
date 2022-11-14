package dev.seriy0904.blogv2.ui.recommendations

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import dev.seriy0904.blogv2.domain.viewModel.BlogListViewModel
import dev.seriy0904.blogv2.ui.utils.BlogList

@Composable
fun MainRecommendedList(){
    val vm:BlogListViewModel = viewModel()
    val lifecycleOwner = LocalLifecycleOwner.current
    vm.loadList()
    val list = remember { mutableStateOf(vm.blogs.value) }
    vm.blogs.observe(lifecycleOwner){list.value = it}
    BlogList(ArrayList(list.value?: emptyList()))
}
