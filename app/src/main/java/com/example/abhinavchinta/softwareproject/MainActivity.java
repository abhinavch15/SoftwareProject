package com.example.abhinavchinta.softwareproject;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LinearLayout fan = (LinearLayout)findViewById(R.id.fan);
        LinearLayout light = (LinearLayout)findViewById(R.id.light);
        RelativeLayout temp = (RelativeLayout)findViewById(R.id.temp);
        RelativeLayout call = (RelativeLayout)findViewById(R.id.call);

        fan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,FanActivity.class);
                startActivity(intent);
            }
        });
        light.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,LightActivity.class);
                startActivity(intent);
            }
        });
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(MainActivity.this,MainActivity.class);
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:0377778888"));

                if (ActivityCompat.checkSelfPermission(MainActivity.this,
                        Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    //startActivity(callIntent);
                    //return;
                }

                final String REQUEST_PERMISSION_CALL = "111";

                startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:112")));


                //startActivity(callIntent);

                //startActivity(intent);
            }
        });
        temp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
