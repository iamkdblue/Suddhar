package app.kdblue.com.creditsuddhar.adapter;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import app.kdblue.com.creditsuddhar.R;
import app.kdblue.com.creditsuddhar.model.Article;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.MyArticle> {

    private List<Article> articleList;


    public ArticleAdapter(List<Article> articleList) {
        this.articleList = articleList;
    }

    @NonNull
    @Override
    public MyArticle onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_article, parent, false);

        return new MyArticle(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyArticle holder, int position) {
        Article article = articleList.get(position);

        holder.tvNewsTitle.setText(article.getTitle());
        holder.tvNewsDescription.setText(article.getDiscription());

       // byte[] decodedString = Base64.decode(article.getImage(), Base64.DEFAULT);
       // Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
        //holder.ivImage.setImageBitmap(decodedByte);
    }

    @Override
    public int getItemCount() {
        return articleList.size();
    }

    public class MyArticle extends RecyclerView.ViewHolder {

        TextView tvNewsTitle,tvNewsDescription;
        ImageView ivImage;

        public MyArticle(View itemView) {
            super(itemView);

            tvNewsTitle = itemView.findViewById(R.id.tv_news_title);
            tvNewsDescription = itemView.findViewById(R.id.tv_news_discription);
            ivImage = itemView.findViewById(R.id.iv_news_image);

        }
    }
}
