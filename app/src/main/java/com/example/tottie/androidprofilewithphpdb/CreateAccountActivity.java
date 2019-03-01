package com.example.tottie.androidprofilewithphpdb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CreateAccountActivity extends AppCompatActivity {

    //    Declarations-------------------------------------------------------------------------------------------------------------
    EditText createUsername, createPassword, createName, createMiddleName,createLastname, createCompany, createCompanyAdd,
            createContact, createEmail, createRetypePassword;
    myConnection myBackgound;
//    End----------------------------------------------------------------------------------------------------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
//    Initialization-----------------------------------------------------------------------------------------------------------
        createUsername = (EditText) findViewById(R.id.eTxtCreateUsername);
        createPassword = (EditText) findViewById(R.id.eTxtCreatePassword);
        createRetypePassword = (EditText) findViewById(R.id.eTxtCreateRetypePassword);
        createName = (EditText) findViewById(R.id.eTxtCreateName);
        createMiddleName = (EditText) findViewById(R.id.eTxtCreateMiddleName);
        createLastname = (EditText) findViewById(R.id.eTxtCreateLastname);
        createCompany = (EditText) findViewById(R.id.eTxtCreateCompany);
        createCompanyAdd = (EditText) findViewById(R.id.eTxtCreateAddress);
        createContact = (EditText) findViewById(R.id.eTxtCreateContact);
        createEmail = (EditText) findViewById(R.id.eTxtCreateEmail);
//    End----------------------------------------------------------------------------------------------------------------------
    }

    public void signupBtn(View view){
        String myName = createName.getText().toString();
        String myMiddleName = createMiddleName.getText().toString();
        String myLastName = createLastname.getText().toString();
        String myCompany = createCompany.getText().toString();
        String myCompanyAdd = createCompanyAdd.getText().toString();
        String myContact = createContact.getText().toString();
        String myEmail = createEmail.getText().toString();
        String myUsername = createUsername.getText().toString();
        String myPassword = createPassword.getText().toString();
        String myRetyped = createRetypePassword.getText().toString();

        if(myRetyped.equals(myPassword)){

            myConnection myBackground = new myConnection(this);
            if(TextUtils.isEmpty(myName)){
                createName.setError("Required!");
            }
            if(TextUtils.isEmpty(myCompanyAdd)){
                createCompanyAdd.setError("Required!");
            }
            if(TextUtils.isEmpty(myRetyped)){
                createRetypePassword.setError("Required!");
            }
            if(TextUtils.isEmpty(myEmail)){
                createEmail.setError("Required!");
            }
            if(TextUtils.isEmpty(myLastName)){
                createLastname.setError("Required!");
            }
            if(TextUtils.isEmpty(myCompany)){
                createCompany.setError("Required!");
            }
            if(TextUtils.isEmpty(myContact)){
                createContact.setError("Required!");
            }
            if(TextUtils.isEmpty(myUsername)){
                createUsername.setError("Required!");
            }
            if(TextUtils.isEmpty(myPassword)){
                createPassword.setError("Required!");
            }
            if(!TextUtils.isEmpty(myName) && !TextUtils.isEmpty(myLastName) && !TextUtils.isEmpty(myCompany) && !TextUtils.isEmpty(myContact) && !TextUtils.isEmpty(myUsername) && !TextUtils.isEmpty(myPassword)){
                myBackground.execute("signup.php", myName, myMiddleName, myLastName, myCompany, myCompanyAdd,
                        myContact, myEmail, myUsername, myPassword);
            }
        }else{
            createPassword.setText("");
            createRetypePassword.setText("");
            createPassword.setHint("Password do not match!");
            createRetypePassword.setHint("Password do not match!");
            createPassword.setHintTextColor(getResources().getColor(R.color.colorAccent));
            createRetypePassword.setHintTextColor(getResources().getColor(R.color.colorAccent));
        }
    }
}
