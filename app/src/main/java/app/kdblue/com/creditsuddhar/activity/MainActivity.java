package app.kdblue.com.creditsuddhar.activity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;

import app.kdblue.com.creditsuddhar.R;
import app.kdblue.com.creditsuddhar.custom.NoSwipePager;
import app.kdblue.com.creditsuddhar.custom.ViewPagerAdapter;
import app.kdblue.com.creditsuddhar.fragment.ArticlesFragment;
import app.kdblue.com.creditsuddhar.fragment.CreditReportFragment;
import app.kdblue.com.creditsuddhar.fragment.DashBoardFragment;
import app.kdblue.com.creditsuddhar.fragment.MyAccountFragment;

public class MainActivity extends AppCompatActivity {


    private final String TAG = "MAINACTIVITY";
    private DashBoardFragment dashBoardFragment;
    private CreditReportFragment creditReportFragment;
    private ArticlesFragment articlesFragment;
    private MyAccountFragment myAccountFragment;
    private AHBottomNavigation bottomNavigation;
    private NoSwipePager viewPager;
    private AHBottomNavigationItem navDashBoard,navCreditReport,navArticle,navMyAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = findViewById(R.id.viewpager);
        viewPager.setPagingEnabled(false);
        bottomNavigation = findViewById(R.id.bottom_navigation);

        setUpBottomNavigation();
    }

    private void setUpBottomNavigation() {

         navDashBoard =
                new AHBottomNavigationItem(R.string.text_dashboard,
                        R.drawable.ic_dashboard, R.color.grey);

         navCreditReport =
                new AHBottomNavigationItem(R.string.text_credit_report,
                        R.drawable.ic_credit_report, R.color.grey);

         navArticle =
                new AHBottomNavigationItem(R.string.text_article,
                        R.drawable.ic_article, R.color.grey);

         navMyAccount =
                new AHBottomNavigationItem(R.string.text_my_account,
                        R.drawable.ic_my_account, R.color.grey);

        bottomNavigation.addItem(navDashBoard);
        bottomNavigation.addItem(navCreditReport);
        bottomNavigation.addItem(navArticle);
        bottomNavigation.addItem(navMyAccount);

        bottomNavigation.setTitleState(AHBottomNavigation.TitleState.ALWAYS_SHOW);

        bottomNavigation.setAccentColor(getResources().getColor(R.color.green));
        bottomNavigation.setInactiveColor(getResources().getColor(R.color.grey));

        bottomNavigation.setOnTabSelectedListener(new AHBottomNavigation.OnTabSelectedListener() {
            @Override
            public boolean onTabSelected(int position, boolean wasSelected) {
                if (!wasSelected)
                    viewPager.setCurrentItem(position);

                switch (position) {
                    case 0:
                        getSupportActionBar().setTitle("DashBoard");
                        break;
                    case 1:
                        getSupportActionBar().setTitle("Credit Report");
                        break;
                    case 2:
                        getSupportActionBar().setTitle("Article");
                        break;
                    case 3:
                        getSupportActionBar().setTitle("Account");
                        break;
                }
                return true;
            }
        });

        setupViewPager(viewPager);

        //bottomNavigationView.setSelectedItemId(R.id.action_dashboard);
        bottomNavigation.setCurrentItem(0);
    }


    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        dashBoardFragment = new DashBoardFragment();
        creditReportFragment = new CreditReportFragment();
        articlesFragment = new ArticlesFragment();
        myAccountFragment = new MyAccountFragment();

        adapter.addFragment(dashBoardFragment);
        adapter.addFragment(creditReportFragment);
        adapter.addFragment(articlesFragment);
        adapter.addFragment(myAccountFragment);
        viewPager.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.action_notification){
            // do something
        }
        return super.onOptionsItemSelected(item);
    }

}
