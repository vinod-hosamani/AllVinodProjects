package bridgelabz.bridgelogin;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Register extends AppCompatActivity implements View.OnClickListener{
    EditText email;
    EditText pass;
    EditText phoneNo;
    EditText name;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        email = (EditText) findViewById(R.id.editText_regemail);
        pass = (EditText) findViewById(R.id.editText_regpass);
        name=(EditText)findViewById(R.id.editText_name);
        phoneNo=(EditText)findViewById(R.id.editText_phoneNo);
        btn = (Button) findViewById(R.id.button_reglog);
        btn.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.button_reglog:
                boolean checkName = false, checkMail = false, checkPassword = false, checkMobNo = false;
                String em = email.getText().toString();
                String pas = pass.getText().toString();
                String nm = name.getText().toString();
                String pn = phoneNo.getText().toString();

                if (nm.isEmpty()) {
                    name.setError("First name not entered");
                } else {
                    checkName = true;
                }


                if (em.isEmpty()) {
                    email.setError("Email should not empty");
                } else if (!isValidEmail(em)) {
                    email.setError("Invalid Email");
                } else {
                    checkMail = true;
                }


                if (pn.isEmpty()) {
                    phoneNo.setError("Enter your mobile number");
                } else {
                    checkMobNo = true;
                }

                if (pas.length() == 0) {
                    pass.setError("Password should not blank");
                } else if (pas.length() < 4) {
                    pass.setError("The password should contain at least 4 numbers");
                } else {
                    checkPassword = true;
                }

                if (checkName && checkMail && checkPassword & checkMobNo) {
                    SharedPreferences sharedPreferences = getSharedPreferences("vinod", Context.MODE_PRIVATE);
                    SharedPreferences.Editor sEditor = sharedPreferences.edit();

                    sEditor.putString("email", email.getText().toString());
                    sEditor.putString("password", pass.getText().toString());
                    sEditor.putString("name", name.getText().toString());
                    sEditor.putString("phoneNumber", phoneNo.getText().toString());
                    sEditor.commit();
                    Toast.makeText(Register.this, "Registration Successful", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(this, LoginActivity.class);
                    startActivity(intent);

                    break;
                }
        }
    }
    public static boolean isValidEmail(String email) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
}