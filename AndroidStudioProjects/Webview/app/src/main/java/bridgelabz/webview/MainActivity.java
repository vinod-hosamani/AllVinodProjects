package bridgelabz.webview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
   private static Button buttonsbm;
    private static EditText url_test;
    private static WebView browser;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        openUrl();
    }
    public void openUrl()
    {
        buttonsbm=(Button)findViewById(R.id.button);
        url_test=(EditText)findViewById(R.id.editText);
        browser=(WebView)findViewById(R.id.webView);

        buttonsbm.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String url=url_test.getText().toString();
                        browser.getSettings().setLoadsImagesAutomatically(true);
                        browser.getSettings().setJavaScriptEnabled(true);
                        browser.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
                        browser.loadUrl(url);
                    }
                }


        );
    }
}
