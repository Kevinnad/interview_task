package com.example.interviewtask.di

import android.content.Context
import com.example.interviewtask.database.DataBaseProvider
import com.example.interviewtask.database.FormDataBase
import com.example.interviewtask.database.FormDataBaseSource
import com.example.interviewtask.datastore.FormDataStore
import com.example.interviewtask.datastore.FormDataStoreImpl
import com.example.interviewtask.network.HttpClientBuilderFactory
import com.example.interviewtask.network.Services
import com.example.interviewtask.repository.FormRepository
import com.example.interviewtask.repository.FormRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesService(httpClient: HttpClientBuilderFactory): Services = Services.createService(httpClient)

    @Provides
    @Singleton
    fun provideHttpBuilderFactory() : HttpClientBuilderFactory = HttpClientBuilderFactory()

    @Provides
    fun provideFormDataBaseRoom(@ApplicationContext context: Context) : FormDataBase = DataBaseProvider(context).createDB()

    @Provides
    fun provideFormDataBaseSource(formDataBase: FormDataBase) : FormDataBaseSource = FormDataBaseSource(formDataBase)

    @Provides
    fun provideFormDataStore(services: Services, formDataBase: FormDataBaseSource) : FormDataStore = FormDataStoreImpl(services,formDataBase)

    @Provides
    fun provideFormRepository(formDataStore: FormDataStore) : FormRepository = FormRepositoryImpl(formDataStore)
}