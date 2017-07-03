package bridgelabz.alertdialogbox;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
      private static Button buttonsbm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        onButtonClickListener();
    }

    public void onButtonClickListener(){
        buttonsbm=(Button)findViewById(R.id.button);

        buttonsbm.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v)
                    {
                        AlertDialog.Builder abuilder=new AlertDialog.Builder(MainActivity.this);
                        abuilder.setMessage("do you want to close this app!")
                                .setCancelable(false)
                                .setPositiveButton("yes", new DialogInterface.OnClickListener()
                                {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i)
                                    {
                                        finish();

                                    }
                                })
                                .setNegativeButton("no", new DialogInterface.OnClickListener()
                                {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i)
                                    {
                                        dialogInterface.cancel();
                                    }
                                });
                        AlertDialog alert=abuilder.create();
                        alert.setTitle("alert!!");
                        alert.show();
                    }
                }
        );
    }
}
