package bridgelabz.a13amakingbutton;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        //layout
        RelativeLayout r=new RelativeLayout(this);
        r.setBackgroundColor(Color.GREEN);
        //Button
        Button redButton=new Button(this);
        redButton.setText("click me hoss");
        redButton.setBackgroundColor(Color.RED);

        //username input
        EditText username =new EditText(this);
        redButton.setId(1);
        username.setId(2);

        RelativeLayout.LayoutParams buttonDetails=new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );

        RelativeLayout.LayoutParams usernameDetails=new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );

        //give Reles to position vidges
        usernameDetails.addRule(RelativeLayout.ABOVE,redButton.getId());
        usernameDetails.addRule(RelativeLayout.CENTER_HORIZONTAL);
        usernameDetails.setMargins(0,0,0,50);


        buttonDetails.addRule(RelativeLayout.CENTER_HORIZONTAL);
        buttonDetails.addRule(RelativeLayout.CENTER_VERTICAL);



        //add vidget to layout(button is nov a child of layout
        r.addView(redButton,buttonDetails);
        r.addView(username,usernameDetails);
        setContentView(r);
    }
}
