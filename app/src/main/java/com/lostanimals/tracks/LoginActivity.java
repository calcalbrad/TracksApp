package com.lostanimals.tracks;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import com.lostanimals.tracks.utils.PreferencesUtility;
import com.lostanimals.tracks.utils.ServerManager;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity {

    static final boolean DEV_MODE = true;

    private ServerManager mServerTask = null;
    private PreferencesUtility mPreferencesUtility;
    private AutoCompleteTextView mEmailView;
    private EditText mPasswordView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mPreferencesUtility = new PreferencesUtility(sharedPreferences);

        if (!DEV_MODE) {
            if (mPreferencesUtility.getUserInfo() != null) {
//                Intent feedIntent = new Intent(getApplicationContext(), FeedActivity.class);
//                startActivity(feedIntent);
                Intent LogoutIntent = new Intent(getApplicationContext(), LogoutActivity.class);
                startActivity(LogoutIntent);
                finish();
            }
        }

        setContentView(R.layout.activity_login);

        // Set up the login form.
        mEmailView = findViewById(R.id.login_username);
        mPasswordView = findViewById(R.id.login_password);

        Button mSignInBtn = findViewById(R.id.login_btn);
        mSignInBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptLogin();
            }
        });

        Button mRegisterBtn = findViewById(R.id.login_register_btn);
        mRegisterBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {startActivity(new Intent(getApplicationContext(), RegisterActivity.class));    }
        });
    }

    /**
     * Attempts to sign in or register the account specified by the login form.
     * If there are form errors (invalid email, missing fields, etc.), the
     * errors are presented and no actual login attempt is made.
     */
    private void attemptLogin() {
        // Reset errors.
        mEmailView.setError(null);
        mPasswordView.setError(null);

        // Store values at the time of the login attempt.
        String email = mEmailView.getText().toString();
        String password = mPasswordView.getText().toString();

        boolean cancel = false;
        View focusView = null;

        // Check for a valid password, if the user entered one.
        if (TextUtils.isEmpty(password)) {
            mPasswordView.setError(getString(R.string.error_field_required));
            focusView = mPasswordView;
            cancel = true;
        }

        if (TextUtils.isEmpty(email)) {
            mEmailView.setError(getString(R.string.error_field_required));
            focusView = mEmailView;
            cancel = true;
        }

        if (cancel) {
            focusView.requestFocus();
        } else {
            mServerTask = new ServerManager(this);
            mServerTask.setPreferencesUtility(mPreferencesUtility);
            mServerTask.execute("login", email, password);
        }
    }
}
