package com.example.tottie.androidprofilewithphpdb;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import android.widget.Toast;
import android.widget.Toolbar;

public class LoginActivity extends AppCompatActivity {

    //    Declarations-------------------------------------------------------------------------------------------------------------
    EditText username, password;
//    End----------------------------------------------------------------------------------------------------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
//    Initialization-----------------------------------------------------------------------------------------------------------
        username = (EditText) findViewById(R.id.eTxtUsername);
        password = (EditText) findViewById(R.id.eTxtPassword);
//    End----------------------------------------------------------------------------------------------------------------------
    }

    //     Login button------------------------------------------------------------------------------------------------------------
    public void loginBtn(View view) {
        String myUsername = username.getText().toString();
        String myPassword = password.getText().toString();
        myConnection myBackground = new myConnection(this);
        if(TextUtils.isEmpty(myUsername)){
            username.setError("Required!" );
        }
        if(TextUtils.isEmpty(myPassword)){
            password.setError("Required!" );
        }
        if (!TextUtils.isEmpty(myUsername) && !TextUtils.isEmpty(myPassword)){
            myBackground.execute("login.php", myUsername, myPassword);
        }
    }
//    End----------------------------------------------------------------------------------------------------------------------

    //     Signup activity button------------------------------------------------------------------------------------------------------------
    public void signUpActivity(View view) {
        Intent intent = new Intent (this, CreateAccountActivity.class);
        startActivity(intent);
    }
//    End----------------------------------------------------------------------------------------------------------------------

}
