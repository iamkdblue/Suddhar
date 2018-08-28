package app.kdblue.com.creditsuddhar.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity
public class LoginUser {

    @NonNull
    @PrimaryKey(autoGenerate = true)
    private int userId;

    private String userName;
    private String userPassword;

    public LoginUser(String userName, String userPassword) {
        this.userName = userName;
        this.userPassword = userPassword;
    }

    @NonNull
    public int getUserId() {
        return userId;
    }

    public void setUserId(@NonNull int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
