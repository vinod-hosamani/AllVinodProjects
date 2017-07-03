package bridgelabz.todoapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by bridgeit on 25/3/17.
 */

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    Pattern pattern,patern1;
    Matcher matcher,matcher2;
    /*String EMAIL_PATTERN="^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";*/
    String EMAIL_PATTERN="^(.+)@(.+)$";

    String Password_Pattern="\\d+";
    //EditText emailEditText,passwordEditText;
    AppCompatEditText editTextEmail,editTextPassword;
    AppCompatButton button;
    AppCompatTextView textView;
    AppCompatImageView imageView,imageView2;
    AppCompatTextView createAccount_Textview,ForgotTextview;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        editTextEmail=(AppCompatEditText)findViewById(R.id.EmailEditText);
        editTextPassword=(AppCompatEditText)findViewById(R.id.PasswordEditText);
        textView=(AppCompatTextView)findViewById(R.id.createAccount_Textview);
        button=(AppCompatButton)findViewById(R.id.loginbtn);
        imageView=(AppCompatImageView)findViewById(R.id.fb);
        imageView2=(AppCompatImageView)findViewById(R.id.google);
        ForgotTextview.setOnClickListener(this);
        createAccount_Textview.setOnClickListener(this);
    }

    public void Login(View view) {
        SharedPreferences sharedPreferences=getSharedPreferences("laxmi", Context.MODE_PRIVATE);
        String email=sharedPreferences.getString("email","value");
        String password=sharedPreferences.getString("password","000");
        pattern=Pattern.compile(EMAIL_PATTERN);
        matcher=pattern.matcher(editTextEmail.getText().toString());


        if(editTextEmail.getText().toString().length()==0){
            editTextEmail.setError("Email should not empty");
            editTextEmail.requestFocus();
            //editTextPassword.setError("Valid pswrd");
        }
        else if(matcher.matches()){

        }
        else{
            editTextEmail.setError("invalid Mail");
            editTextEmail.requestFocus();
        }
        patern1=Pattern.compile(Password_Pattern);
        matcher2=patern1.matcher(editTextPassword.getText().toString());
        if(editTextPassword.getText().toString().length()==0){
            editTextPassword.setError("Password should not empty");
            editTextPassword.requestFocus();
        }
        else if(matcher2.matches()){

            //Toast.makeText(this, "correct", Toast.LENGTH_SHORT).show();
            // editTextPassword.setError("correct");
        }
        else{
            editTextPassword.setError("invalid Password");
            editTextPassword.requestFocus();
        }

        if(editTextEmail.getText().toString().equalsIgnoreCase(email) && editTextPassword.getText().toString().equals(password+"")) {
            Toast.makeText(getApplicationContext(), "Login Successful", Toast.LENGTH_SHORT).show();
            Intent intent1 = new Intent(this, WelComeActivity.class);
            startActivity(intent1);
        }
        else {
            Toast.makeText(getApplicationContext(),"Enter Correct Details Or Register ",Toast.LENGTH_SHORT).show();

        }
    }

    /* private boolean isValidEmail(String email) {
         return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
     }
 */

    public void FacebookButton(View view){

    }
    public void GoogleButton(View view){

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.createAccount_Textview:
                Intent intent=new Intent(this,RegistrationActivity.class);
                startActivity(intent);
                break;
            case R.id.ForgotTextview:
                Intent intent2=new Intent(this,ResetpasswordActivity.class);
                startActivity(intent2);
                break;
        }

    }
}
