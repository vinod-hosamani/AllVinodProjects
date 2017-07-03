package bridgelabz.simpleloginapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private static EditText username;
    private static EditText password;
    private static TextView attempts;
    private static Button login_btn;
    int attempts_counter=5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        LoginButton();
    }
    public void LoginButton(){

        username=(EditText)findViewById(R.id.editText_user);
        password=(EditText)findViewById(R.id.editText_password);
        attempts=(TextView) findViewById(R.id.textView_attempts_count);
        login_btn=(Button)findViewById(R.id.button_login);

        attempts.setText(Integer.toString(attempts_counter));
        login_btn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(username.getText().toString().equals("user") &&
                                username.getText().toString().equals("user") )
                        {
                            Toast.makeText(LoginActivity.this,"user and password is correct",
                                    Toast.LENGTH_SHORT).show();
                            Intent intent=new Intent(getApplicationContext(),User.class);
                            startActivity(intent);
                        }
                        else
                        {
                            Toast.makeText(LoginActivity.this,"user and password is not  correct",
                                    Toast.LENGTH_SHORT).show();
                            attempts_counter--;
                            attempts.setText(Integer.toString(attempts_counter));

                            if(attempts_counter==0)
                            {
                                login_btn.setEnabled(false);
                            }
                        }
                    }
                }
        );
    }
}
