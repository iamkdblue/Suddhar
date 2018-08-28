package app.kdblue.com.creditsuddhar.fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import app.kdblue.com.creditsuddhar.R;
import app.kdblue.com.creditsuddhar.activity.MainActivity;
import app.kdblue.com.creditsuddhar.activity.SplashActivity;
import app.kdblue.com.creditsuddhar.adapter.ArticleAdapter;
import app.kdblue.com.creditsuddhar.db.UserDataBase;
import app.kdblue.com.creditsuddhar.model.Article;

/**
 * A simple {@link Fragment} subclass.
 */
public class ArticlesFragment extends Fragment {

    private RecyclerView recyclerView;
    private ArticleAdapter articleAdapter;
    private UserDataBase userDataBase;

    public ArticlesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_articles, container, false);
        recyclerView = view.findViewById(R.id.rvArticle);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        userDataBase = UserDataBase.getAppDatabase(getActivity());

        List<Article> articleList = userDataBase.userDao().getAllArticle();

        articleAdapter = new ArticleAdapter(articleList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(articleAdapter);
    }
}
