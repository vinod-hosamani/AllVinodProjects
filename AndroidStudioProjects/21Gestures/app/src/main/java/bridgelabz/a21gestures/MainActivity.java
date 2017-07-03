package bridgelabz.a21gestures;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.view.MotionEvent;
import android.view.GestureDetector;
import android.support.v4.view.GestureDetectorCompat;


public class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener,
        GestureDetector.OnDoubleTapListener {

    private TextView vinodMessage;
    private GestureDetectorCompat gestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       vinodMessage=(TextView)findViewById(R.id.vinodMessage);
        this.gestureDetector=new GestureDetectorCompat(this,this);
        gestureDetector.setOnDoubleTapListener(this);
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        vinodMessage.setText("onSingleTapConfirmed");
        return true;
    }

    @Override
    public boolean onDoubleTap(MotionEvent motionEvent) {
        vinodMessage.setText("onDoubleTest");

        return false;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        vinodMessage.setText("onDoubleTapEvent");

        return false;
    }

    @Override
    public boolean onDown(MotionEvent motionEvent) {
        vinodMessage.setText("onDown");


        return true;
    }

    @Override
    public void onShowPress(MotionEvent motionEvent) {
        vinodMessage.setText("onShowPress");


    }

    @Override
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        vinodMessage.setText("onSingleTapUp");

        return false;
    }

    @Override
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        vinodMessage.setText("onScroll");

        return true;
    }

    @Override
    public void onLongPress(MotionEvent motionEvent) {
        vinodMessage.setText("onLongPress");


    }

    @Override
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        vinodMessage.setText("onFling");

        return true;
    }
}
