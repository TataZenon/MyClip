package ac.th.ssru.tarou.workshop.myclip;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    private VideoView clip;
    private Button play,stop;
    private int time = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        clip = (VideoView) findViewById(R.id.videoView);
        Uri file = Uri.parse("android.resource://" + getPackageName()+ "/" + R.raw.video);
        clip.setVideoURI(file);
        clip.setMediaController(new MediaController(this));
        clip.start();
        play = (Button) findViewById(R.id.buttonPlay);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = play.getText() + "" ;
                if (s.equals("Play")){
                    clip.seekTo(time);
                    clip.start();
                    play.setText("Pause");
                } else {
                    time = clip.getCurrentPosition();
                    clip.pause();
                    play.setText("Play");
                }
            }
        });
        stop = (Button) findViewById(R.id.buttonStop);
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clip.stopPlayback();
                clip.resume();
            }
        });

    }
}
