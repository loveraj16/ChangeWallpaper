package com.example.changewallpaper;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import java.util.Random;

import static java.lang.Thread.*;

public class MainActivity extends AppCompatActivity {
    Button btn;
    RelativeLayout relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=(Button)findViewById(R.id.button);
        relativeLayout=(RelativeLayout)findViewById(R.id.r1);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new changeWallpaper().execute();
            }
        });
    }
    private class changeWallpaper extends AsyncTask<Void,Integer,Void> {
        int img[]={R.drawable.img1,R.drawable.img2,R.drawable.img3,R.drawable.img4,R.drawable.img5};

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            relativeLayout.setBackgroundResource(R.drawable.img1);
        }

        @Override
        protected Void doInBackground(Void... voids) {
            while (true){
                Random random=new Random();
                int randNum=random.nextInt(5);
                publishProgress(randNum);

                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            int resId=values[0];
            Drawable drawable=getResources().getDrawable(img[resId]);
            relativeLayout.setBackground(drawable);
        }
    }
}