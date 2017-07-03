package app.com.addvin2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  {
    EditText e1,e2;
    TextView v;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        onButtonClick();

    }

    public void onButtonClick(){
        e1=(EditText)findViewById(R.id.editTextNumber1);
        e2=(EditText)findViewById(R.id.editTextNumber2);
        v=(TextView)findViewById(R.id.textViewResult);
        btn=(Button) findViewById(R.id.buttonSubmit);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a=Integer.parseInt(e1.getText().toString());
                int b=Integer.parseInt(e2.getText().toString());
                int sum=a+b;

                v.setText(String.valueOf(sum));
                Toast.makeText(getApplicationContext(),String.valueOf(sum),Toast.LENGTH_LONG).show();


            }
        });
    }
}
