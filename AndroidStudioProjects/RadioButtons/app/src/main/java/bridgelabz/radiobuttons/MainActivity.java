package bridgelabz.radiobuttons;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static RadioGroup radiog;
    private static RadioButton radiob;
    private static Button buttonsbm;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        onClickListnerButton();

    }
    public void onClickListnerButton()
    {
        radiog=(RadioGroup)findViewById(R.id.rg_animals);
        buttonsbm=(Button)findViewById(R.id.button);
        buttonsbm.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v)
                    {
                        int selectedid=radiog.getCheckedRadioButtonId();
                        radiob=(RadioButton)findViewById(selectedid);
                        Toast.makeText(MainActivity.this,radiob.getText().toString(),Toast.LENGTH_LONG).show();
                    }
                }
        );
    }
}
