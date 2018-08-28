package app.kdblue.com.creditsuddhar.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

import app.kdblue.com.creditsuddhar.R;
import app.kdblue.com.creditsuddhar.util.SavePref;

public class SplashActivity extends AppCompatActivity {

    private static final long SPLASH_DISPLAY_LENGTH = 1000;
    private SavePref savePref;
    private Intent mainIntent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);
        savePref = new SavePref(SplashActivity.this);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                if (savePref.isUserLogedOut()) {
                    mainIntent = new Intent(SplashActivity.this, LoginActivity.class);
                    SplashActivity.this.startActivity(mainIntent);
                    overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
                    SplashActivity.this.finish();

                } else {

                    mainIntent = new Intent(SplashActivity.this, MainActivity.class);
                    SplashActivity.this.startActivity(mainIntent);
                    overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
                    SplashActivity.this.finish();
                }

            }
        }, SPLASH_DISPLAY_LENGTH);

    }
}
