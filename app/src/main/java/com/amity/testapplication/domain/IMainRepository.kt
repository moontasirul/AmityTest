package com.amity.testapplication.domain

import com.amity.testapplication.core.network.Resource
import com.amity.testapplication.data.model.local.ToDoModel
import kotlinx.coroutines.flow.Flow

/**
 * domain layer main repo
 * fetch data from data layer
 */
interface IMainRepository {
    suspend fun getAllData(): Flow<Resource<List<ToDoModel>>>
}