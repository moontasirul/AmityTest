package com.amity.testapplication.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.amity.testapplication.data.local.dao.ToDoDao
import com.amity.testapplication.data.model.local.ToDoModel

@Database(entities = [ToDoModel::class], version = 1, exportSchema = true)
abstract class AppDataBase : RoomDatabase(){

    abstract fun todoDao(): ToDoDao
}