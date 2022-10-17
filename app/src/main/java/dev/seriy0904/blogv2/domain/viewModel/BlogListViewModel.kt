package dev.seriy0904.blogv2.domain.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import dev.seriy0904.blogv2.data.database.BlogDatabase
import dev.seriy0904.blogv2.ui.utils.BlogListModel
import kotlinx.coroutines.launch

class BlogListViewModel(application: Application) : AndroidViewModel(application) {
    private val _blogs = MutableLiveData<List<BlogListModel>>()
    val blogs = _blogs
    fun loadList() {
        viewModelScope.launch {
            val db =
                BlogDatabase.getDatabase(getApplication<Application>().applicationContext).blogDao()
            _blogs.value = db.getAllBlogs().map { i ->
                BlogListModel(
                    tittle = i.tittle,
                    description = i.description
                )
            }.toList()
        }
    }

    fun addBlog() {
        TODO()
    }
}