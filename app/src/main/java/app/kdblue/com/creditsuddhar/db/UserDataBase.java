package app.kdblue.com.creditsuddhar.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import app.kdblue.com.creditsuddhar.model.Article;
import app.kdblue.com.creditsuddhar.model.LoginUser;
import app.kdblue.com.creditsuddhar.model.UserDetail;

@Database(entities = {LoginUser.class, Article.class, UserDetail.class}, version = 1, exportSchema = false)
public abstract class UserDataBase extends RoomDatabase {
    private static UserDataBase INSTANCE;

    public abstract userDao userDao();

    public static UserDataBase getAppDatabase(Context context) {
        if (INSTANCE == null) {
            synchronized (UserDataBase.class) {
                if (INSTANCE == null) {
                    INSTANCE =
                            Room.databaseBuilder(context.getApplicationContext(), UserDataBase.class, "credit_suddhar")
                                    // allow queries on the main thread.
                                    // Don't do this on a real app! See PersistenceBasicSample for an example.
                                    .allowMainThreadQueries()
                                    .build();
                }
            }
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }
}
