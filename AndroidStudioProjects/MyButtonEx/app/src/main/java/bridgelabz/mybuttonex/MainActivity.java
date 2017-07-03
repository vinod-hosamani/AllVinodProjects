package bridgelabz.mybuttonex;

import android.app.Application;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
  EditText e1,e2;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addOnClickListner();
    }
    public void addOnClickListner()
    {
        e1=(EditText)findViewById(R.id.editText);
        e2=(EditText)findViewById(R.id.editText2);
        b1=(Button)findViewById(R.id.button);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String v1=e1.getText().toString();
                String v2=e2.getText().toString();
                int num1=Integer.parseInt(v1);
                int num2=Integer.parseInt(v2);
                int sum=num1+num2;
                Toast.makeText(getApplicationContext(),String.valueOf(sum),Toast.LENGTH_LONG).show();
            }
        });
    }
    public boolean onCreateOptionMenu(Menu menu)
    {
         getMenuInflater().inflate(R.menu.menutest,menu);
        return true;
    }
}
