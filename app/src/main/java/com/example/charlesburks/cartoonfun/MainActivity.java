package com.example.charlesburks.cartoonfun;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;


public class MainActivity extends ActionBarActivity {

    AnimationDrawable swingAnimation;
    int spins = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView imgFrame=(ImageView)findViewById(R.id.imgSwing);
        imgFrame.setBackgroundResource(R.drawable.animation);
        swingAnimation=(AnimationDrawable) imgFrame.getBackground();
        Button btFrame=(Button) findViewById(R.id.btnStart);
        Button btTween=(Button) findViewById(R.id.btnStop);


        btFrame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                swingAnimation.start();
            }
        });
        btTween.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                swingAnimation.stop();
                startActivity (new Intent(MainActivity.this, tween.class));
                TimerTask task = new TimerTask() {
                    @Override
                    public void run() {

                        // TODO Auto-generated method stub
                        finish();
                        startActivity(new Intent(MainActivity.this, MainActivity.class));
                    }
                };

                Timer opening = new Timer();
                opening.schedule(task, 2500);
            }


        });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
