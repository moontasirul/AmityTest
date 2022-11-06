package com.amity.testapplication.data.remote

import com.amity.testapplication.data.model.remote.ToDoListResponseItem
import retrofit2.Response
import retrofit2.http.GET

/**
 * data layer remote api service
 * all api function declare here
 */
interface IAPIService {
    @GET("/todos")
    suspend fun getTodoList(): Response<List<ToDoListResponseItem>>
}