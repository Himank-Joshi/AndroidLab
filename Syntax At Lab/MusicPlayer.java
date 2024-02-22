import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    private Button playButton;
    private Button pauseButton;
    private Button forwardButton;
    private Button rewindButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayer = MediaPlayer.create(this, R.raw.sample_audio);
        playButton = findViewById(R.id.button_play);
        pauseButton = findViewById(R.id.button_pause);
        forwardButton = findViewById(R.id.button_forward);
        rewindButton = findViewById(R.id.button_rewind);

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mediaPlayer.isPlaying()) {
                    mediaPlayer.start();
                    Toast.makeText(MainActivity.this, "Playing", Toast.LENGTH_SHORT).show();
                }
            }
        });

        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                    Toast.makeText(MainActivity.this, "Paused", Toast.LENGTH_SHORT).show();
                }
            }
        });

        forwardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentPosition = mediaPlayer.getCurrentPosition();
                int duration = mediaPlayer.getDuration();
                if (currentPosition + 5000 < duration) {
                    mediaPlayer.seekTo(currentPosition + 5000);
                    Toast.makeText(MainActivity.this, "Forwarded 5 seconds", Toast.LENGTH_SHORT).show();
                }
            }
        });

        rewindButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentPosition = mediaPlayer.getCurrentPosition();
                if (currentPosition - 5000 > 0) {
                    mediaPlayer.seekTo(currentPosition - 5000);
                    Toast.makeText(MainActivity.this, "Rewinded 5 seconds", Toast.LENGTH_SHORT).show();
                } else {
                    mediaPlayer.seekTo(0);
                    Toast.makeText(MainActivity.this, "Rewinded to the beginning", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}
