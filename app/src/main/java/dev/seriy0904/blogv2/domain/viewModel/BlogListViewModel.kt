package dev.seriy0904.blogv2.domain.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import dev.seriy0904.blogv2.data.database.BlogDatabase
import dev.seriy0904.blogv2.data.database.entities.Blog
import dev.seriy0904.blogv2.ui.utils.BlogListModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BlogListViewModel(application: Application) : AndroidViewModel(application) {
    private val _blogs = MutableLiveData<List<BlogListModel>>(listOf())
    val blogs = _blogs
    fun loadList() {
        CoroutineScope(Dispatchers.Default).launch {
            val db =
                BlogDatabase.getDatabase(getApplication<Application>().applicationContext).blogDao()
            _blogs.postValue(db.getAllBlogs().map { i -> i.dbModelToDefModel() })
        }
    }

    fun addBlog(model: BlogListModel, operationEnd: ()->Unit = {}) {
        CoroutineScope(Dispatchers.Default).launch {
            val db =
                BlogDatabase.getDatabase(getApplication<Application>().applicationContext).blogDao()
            db.insertBlog(model.defModelToDbModel())
            operationEnd()
        }
    }
    fun deleteBlog(model: BlogListModel, operationEnd: ()->Unit = {}) {
        CoroutineScope(Dispatchers.Default).launch {
            val db =
                BlogDatabase.getDatabase(getApplication<Application>().applicationContext).blogDao()
            db.deleteBlog(model.defModelToDbModel())
            operationEnd()
        }
    }

    private fun Blog.dbModelToDefModel() = BlogListModel(
        tittle = tittle, description = description, id = uid
    )

    private fun BlogListModel.defModelToDbModel() = Blog(
        tittle = tittle, description = description, uid = id
    )
}
