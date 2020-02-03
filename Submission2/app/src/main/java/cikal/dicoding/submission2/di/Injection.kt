package cikal.dicoding.submission2.di

import android.content.Context
import cikal.dicoding.submission2.data.source.CatalogueRepository
import cikal.dicoding.submission2.data.source.remote.RemoteDataSource
import cikal.dicoding.submission2.utils.JsonHelper

object Injection {

    fun provideRepository(context: Context): CatalogueRepository {

        val remoteDataSource = RemoteDataSource.getInstance(JsonHelper(context))

        return CatalogueRepository.getInstance(remoteDataSource)
    }
}