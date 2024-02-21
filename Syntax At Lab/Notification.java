package com.example.notification;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn;
    private static final String channel_id = "my_channel";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

                Notification notification;

                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                    notification = new Notification.Builder(getApplicationContext())
                            .setContentTitle("New mail from " + "test@gmail.com")
                            .setContentText("Subject")
                            .setSmallIcon(R.drawable.icon)
                            .setAutoCancel(true)
                            .setChannelId(channel_id)
                            .build();

                    nm.createNotificationChannel(
                            new NotificationChannel(channel_id, "New Channel", NotificationManager.IMPORTANCE_HIGH));
                } else {
                    notification = new Notification.Builder(getApplicationContext())
                            .setSmallIcon(R.drawable.ic_launcher_background)
                            .setContentTitle("Notification Testing 1")
                            .setContentText("Notification body")
                            .setSubText("Notification subtext")
                            .build();
                }

                nm.notify(211, notification);
            }
        });

    }
}

// NOTE
// put permisions in manifest.xml
// <uses-permission android:name="android.permission.POST_NOTIFICATIONS"/>
// <uses-permission android:name="android.permission.VIBRATE"/>
// <uses-permission
// android:name="android.permission.ACCESS_NOTIFICATION_POLICY"/>