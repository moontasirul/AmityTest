package com.amity.testapplication.data.repository


import android.util.Log
import com.amity.testapplication.core.network.DispatcherProvider
import com.amity.testapplication.core.network.Resource
import com.amity.testapplication.data.local.db.AppDataBase
import com.amity.testapplication.data.model.local.toDoModel
import com.amity.testapplication.data.remote.IAPIService
import com.amity.testapplication.domain.IMainRepository
import dagger.hilt.android.scopes.ActivityRetainedScoped
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import timber.log.Timber
import javax.inject.Inject

@ActivityRetainedScoped
class MainRepositoryImpl @Inject constructor(
    private val apiService: IAPIService,
    private val dispatcher: DispatcherProvider,
    private val appDataBase: AppDataBase,
) : IMainRepository {

    /**
     * Get all to Do list data reactively
     * either remote or local
     */
    override suspend fun getAllData() = flow {
        emit(Resource.Loading())
        // fetch remote data
        try {
            val apiResponse = apiService.getTodoList()
            if (apiResponse.isSuccessful) {
                val todoList = apiResponse.body()?.map {
                    it.toDoModel()
                }
                if (todoList != null) {
                    appDataBase.todoDao().insertAll(todoList)
                }
            }
        }catch (e:Exception){
            Timber.d(e.message.toString())
        }
        // observe local data
        appDataBase.todoDao().getAllTodo().collect { cacheData ->
            emit(Resource.Success(cacheData))
        }

    }.flowOn(dispatcher.IO)
}