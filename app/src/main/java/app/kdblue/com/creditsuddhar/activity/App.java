package app.kdblue.com.creditsuddhar.activity;

import android.app.Application;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.ByteArrayOutputStream;

import app.kdblue.com.creditsuddhar.R;
import app.kdblue.com.creditsuddhar.db.UserDataBase;
import app.kdblue.com.creditsuddhar.model.Article;
import app.kdblue.com.creditsuddhar.model.LoginUser;
import app.kdblue.com.creditsuddhar.model.UserDetail;

public class App extends Application {

    private UserDataBase userDataBase;
    private LoginUser loginUser;
    private Article article;
    private UserDetail userDetail;

    @Override
    public void onCreate() {
        super.onCreate();
        userDataBase = UserDataBase.getAppDatabase(App.this);

        if (!userDataBase.userDao().isThereAnyData()) {

            //Insert User Login
            loginUser = new LoginUser("1", "123");
            userDataBase.userDao().insertUserLogin(loginUser);

            loginUser = new LoginUser("2", "123");
            userDataBase.userDao().insertUserLogin(loginUser);

            loginUser = new LoginUser("3", "123");
            userDataBase.userDao().insertUserLogin(loginUser);

            loginUser = new LoginUser("4", "123");
            userDataBase.userDao().insertUserLogin(loginUser);


            //Insert User Details
            userDetail = new UserDetail("FirstUser","First@gmail.com","1111","A1111","Mumbai");
            userDataBase.userDao().insertUserDetail(userDetail);

            userDetail = new UserDetail("SecondUser","Second@gmail.com","2222","A2222","Thana");
            userDataBase.userDao().insertUserDetail(userDetail);

            userDetail = new UserDetail("ThirdUser","Third@gmail.com","3333","A3333","Nagpur");
            userDataBase.userDao().insertUserDetail(userDetail);

            userDetail = new UserDetail("FourthUser","Fourth@gmail.com","4444","A4444","Kohlapur");
            userDataBase.userDao().insertUserDetail(userDetail);

            Bitmap src = BitmapFactory.decodeResource(getResources(),R.drawable.news_one);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            src.compress(Bitmap.CompressFormat.PNG, 100, baos);
            byte[] data =null; //baos.toByteArray();
            //String encodedImage = Base64.encodeToString(data, Base64.DEFAULT);
            article = new Article("More than 40 smallcaps rose 10-40% in a week, but experts are still cautious","If you look at a 3-6 months period, stocks will still look at prices way lower than earlier, said Pritam Deuskar, Fund Manager, Bonanza Portfolio.",data);
            userDataBase.userDao().insertArticle(article);
            article = new Article("Hold on to equities! It is time for a pause, but buy the dip for a target of 12,200","In the worst case scenario, correction may get extended up to 11,200 kinds of levels on the downside before resuming its up move",data);
            userDataBase.userDao().insertArticle(article);
            article = new Article("Indian ADRs: Tata Motors slips 3%, ICICI Bank, HDFC Bank down 2%","Indian ADRs ended lower on Friday. Dr Reddy's Laboratories shed 1.26 percent and Wipro shed 0.59 percent.",data);
            userDataBase.userDao().insertArticle(article);
            article = new Article("Jet Airways: Cost-cutting measures may not be good enough","Looking at pro forma quarterly numbers for next year, incorporating some of the strategic steps by Jet Airways, suggests operating profit may not be good enough and interest coverage may remain negative.",data);
            userDataBase.userDao().insertArticle(article);
            article = new Article("Buy Gulf Oil Lubricants; target of Rs 1027: HDFC Securities","HDFC Securities is bullish on Gulf Oil Lubricants has recommended buy rating on the stock with a target price of Rs 1027 in its research report dated 09 Aug 2018.",data);
            userDataBase.userDao().insertArticle(article);
            article = new Article("Buy JMC Projects; target of Rs 844: HDFC Securities","HDFC Securities is bullish on JMC Projects has recommended buy rating on the stock with a target price of Rs 844 in its research report dated 08 Aug 2018.",data);
            userDataBase.userDao().insertArticle(article);
        }
    }
}
