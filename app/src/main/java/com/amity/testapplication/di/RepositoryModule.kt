package jp.com.atom.jrfbilling.newDesign.di


import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.amity.testapplication.data.remote.IAPIService
import com.amity.testapplication.data.repository.MainRepositoryImpl
import com.amity.testapplication.domain.MainRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideMainRepository(
        apiService: IAPIService,
        dispatcher: CoroutineDispatcher
    ): MainRepository {
        return MainRepositoryImpl(apiService, dispatcher)
    }


//    @Singleton
//    @Provides
//    fun provideAuthentication():Authentication {
//    }
}
