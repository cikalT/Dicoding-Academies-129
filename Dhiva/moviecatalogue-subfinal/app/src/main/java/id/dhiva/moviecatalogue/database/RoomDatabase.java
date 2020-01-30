package id.dhiva.moviecatalogue.database;

import android.content.Context;

import androidx.room.Room;

@androidx.room.Database(entities = {MovieEntity.class, TvEntity.class}, version = 1)
public abstract class RoomDatabase extends androidx.room.RoomDatabase {
    public abstract DataDao dataDao();

    private static volatile RoomDatabase INSTANCE;

    public static RoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (RoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            RoomDatabase.class, "favorite_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
