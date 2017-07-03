package com.bridgelabz.sharedpref2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity {

	EditText txtUsername, txtPassword;
	Button btnLogin;
	AlertDialogManager alert = new AlertDialogManager();
	SessionManager session;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login); 
        

        session = new SessionManager(getApplicationContext());
        txtUsername = (EditText) findViewById(R.id.txtUsername);
        txtPassword = (EditText) findViewById(R.id.txtPassword); 

		Toast.makeText(getApplicationContext(), "User Login Status: " + session.isLoggedIn(), Toast.LENGTH_LONG).show();

        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0)
			{
				String username = txtUsername.getText().toString();
				String password = txtPassword.getText().toString();
				if(username.trim().length() > 0 && password.trim().length() > 0)
				{
					if(username.equals("test") && password.equals("test"))
					{
						session.createLoginSession("Android Hive", "anroidhive@gmail.com");
						Intent i = new Intent(getApplicationContext(), MainActivity.class);
						startActivity(i);
						finish();
						
					}
					else
					{
						alert.showAlertDialog(LoginActivity.this, "Login failed..", "Username/Password is incorrect", false);
					}				
				}
				else
				{
					alert.showAlertDialog(LoginActivity.this, "Login failed..", "Please enter username and password", false);
				}
				
			}
		});
    }        
}