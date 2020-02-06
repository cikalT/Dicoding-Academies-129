package cikal.dicoding.finalsubmission.di

import android.content.Context
import cikal.dicoding.finalsubmission.data.source.CatalogueRepository
import cikal.dicoding.finalsubmission.data.source.remote.RemoteDataSource
import cikal.dicoding.finalsubmission.utils.JsonHelper

object Injection {
    fun provideRepository(context: Context): CatalogueRepository {

        val remoteDataSource = RemoteDataSource.getInstance(JsonHelper(context))

        return CatalogueRepository.getInstance(remoteDataSource)
    }
}