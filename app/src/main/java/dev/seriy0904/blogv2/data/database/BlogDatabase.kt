package dev.seriy0904.blogv2.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import dev.seriy0904.blogv2.data.database.dao.BlogsDao
import dev.seriy0904.blogv2.data.database.entities.Blog
import kotlinx.coroutines.coroutineScope

@Database(entities = [Blog::class], version = 1)
abstract class BlogDatabase : RoomDatabase() {
    abstract fun blogDao(): BlogsDao

    companion object {
        @Volatile
        private var instance: BlogDatabase? = null
        private val DB_NAME = "blog_db"
        suspend fun getDatabase(context: Context) =
            coroutineScope {
                var tempInst = instance
                if (tempInst == null) {
                    tempInst = Room.databaseBuilder(
                        context.applicationContext,
                        BlogDatabase::class.java,
                        DB_NAME
                    )
                        .build()
                    instance = tempInst
                }
                tempInst
            }
    }
}