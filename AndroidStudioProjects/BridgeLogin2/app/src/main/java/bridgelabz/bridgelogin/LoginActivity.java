package bridgelabz.bridgelogin;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    Pattern pattern,patern1;
    Matcher matcher,matcher2;

    String EMAIL_PATTERN="^(.+)@(.+)$";

    String Password_Pattern="\\d+";
     public static EditText emaill,passwordd;
      public static Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        emaill=(EditText)findViewById(R.id.editText_email);
        passwordd=(EditText)findViewById(R.id.editText_pass);
        btn=(Button)findViewById(R.id.button_login);
        btn.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button_login:
                SharedPreferences sharedPreferences = getSharedPreferences("vinod", Context.MODE_PRIVATE);
                final String email=sharedPreferences.getString("email","s");
                final String password=sharedPreferences.getString("password","s");
                pattern=Pattern.compile(EMAIL_PATTERN);
                matcher=pattern.matcher(emaill.getText().toString());

                if(emaill.getText().toString().length()==0){
                    emaill.setError("Email should not empty");
                    emaill.requestFocus();
                    //editTextPassword.setError("Valid pswrd");
                }
                else if(matcher.matches()){

                }
                else{
                    emaill.setError("invalid Mail");
                    emaill.requestFocus();
                }
                patern1=Pattern.compile(Password_Pattern);
                matcher2=patern1.matcher(passwordd.getText().toString());
                if(passwordd.getText().toString().length()==0){
                    passwordd.setError("Password should not empty");
                    passwordd.requestFocus();
                }
                else if(matcher2.matches()){

                    //Toast.makeText(this, "correct", Toast.LENGTH_SHORT).show();
                    // editTextPassword.setError("correct");
                }
                else{
                    passwordd.setError("invalid Password");
                    passwordd.requestFocus();
                }

                if(emaill.getText().toString().equalsIgnoreCase(email) && passwordd.getText().toString().equals(password+""))
                {
                    Toast.makeText(getApplicationContext(), "Login Successful", Toast.LENGTH_SHORT).show();
                    Intent intent1 = new Intent(this, Welcome.class);
                    startActivity(intent1);
                }
                else {
                    Toast.makeText(getApplicationContext(),"Enter Correct Details Or Register ",Toast.LENGTH_SHORT).show();

                }
                break;
        }
    }
}


