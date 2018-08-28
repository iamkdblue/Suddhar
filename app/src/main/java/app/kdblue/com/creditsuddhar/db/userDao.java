package app.kdblue.com.creditsuddhar.db;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import app.kdblue.com.creditsuddhar.model.Article;
import app.kdblue.com.creditsuddhar.model.LoginUser;
import app.kdblue.com.creditsuddhar.model.UserDetail;

@Dao
public interface userDao {

    @Query("SELECT userId FROM LoginUser WHERE userName = :userName AND userPassword = :userPassword")
    int getLoginUserId(String userName,String userPassword);

    @Insert
    void insertUserLogin(LoginUser loginUser);

    @Query("SELECT * FROM LoginUser")
    boolean isThereAnyData();

    @Insert
    void insertArticle(Article article);

    @Query("SELECT * FROM Article")
    List<Article> getAllArticle();

    @Query("SELECT * FROM UserDetail WHERE userId = :userId")
    UserDetail getUserDetail(int userId);

    @Insert
    void insertUserDetail(UserDetail userDetail);

}
