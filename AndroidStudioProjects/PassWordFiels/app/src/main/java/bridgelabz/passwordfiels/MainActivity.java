package bridgelabz.passwordfiels;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
     private EditText password;
     private Button buttonsbm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        password=(EditText)findViewById(R.id.editText);
        buttonsbm=(Button)findViewById((R.id.button));
    }
   public void test(View view){
      String msg=password.getText().toString();
       Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_SHORT).show();
   }
}
