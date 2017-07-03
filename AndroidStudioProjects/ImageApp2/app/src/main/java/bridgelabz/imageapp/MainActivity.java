package bridgelabz.imageapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
     private static ImageView imageView;
    private static Button buttonsbm;

    private int current_image_index;
    int[] images={R.drawable.ic_launcher3,R.drawable.ic_launcher4,R.drawable.ic_launcher5};
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonClick();
    }
    public void buttonClick()
    {
        imageView=(ImageView)findViewById(R.id.imageView);
        buttonsbm=(Button)findViewById(R.id.button);

        buttonsbm.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v)
                    {
                        current_image_index++;
                        current_image_index=current_image_index % images.length;
                        //imageView.setImageResource(images[current_image_index]);
                        imageView.setImageResource(R.drawable.ic_launcher3);
                    }
                }
        );
    }
}
