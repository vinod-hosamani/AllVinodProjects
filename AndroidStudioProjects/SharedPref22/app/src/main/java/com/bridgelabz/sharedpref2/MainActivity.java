package com.bridgelabz.sharedpref2;

import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

public class MainActivity extends Activity {

    AlertDialogManager alert = new AlertDialogManager();

    SessionManager session;

    Button btnLogout;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        session = new SessionManager(getApplicationContext());

        TextView lblName = (TextView) findViewById(R.id.lblName);
        TextView lblEmail = (TextView) findViewById(R.id.lblEmail);

        btnLogout = (Button) findViewById(R.id.btnLogout);

        Toast.makeText(getApplicationContext(), "User Login Status: " + session.isLoggedIn(), Toast.LENGTH_LONG).show();

        session.checkLogin();

        HashMap<String, String> user = session.getUserDetails();

        String name = user.get(SessionManager.KEY_NAME);

        String email = user.get(SessionManager.KEY_EMAIL);

        lblName.setText(Html.fromHtml("Name: <b>" + name + "</b>"));
        lblEmail.setText(Html.fromHtml("Email: <b>" + email + "</b>"));


        btnLogout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                session.logoutUser();
            }
        });
    }

}