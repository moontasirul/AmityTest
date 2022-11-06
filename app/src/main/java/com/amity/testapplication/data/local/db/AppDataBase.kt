package com.amity.testapplication.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.amity.testapplication.data.local.dao.ToDoDao
import com.amity.testapplication.data.model.local.ToDoModel

/**
 * App local database class
 */
@Database(entities = [ToDoModel::class], version = 1, exportSchema = true)
abstract class AppDataBase : RoomDatabase(){
    // to-do dao method
    abstract fun todoDao(): ToDoDao
}