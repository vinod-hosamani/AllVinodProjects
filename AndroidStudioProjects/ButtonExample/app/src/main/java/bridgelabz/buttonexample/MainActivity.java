package bridgelabz.buttonexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText e1,e2;
    private Button buttonSum;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListenerOnButton();

    }

    public void addListenerOnButton()
    {
        e1=(EditText)findViewById(R.id.editText1);
        e2=(EditText)findViewById(R.id.editText2);
        buttonSum=(Button)findViewById(R.id.button1);

        buttonSum.setOnClickListener(new OnClickListener()
        {

            @Override
            public void onClick(View view)
             {
                String value1=e1.getText().toString();
                String value2=e2.getText().toString();
                int a=Integer.parseInt(value1);
                int b=Integer.parseInt(value2);
                 int sum=a+b;
                Toast.makeText(getApplicationContext(),String.valueOf(sum),Toast.LENGTH_LONG).show();
            }

        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menutest,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.bluetoth:
                Toast.makeText(getApplicationContext(), "bluetooth", Toast.LENGTH_LONG).show();
                break;
            case R.id.share:
                Toast.makeText(MainActivity.this, "share", Toast.LENGTH_SHORT).show();
                break;
            case R.id.gmail:
                Toast.makeText(MainActivity.this, "gmail", Toast.LENGTH_SHORT).show();
                break;
            case R.id.crome:
                Toast.makeText(MainActivity.this, "crome", Toast.LENGTH_SHORT).show();
                break;
            case R.id.wifi:
                Toast.makeText(MainActivity.this, "wifi", Toast.LENGTH_SHORT).show();
                break;
        }
        return false;
    }
}
