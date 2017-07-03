package app.com.addvin;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText e1,e2;
    TextView v;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        onButtonListner();
    }

    public void onButtonListner(){

        e1=(EditText)findViewById(R.id.editTextnum1);
        e2=(EditText)findViewById(R.id.editTextnum2);
        v=(TextView)findViewById(R.id.textViewResult);
        btn=(Button)findViewById(R.id.buttonsubmit);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String v1=e1.getText().toString();
                String v2=e2.getText().toString();
                int a=Integer.parseInt(v1);
                int b=Integer.parseInt(v2);
                int sum=a+b;

               Toast.makeText(getApplicationContext(), String.valueOf(sum),Toast.LENGTH_LONG).show();
              v.setText(String.valueOf(sum));


            }
        });
    }
}
