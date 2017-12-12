package com.example.reueljohn.largeimages;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private int toggle = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void changeImageView(View view){

        if(toggle==0){
            view.setBackgroundResource(R.drawable.dinosaur_medium);
            toggle=1;
        }else {
            try {
                Thread.sleep(32); // two refreshes
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            view.setBackgroundResource(R.drawable.ankylo);
            toggle=0;
        }

    }
}
