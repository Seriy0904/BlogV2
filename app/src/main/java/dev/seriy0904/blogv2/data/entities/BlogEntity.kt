package dev.seriy0904.blogv2.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Blog(
    @PrimaryKey val uid: Int,
    @ColumnInfo(name = "tittle")val tittle:String,
    @ColumnInfo(name = "description")val description:String
    )