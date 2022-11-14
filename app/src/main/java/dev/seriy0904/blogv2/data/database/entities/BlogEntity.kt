package dev.seriy0904.blogv2.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Blog(
    @PrimaryKey(autoGenerate = true) val uid: Int = 0,
    @ColumnInfo(name = "tittle")val tittle:String,
    @ColumnInfo(name = "description")val description:String
)