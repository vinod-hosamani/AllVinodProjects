package bridgelabz.ratingbars;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
      private static Button buttonsbm;
      private static TextView textv;
      private static RatingBar ratingb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listnerForRatingBar();
        onButtonClickListner();
    }
    public void listnerForRatingBar(){
        ratingb=(RatingBar)findViewById(R.id.ratingBar);
        textv=(TextView)findViewById(R.id.textView);

        ratingb.setOnRatingBarChangeListener(
                new RatingBar.OnRatingBarChangeListener() {
                    @Override
                    public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                        textv.setText(String.valueOf(v));
                    }
                }
        );
    }
    public void onButtonClickListner()
    {
        ratingb=(RatingBar)findViewById(R.id.ratingBar);
        buttonsbm=(Button)findViewById(R.id.button);

        buttonsbm.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this, String.valueOf(ratingb.getRating()), Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }
}
