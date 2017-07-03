package app.com.todoap.ui;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import app.com.todoap.R;
import app.com.todoap.baseclass.BaseActivity;
import app.com.todoap.utils.Constants;

public class  LoginActivity extends BaseActivity implements View.OnClickListener {

    EditText editTextloginEmail;
    EditText editTextloginPassword;
    Button buttonloginLog;
    Button buttonLogCreateAccount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }

    @Override
    public void initView() {
        editTextloginEmail=(EditText)findViewById(R.id.editTextLoginemail);
        editTextloginPassword=(EditText)findViewById(R.id.editTextloginpassword);
        buttonloginLog=(Button)findViewById(R.id.button_Login);
        buttonLogCreateAccount=(Button)findViewById(R.id.buttonLogCreateAcc);
        setListenters();

    }

    @Override
    public void setListenters() {
        buttonloginLog.setOnClickListener(this);
        buttonLogCreateAccount.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button_Login:

                SharedPreferences sharedPreferences=getSharedPreferences(Constants.keys, Context.MODE_PRIVATE);
                String EmailLogin=sharedPreferences.getString("email",Constants.values);
                String passwordLogin=sharedPreferences.getString("password",Constants.values);

                    if(editTextloginEmail.getText().toString().equalsIgnoreCase(EmailLogin)&&
                            editTextloginPassword.getText().toString().equalsIgnoreCase(passwordLogin))
                    {
                        Toast.makeText(LoginActivity.this,"login successfull",Toast.LENGTH_LONG).show();
                        Intent intent=new Intent(LoginActivity.this,WelcomeActivity.class);
                        startActivity(intent);
                    }
                    else
                    {
                        Toast.makeText(LoginActivity.this,"invalid emailID or password",Toast.LENGTH_LONG).show();
                    }
                    break;
            case R.id.buttonLogCreateAcc:
                Intent intent=new Intent(LoginActivity.this,RegistrationActivity.class);
                startActivity(intent);
                break;
        }

    }
}
