package bridgelabz.todoapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.view.View;
import android.widget.Toast;


/**
 * Created by bridgeit on 25/3/17.
 */

public class RegistrationActivity extends AppCompatActivity implements View.OnClickListener {
    AppCompatEditText edittextName,edittextemail,edittextpswrd,edittextmobNo;
    AppCompatButton buttonSave;

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        buttonSave=(AppCompatButton)findViewById(R.id.save_button);
        edittextName=(AppCompatEditText)findViewById(R.id.EditTExtName);
        edittextemail=(AppCompatEditText)findViewById(R.id.EditTextEmail);
        edittextpswrd=(AppCompatEditText)findViewById(R.id.EdiTextPassword);
        edittextmobNo=(AppCompatEditText)findViewById(R.id.mobilenumber);
        buttonSave.setOnClickListener(this);
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.save_button:
                boolean checkName = false, checkMail = false, checkPassword = false, checkMobNo = false;
                String Name = edittextName.getText().toString();
                String Email = edittextemail.getText().toString();
                String Password = edittextpswrd.getText().toString();
                //Log.i("", "Save: "+Password);
                String MobileNo = edittextmobNo.getText().toString();
                if (Name.isEmpty()) {
                    edittextName.setError("First name not entered");
                } else {
                    checkName = true;
                }

                if (Email.isEmpty()) {
                    edittextemail.setError("Email should not empty");
                } else if (!isValidEmail(Email)) {
                    edittextemail.setError("Invalid Email");
                } else {
                    checkMail = true;
                }

                if (MobileNo.isEmpty()) {
                    edittextmobNo.setError("Enter your mobile number");
                } else {
                    checkMobNo = true;
                }

                if (edittextpswrd.getText().length() == 0) {
                    edittextpswrd.setError("Password should not blank");
                } else if (edittextpswrd.getText().length() < 4) {
                    edittextpswrd.setError("The password should contain at least 4 numbers");
                } else {
                    checkPassword = true;
                }

                if (checkName && checkMail && checkMobNo && checkPassword) {
                    SharedPreferences sharedPreferences = getSharedPreferences("laxmi", Context.MODE_PRIVATE);//MODE_PVT-file can access by calling the apps
                    SharedPreferences.Editor shEditor = sharedPreferences.edit();//Saving data using SharedPreference.Editor class
                    shEditor.putString("Username", edittextName.getText().toString());
                    shEditor.putString("email", edittextemail.getText().toString());
                    shEditor.putString("password", edittextpswrd.getText().toString() + "");
                    shEditor.putString("mobileno", edittextmobNo.getText().toString());
                    shEditor.commit();
                    Toast.makeText(getApplicationContext(), "Registration Successful", Toast.LENGTH_SHORT).show();
                    //Toast.makeText(Registration.this, "Data submitted Succcessfully..", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(RegistrationActivity.this, LoginActivity.class);
                    startActivity(i);
                    finish();
                }
                break;
        }
    }
        public static boolean isValidEmail(String email) {
            return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
        }
    }

