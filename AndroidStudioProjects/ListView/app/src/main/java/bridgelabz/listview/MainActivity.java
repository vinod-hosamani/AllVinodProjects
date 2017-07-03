package bridgelabz.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
  public static ListView list_view;
    private static String[] NAMES=new String[]{"tom","mark","john","jack","patrik","peter"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView();
    }
    public void listView(){
        list_view=(ListView) findViewById(R.id.listView);


        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,R.layout.name_list,NAMES);
        list_view.setAdapter(adapter);

        list_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
                    {
                        String value=(String)list_view.getItemAtPosition(i);
                        Toast.makeText(MainActivity.this," position "+i+"value "+value,
                                Toast.LENGTH_LONG).show();
                    }
                }
        );
    }
}
