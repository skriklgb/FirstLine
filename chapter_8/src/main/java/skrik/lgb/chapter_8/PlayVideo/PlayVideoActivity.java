package skrik.lgb.chapter_8.PlayVideo;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

import java.io.File;

import skrik.lgb.chapter_8.R;

public class PlayVideoActivity extends Activity implements View.OnClickListener{

    private VideoView videoView;
    private Button play;
    private Button pause;
    private Button replay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.playvedio);

        play = (Button) findViewById(R.id.play);
        pause = (Button) findViewById(R.id.pause);
        replay = (Button) findViewById(R.id.replay);
        videoView = (VideoView) findViewById(R.id.video_view);
        play.setOnClickListener(this);
        pause.setOnClickListener(this);
        replay.setOnClickListener(this);
        initVideoPath();

    }

    private void initVideoPath() {
        File file = new File(Environment.getExternalStorageDirectory(),"movie.3gp");
        videoView.setVideoPath(file.getPath()); // 指定视频文件的路径
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (videoView != null) {
            videoView.suspend();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.play:
                if (!videoView.isPlaying()) {
                    videoView.start(); // 开始播放
                }
                break;
            case R.id.pause:
                if (videoView.isPlaying()) {
                    videoView.pause(); // 暂时播放
                }
                break;
            case R.id.replay:
                if (videoView.isPlaying()) {
                    videoView.resume(); // 重新播放
                }
                break;
         }
    }

}
