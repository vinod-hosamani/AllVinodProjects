package bridgelabz.intentexa;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
{
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //final EditText editText1=(EditText)findViewById(R.id.editText1);
        Button button1=(Button)findViewById(R.id.button1);

        button1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v)
            {
                //String url=editText1.getText().toString();
                Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.google.com/"));
                startActivity(intent);
            }
        });
    }
}
