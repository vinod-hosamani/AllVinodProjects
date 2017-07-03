package bridgelabz.a18eventhandling;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button v=(Button)findViewById(R.id.vinodButton);

        v.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        TextView vin=(TextView)findViewById(R.id.vinod);
                        vin.setText("good job viond");
                    }
                }
        );
    }
}
