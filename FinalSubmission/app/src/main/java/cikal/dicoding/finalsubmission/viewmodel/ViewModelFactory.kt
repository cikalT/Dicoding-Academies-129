package cikal.dicoding.finalsubmission.viewmodel

import androidx.lifecycle.ViewModelProvider
import android.content.Context
import androidx.lifecycle.ViewModel
import cikal.dicoding.finalsubmission.data.source.CatalogueRepository
import cikal.dicoding.finalsubmission.di.Injection
import cikal.dicoding.finalsubmission.ui.movie.MovieViewModel
import cikal.dicoding.finalsubmission.ui.tvshow.TvShowViewModel

class ViewModelFactory private constructor(private val mCatalogueRepository: CatalogueRepository) :
    ViewModelProvider.NewInstanceFactory() {

    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(context: Context): ViewModelFactory =
            instance ?: synchronized(this) {
                instance ?: ViewModelFactory(Injection.provideRepository(context))
            }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(MovieViewModel::class.java) -> {
                MovieViewModel(mCatalogueRepository) as T
            }
            modelClass.isAssignableFrom(TvShowViewModel::class.java) -> {
                TvShowViewModel(mCatalogueRepository) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }
    }
}