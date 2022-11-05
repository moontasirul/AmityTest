package com.amity.testapplication.di

import android.app.Application
import androidx.room.Room
import com.amity.testapplication.data.local.dao.ToDoDao
import com.amity.testapplication.data.local.db.AppDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PersistenceModule {
    @Provides
    @Singleton
    fun provideAppDatabase(
        application: Application,
    ): AppDataBase {
        return Room
            .databaseBuilder(application, AppDataBase::class.java, "Photo.db")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideToDoDao(appDatabase: AppDataBase): ToDoDao {
        return appDatabase.todoDao()
    }
}