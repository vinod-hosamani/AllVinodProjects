package bridgelabz.a20moreeventhandling;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn=(Button)findViewById(R.id.button_submit);

        btn.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        TextView vin=(TextView)findViewById(R.id.textView_pramod);
                        vin.setText("hi good job pramod");
                    }
                }
        );
        btn.setOnLongClickListener(
                new Button.OnLongClickListener(){
                    public boolean onLongClick(View v){
                        TextView vin=(TextView)findViewById(R.id.textView_pramod);
                        vin.setText("ya this is long press");
                        return true;
                    }
                }
        );
    }
}
