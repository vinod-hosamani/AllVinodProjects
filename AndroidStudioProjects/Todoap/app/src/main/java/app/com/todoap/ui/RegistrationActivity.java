package app.com.todoap.ui;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import app.com.todoap.R;
import app.com.todoap.baseclass.BaseActivity;

public class RegistrationActivity extends BaseActivity implements View.OnClickListener {

    EditText editTextRegisterName;
    EditText editTextRegisterEmail;
    EditText editTextRegisterPassword;
    EditText editTextRegisterMobileNo;
    Button RegisterButton;

    Matcher mMatcher;
    Pattern Pattern;
    String PASSWORD_PATTERN = " ^([a-zA-Z0-9@*#]{8,15})$ ";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        initView();

    }

    @Override
    public void initView() {
        editTextRegisterName = (EditText) findViewById(R.id.editTextRegname);
        editTextRegisterEmail = (EditText) findViewById(R.id.editTextRegemail);
        editTextRegisterPassword = (EditText) findViewById(R.id.editTextRegPass);
        editTextRegisterMobileNo = (EditText) findViewById(R.id.editTextRegmobileno);
        RegisterButton = (Button) findViewById(R.id.buttonRegister);
        setListenters();

    }

    @Override
    public void setListenters() {
        RegisterButton.setOnClickListener(this);


    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonRegister:
                validate();
                break;
        }
    }

    void validate() {
        boolean checkemail = false, checkname = false, checkpassword = false, checkMobile = false;

        Pattern mPattern = Pattern.compile(PASSWORD_PATTERN);
        mMatcher = mPattern.matcher(editTextRegisterPassword.getText().toString());

        SharedPreferences sh = getSharedPreferences("vinod", Context.MODE_PRIVATE);
        String name = editTextRegisterName.getText().toString();
        String email = editTextRegisterEmail.getText().toString();
        String password = editTextRegisterPassword.getText().toString();
        String Mobile = editTextRegisterMobileNo.getText().toString();


        if (name.isEmpty()) {
            editTextRegisterName.setError("name is empty plz enter the name");

        } else {
            checkname = true;
        }


        if (email.isEmpty()) {
            editTextRegisterEmail.setError("email is empty plz enter the email");

        } else if (!isValidEmail(email)) {
            editTextRegisterEmail.setError("wrong Email");
        } else {
            checkemail = true;
        }


        if (password.isEmpty()) {
            editTextRegisterPassword.setError("your password is empty");

        } else if (password.length() < 5) {
            editTextRegisterPassword.setError("plese enter more than 5 digit");

        } else {
            checkpassword = true;
        }

        if (Mobile.isEmpty()) {
            editTextRegisterMobileNo.setError("mob no is empty plz fill it");
        } else if (Mobile.length() < 10) {
            editTextRegisterMobileNo.setError("not a 10 digit number");
        } else {
            checkMobile = true;
        }


        if (checkname && checkMobile && checkemail && checkpassword)

        {
            SharedPreferences.Editor editor = sh.edit();
            editor.putString("Name", name);
            editor.putString("email", email);
            editor.putString("password", password);
            editor.putString("Mobile", Mobile);

            editor.commit();
            Toast.makeText(getApplicationContext(), "RegisterActivity completed", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
            finish();

        }
    }


    private boolean isValidEmail(String email) {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }


}
