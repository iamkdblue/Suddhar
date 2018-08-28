package app.kdblue.com.creditsuddhar.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

import com.yarolegovich.lovelydialog.LovelyProgressDialog;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import app.kdblue.com.creditsuddhar.R;
import app.kdblue.com.creditsuddhar.db.UserDataBase;
import app.kdblue.com.creditsuddhar.util.SavePref;

public class LoginActivity extends AppCompatActivity {

    private static String TAG = "LoginActivity";
    FloatingActionButton fab;
    private final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]", Pattern.CASE_INSENSITIVE);
    private EditText etUsername, etPassword;
    private LovelyProgressDialog waitingDialog;

    private boolean firstTimeAccess;

    private UserDataBase userDataBase;

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);
        fab = (FloatingActionButton) findViewById(R.id.fab);
        etUsername = (EditText) findViewById(R.id.et_username);
        etPassword = (EditText) findViewById(R.id.et_password);
        firstTimeAccess = true;
        init();
    }


    /**
     * Khởi tạo các thành phần cần thiết cho việc quản lý đăng nhập
     */
    private void init() {

        // waitingDialog = new LovelyProgressDialog(this).setCancelable(false);
        userDataBase = UserDataBase.getAppDatabase(LoginActivity.this);

    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    public void clickLogin(View view) {
        String username = etUsername.getText().toString();
        String password = etPassword.getText().toString();
        if (validate(username, password)) {
            signIn(username, password);
        } else {
            Toast.makeText(this, "Invalid email or empty password", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        setResult(RESULT_CANCELED, null);
        finish();
    }

    private boolean validate(String emailStr, String password) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return (password.length() > 0 || password.equals(";")) && matcher.find();
    }

    void signIn(String userName, String userPassword) {
        int userId = userDataBase.userDao().getLoginUserId(userName, userPassword);
        if (userId!=0) {
            SavePref savePref = new SavePref(LoginActivity.this);
            savePref.saveLoginDetails(etUsername.getText().toString(), etPassword.getText().toString());
            savePref.saveUserId(userId);

            startActivity(new Intent(LoginActivity.this,MainActivity.class));
            overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
            LoginActivity.this.finish();

        } else {
            Toast.makeText(this, "Username or Password is Wrong !", Toast.LENGTH_SHORT).show();
        }
    }

}
