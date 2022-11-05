package com.amity.testapplication.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.amity.testapplication.core.roomDB.BaseDao
import com.amity.testapplication.data.model.local.ToDoModel
import io.reactivex.Maybe

@Dao
interface ToDoDao : BaseDao<ToDoModel> {
    @Query("SELECT * FROM todo_model")
    fun getAllTodo(): Maybe<List<ToDoModel>>
}