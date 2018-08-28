package app.kdblue.com.creditsuddhar.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity
public class Article {

    @NonNull
    @PrimaryKey(autoGenerate = true)
    private int id;

    private String title;
    private String discription;

    @ColumnInfo(typeAffinity = ColumnInfo.BLOB)
    private byte[] image;

    public Article(String title, String discription,byte[] image) {
        this.title = title;
        this.discription = discription;
        this.image = image;
    }

    @NonNull
    public int getId() {
        return id;
    }

    public void setId(@NonNull int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
