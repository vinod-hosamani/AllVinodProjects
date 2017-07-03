package bridgelabz.todoapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by bridgeit on 25/3/17.
 */

public class WelComeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        Button button=(Button)findViewById(R.id.logoutbtn);
    }
    public void Logout(View view){
        Intent intent=new Intent(this,LoginActivity.class);
        startActivity(intent);
        finish();
    }
}
