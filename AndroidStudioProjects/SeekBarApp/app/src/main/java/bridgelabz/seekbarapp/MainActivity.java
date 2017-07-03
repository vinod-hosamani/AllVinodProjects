package bridgelabz.seekbarapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
   private static SeekBar seek_bar;
    private static TextView text_view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        seebbarr();
    }
    public void seebbarr(){
        seek_bar=(SeekBar)findViewById(R.id.seekBar);
        text_view=(TextView)findViewById(R.id.textView);
        text_view.setText("coverd "+seek_bar.getProgress() +"/"+seek_bar.getMax());

        seek_bar.setOnSeekBarChangeListener{
            new SeekBar.OnSeekBarChangeListener() {
                int progress_value;
                @Override
                public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                    progress_value=progress;

                    text_view.setText("coverd "+progress+"/"+seek_bar.getMax());
                    Toast.makeText(MainActivity.this,"seekbar in start trackin",Toast.LENGTH_LONG).show();


                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {
                    Toast.makeText(MainActivity.this,"seekbar in progress",Toast.LENGTH_LONG).show();

                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {
                    text_view.setText("coverd "+progress_value+"/"+seek_bar.getMax());
                    Toast.makeText(MainActivity.this,"onStopTrackingTouch",Toast.LENGTH_LONG).show();

                }
            }
        };
    }
}
