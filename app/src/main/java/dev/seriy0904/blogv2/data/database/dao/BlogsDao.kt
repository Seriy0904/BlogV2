package dev.seriy0904.blogv2.data.database.dao

import androidx.room.*
import dev.seriy0904.blogv2.data.database.entities.Blog

@Dao
interface BlogsDao {
    @Insert
    suspend fun insertBlog(newBlog: Blog)
    @Delete
    suspend fun deleteBlog(newBlog: Blog)
    @Update
    suspend fun updateBlog(newBlog: Blog)
    @Query("Select * from blog order by uid ASC")
    fun getAllBlogs(): List<Blog>
    @Query("Select * from blog where uid = :blogId")
    suspend fun getBlog(blogId: Int):Blog
}