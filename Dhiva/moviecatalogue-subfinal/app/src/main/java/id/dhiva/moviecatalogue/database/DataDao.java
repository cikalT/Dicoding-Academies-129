package id.dhiva.moviecatalogue.database;


import androidx.lifecycle.LiveData;
import androidx.paging.DataSource;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface DataDao {
    @Query("SELECT * FROM MovieEntity")
    DataSource.Factory<Integer, MovieEntity> getAllFavMovie();

    @Query("SELECT * FROM MovieEntity WHERE title = :title")
    LiveData<MovieEntity> getFavMovie(String title);

    @Query("DELETE FROM MovieEntity WHERE title = :title")
    void deleteFavMovie(String title);

    @Insert
    void insertFavMovie(MovieEntity movieEntity);


    @Query("SELECT * FROM TvEntity")
   DataSource.Factory<Integer, TvEntity> getAllFavTv();

    @Query("SELECT * FROM TvEntity WHERE title = :title")
    LiveData<TvEntity> getFavTv(String title);

    @Query("DELETE FROM TvEntity WHERE title = :title")
    void deleteFavTv(String title);

    @Insert
    void insertFavTv(TvEntity tvEntity);
}
