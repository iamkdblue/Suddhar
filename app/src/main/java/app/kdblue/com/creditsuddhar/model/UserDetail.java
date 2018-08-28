package app.kdblue.com.creditsuddhar.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity
public class UserDetail {

    @NonNull
    @PrimaryKey(autoGenerate = true)
    private int userId;

    private String userName;
    private String userEmail;
    private String userPhoneNo;
    private String userAccountNo;
    private String userCity;

    public UserDetail(String userName, String userEmail, String userPhoneNo, String userAccountNo, String userCity) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPhoneNo = userPhoneNo;
        this.userAccountNo = userAccountNo;
        this.userCity = userCity;
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

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPhoneNo() {
        return userPhoneNo;
    }

    public void setUserPhoneNo(String userPhoneNo) {
        this.userPhoneNo = userPhoneNo;
    }

    public String getUserAccountNo() {
        return userAccountNo;
    }

    public void setUserAccountNo(String userAccountNo) {
        this.userAccountNo = userAccountNo;
    }

    public String getUserCity() {
        return userCity;
    }

    public void setUserCity(String userCity) {
        this.userCity = userCity;
    }
}
