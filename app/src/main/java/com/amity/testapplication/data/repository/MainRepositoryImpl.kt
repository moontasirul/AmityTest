package com.amity.testapplication.data.repository


import com.amity.testapplication.data.remote.IAPIService
import com.amity.testapplication.domain.MainRepository
import dagger.hilt.android.scopes.ActivityRetainedScoped
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

@ActivityRetainedScoped
class MainRepositoryImpl @Inject constructor(
    private val apiService: IAPIService,
    private val dispatcher: CoroutineDispatcher
) : MainRepository {

}