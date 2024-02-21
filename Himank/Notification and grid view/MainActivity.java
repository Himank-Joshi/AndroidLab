package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity {
    GridView gridview;
    Button btn;
    private static final String channel_id = "my_channel";

    int[] images = {
            R.drawable.img1,
            R.drawable.img2,
            R.drawable.img3,
            R.drawable.img4,
            R.drawable.img5,
            R.drawable.img6

    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridview=findViewById(R.id.grid);
        gridview.setAdapter(new ImageAdapter(this,images));
        // just checking for string
        //String[] values = new String[] { "FootBall","Cricket","BasketBall","Tennis ","BaseBall"  };
       // ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
         //       android.R.layout.simple_list_item_1, android.R.id.text1, values);
        //  gridview.setAdapter(adapter);
        btn=findViewById(R.id.button);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

                Notification notification;

                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                    notification  = new Notification.Builder(getApplicationContext())
                            .setContentTitle("New mail from " + "test@gmail.com")
                            .setContentText("Subject")
                            .setSmallIcon(R.drawable.img1)
                            .setAutoCancel(true)
                            .setChannelId(channel_id)
                            .build();

                    nm.createNotificationChannel(new NotificationChannel(channel_id,"New Channel", NotificationManager.IMPORTANCE_HIGH));
                }
                else {
                    notification = new Notification.Builder(getApplicationContext())
                            .setSmallIcon(R.drawable.ic_launcher_background)
                            .setContentTitle("Notification Testing 1")
                            .setContentText("Notification body")
                            .setSubText("Notification subtext")
                            .build();
                }

                nm.notify(211,notification);
            }
        });



    }




}


