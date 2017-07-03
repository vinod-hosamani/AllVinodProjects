package bridgelabz.checkboxes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {

    private CheckBox check1,check2,check3;
    private Button buttonsel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListenerOnButton();
        addListnerToCheckBox();
    }
    public void addListenerOnButton()
    {
        check1=(CheckBox)findViewById(R.id.checkBox);
        check2=(CheckBox)findViewById(R.id.checkBox2);
        check3=(CheckBox)findViewById(R.id.checkBox3);
        buttonsel=(Button)findViewById(R.id.button);

        buttonsel.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View v)
                    {
                        StringBuffer result=new StringBuffer();
                        result.append("dog : ").append(check1.isChecked());
                        result.append("cat : ").append(check2.isChecked());
                        result.append("cow : ").append(check3.isChecked());

                        Toast.makeText(MainActivity.this,result.toString(),Toast.LENGTH_LONG).show();

                    }
                }
        );
    }
    public void addListnerToCheckBox()
    {

       check1=(CheckBox)findViewById(R.id.checkBox);
        check1.setOnClickListener(
                new View.OnClickListener()
                {

                    public void onClick(View v)
                    {
                        if(((CheckBox)v).isChecked())
                        {
                            Toast.makeText(MainActivity.this,"dog is selected",Toast.LENGTH_LONG).show();
                        }
                    }
                }
        );
    }
}
