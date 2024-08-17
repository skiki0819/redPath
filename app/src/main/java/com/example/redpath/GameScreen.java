package com.example.redpath;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

public class GameScreen extends AppCompatActivity implements SensorEventListener {

    TextView storyText,txtv,txt1;
    Button b1,b2,b3;
    SensorManager sm;
    int count=0 ;
    ImageView img;
    Story story = new Story(this);

    ScrollView sv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
        WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        setContentView(R.layout.activity_game_screen);
        sv = (ScrollView) findViewById(R.id.sv);

        sm = (SensorManager) getSystemService(SENSOR_SERVICE);

        img = findViewById(R.id.img);
        storyText = findViewById(R.id.storyText);
        b1 = findViewById(R.id.btn1);
        b2 = findViewById(R.id.btn2);
        b3 = findViewById(R.id.btn3);

        b1.setTransformationMethod(null);
        b2.setTransformationMethod(null);
        b3.setTransformationMethod(null);



        story.startingPoint();
    }

    @Override
    protected void onResume() {
        super.onResume();
        sm.registerListener(this, sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),SensorManager.SENSOR_DELAY_NORMAL);
        sm.registerListener(this, sm.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE),SensorManager.SENSOR_DELAY_NORMAL);


    }

    @Override
    protected void onPause() {
        super.onPause();
        sm.unregisterListener(this);

    }


    public void button1(View v){

        story.selectPosition(story.nextPosition1);
    }
    public void button2(View v){
        story.selectPosition(story.nextPosition2);

    }
    public void button3(View v){
        story.selectPosition(story.nextPosition3);

    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {

        if(sensorEvent.sensor.getType() == Sensor.TYPE_ACCELEROMETER){
            if (story.acceloOn){
                if(sensorEvent.values[0] < -10.0 || sensorEvent.values[0] > 10.0){
                   story.selectPosition("dwarfsBeated");
                }
            }
        }

        if(sensorEvent.sensor.getType() == Sensor.TYPE_AMBIENT_TEMPERATURE){
            if (sensorEvent.values[0]<=5 && story.wand && story.beatGozor){
                story.selectPosition("gozorBeaten");
            }

            else if(sensorEvent.values[0]>=30 && story.wand){
                story.selectPosition("ending");

            }

        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        int action, keycode;
        action= event.getAction();
        keycode = event.getKeyCode();

        switch (keycode){

            case KeyEvent.KEYCODE_VOLUME_DOWN:
                if (KeyEvent.ACTION_DOWN==action){
                    count--;


                }
                break;
            case KeyEvent.KEYCODE_VOLUME_UP:
                if (KeyEvent.ACTION_UP==action){
                    count++;

                }
                break;
        }


        if(count<-9 && story.sword || story.crossbow && story.sneaking){
            story.wand=true;
            story.selectPosition("witchBeaten");
        }

        else if(count>9 && story.sword || story.crossbow && story.roaring){
            story.wand=true;
            story.selectPosition("witchBeaten");
        }


        return super.dispatchKeyEvent(event);
    }
}
