package bridgelabz.addjavatp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
  EditText e1,e2;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        clickListener();
    }

    public void clickListener(){

        e1=(EditText)findViewById(R.id.textView_n1);
        e2=(EditText)findViewById(R.id.textView_n2);
        btn=(Button) findViewById(R.id.button_sum);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String v1=e1.getText().toString();
                String v2=e2.getText().toString();
                int a=Integer.parseInt(v1);
                int b=Integer.parseInt(v2);
                int sum=a+b;

                Toast.makeText(getApplicationContext(),String.valueOf(sum),Toast.LENGTH_LONG).show();



            }
        });

    }
}
