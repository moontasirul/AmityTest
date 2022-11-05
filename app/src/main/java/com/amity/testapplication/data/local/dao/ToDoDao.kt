package com.amity.testapplication.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.amity.testapplication.data.model.local.ToDoModel
import kotlinx.coroutines.flow.Flow

@Dao
interface ToDoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(data: List<ToDoModel>)

    @Query("SELECT * FROM todo_model")
    fun getAllTodo(): Flow<List<ToDoModel>>
}