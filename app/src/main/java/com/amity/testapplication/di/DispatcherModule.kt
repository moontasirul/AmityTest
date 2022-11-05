package com.amity.testapplication.di

import com.amity.testapplication.core.network.DispatcherProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DispatcherModule {

    @Provides
    @Singleton
    fun provideIODispatcher(): DispatcherProvider {
        return DispatcherProvider()
    }
}
