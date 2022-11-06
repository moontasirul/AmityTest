package com.amity.testapplication.di


import com.amity.testapplication.core.network.DispatcherProvider
import com.amity.testapplication.data.local.db.AppDataBase
import com.amity.testapplication.data.remote.IAPIService
import com.amity.testapplication.data.repository.MainRepositoryImpl
import com.amity.testapplication.domain.IMainRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideMainRepository(
        apiService: IAPIService,
        dispatcher: DispatcherProvider,
        appDataBase: AppDataBase
    ): IMainRepository {
        return MainRepositoryImpl(apiService, dispatcher, appDataBase)
    }
}
