package app.example.kiit.mediaplayer;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    SeekBar sb;
    Button forward,rewind,pause,play,stop,previous,next,viewlist;
    MediaPlayer mp,mpp,mppp;
    int i=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sb=findViewById(R.id.sb);
        forward=findViewById(R.id.forward);
        pause=findViewById(R.id.pause);
        play=findViewById(R.id.play);
        stop=findViewById(R.id.stop);
        rewind=findViewById(R.id.rewind);
        previous=findViewById(R.id.previous);
        next=findViewById(R.id.next);
        viewlist=findViewById(R.id.viewlist);
        mp= MediaPlayer.create(this,R.raw.pt);
        mpp=MediaPlayer.create(this,R.raw.br);
        mppp=MediaPlayer.create(this,R.raw.cl);
        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Toast.makeText(MainActivity.this, "onProgressChanged",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(MainActivity.this, "OnStartTrack",Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(MainActivity.this,"onStaopTrack",Toast.LENGTH_SHORT).show();

            }
        });
        sb.setMax(mp.getDuration());
        {
            Thread t = new Thread() {
                public void run() {
                    super.run();
                    while (true) {
                        if (mp != null) {
                            try {
                                sb.setProgress(mp.getCurrentPosition());
                            } catch (Exception e) {
                                sb.setProgress(0);
                            }
                        } else {
                            sb.setProgress(0);
                            //mp=null;
                            //break;
                        }
                    }
                }
            };
            t.start();
        }
        sb.setMax(mpp.getDuration());
        {
            Thread tt = new Thread() {
                public void run() {
                    super.run();
                    while (true) {
                        if (mpp != null) {
                            try {
                                sb.setProgress(mpp.getCurrentPosition());
                            } catch (Exception e) {
                                sb.setProgress(0);
                            }
                        } else {
                            sb.setProgress(0);
                            //mp=null;
                            //break;
                        }
                    }
                }
            };
            tt.start();
        }
        sb.setMax(mp.getDuration());
        {
            Thread ttt = new Thread() {
                public void run() {
                    super.run();
                    while (true) {
                        if (mppp != null) {
                            try {
                                sb.setProgress(mppp.getCurrentPosition());
                            } catch (Exception e) {
                                sb.setProgress(0);
                            }
                        } else {
                            sb.setProgress(0);
                            //mp=null;
                            //break;
                        }
                    }
                }
            };
            ttt.start();
        }

    }
    public void stop(View view)
    {
        if(mp!=null) {
            mp.stop();
            mp = null;
        }
        if(mpp!=null) {
            mpp.stop();
            mpp = null;
        }
        if(mppp!=null){
            mppp.stop();
            mppp = null;
        }
    }
    public void play(View view)
    {
        if(mp!=null) {
            mp.start();
        }
        else {
            mp=MediaPlayer.create(MainActivity.this,R.raw.pt);
            mp.start();
        }
    }
    public void pause(View view)
    {
        if(mp!=null) {
            mp.pause();
        }
        if(mpp!=null) {
            mpp.pause();
        }
        if(mppp!=null) {
            mppp.pause();
        }
    }
    public void forward(View view)
    {
        if(mp!=null) {
            mp.seekTo(mp.getCurrentPosition() + 5000);
        }
        if(mpp!=null) {
            mpp.seekTo(mpp.getCurrentPosition() + 5000);
        }
        if(mppp!=null) {
            mppp.seekTo(mppp.getCurrentPosition() + 5000);
        }

    }
    public void rewind(View view)
    {
        if(mp!=null) {
            mp.seekTo(mp.getCurrentPosition() - 5000);
        }
        if(mpp!=null) {
            mpp.seekTo(mpp.getCurrentPosition() - 5000);
        }
        if(mppp!=null) {
            mppp.seekTo(mppp.getCurrentPosition() - 5000);
        }

    }
    public void vl(View view)
    {
        Intent var=new Intent(MainActivity.this,Main2Activity.class);
        startActivity(var);
    }
    public void next(View view)
    {
        if (i == 0) {

            if(mpp!=null) {
                mpp.stop();
                mpp = null;
            }

            if(mppp!=null) {
                mppp.stop();
                mppp = null;
            }

            if(mp!=null) {
                mp.start();
            }
            else {
                mp=MediaPlayer.create(MainActivity.this,R.raw.pt);
                mp.start();
            }
            i++;
            Toast.makeText(MainActivity.this, "patola playing", Toast.LENGTH_SHORT).show();
        }
       else if (i == 1){
            if(mp!=null) {
                mp.stop();
                mp = null;
            }

            if(mppp!=null) {
                mppp.stop();
                mppp = null;
            }

            if(mpp!=null) {
                mpp.start();
            }
            else {
                mpp=MediaPlayer.create(MainActivity.this,R.raw.br);
                mpp.start();
            }
            i++;
            Toast.makeText(MainActivity.this, "brown rang playing", Toast.LENGTH_SHORT).show();
        }
        else if (i == 2) {
            if(mpp!=null) {
                mpp.stop();
                mpp = null;
            }

            if(mp!=null) {
                mp.stop();
                mp = null;
            }

            if(mppp!=null) {
                mppp.start();
            }
            else {
                mppp=MediaPlayer.create(MainActivity.this,R.raw.cl);
                mppp.start();
            }
            i=0;
            Toast.makeText(MainActivity.this, "closure playing", Toast.LENGTH_SHORT).show();
        }
    }
    public void prev(View view)
    {
        if (i == 0) {

            if(mpp!=null) {
                mpp.stop();
                mpp = null;
            }

            if(mp!=null) {
                mp.stop();
                mp = null;
            }

            if(mppp!=null) {
                mppp.start();
            }
            else {
                mppp=MediaPlayer.create(MainActivity.this,R.raw.cl);
                mppp.start();
            }
            i++;

            Toast.makeText(MainActivity.this, "patola playing", Toast.LENGTH_SHORT).show();
        }
       else if (i == 1){
            if(mp!=null) {
                mp.stop();
                mp = null;
            }

            if(mppp!=null) {
                mppp.stop();
                mppp = null;
            }

            if(mpp!=null) {
                mpp.start();
            }
            else {
                mpp=MediaPlayer.create(MainActivity.this,R.raw.br);
                mpp.start();
            }
            i++;
            Toast.makeText(MainActivity.this, "brown rang playing", Toast.LENGTH_SHORT).show();
        }
        if (i == 2) {
            if(mpp!=null) {
                mpp.stop();
                mpp = null;
            }

            if(mppp!=null) {
                mppp.stop();
                mppp = null;
            }

            if(mp!=null) {
                mp.start();
            }
            else {
                mp=MediaPlayer.create(MainActivity.this,R.raw.pt);
                mp.start();
            }
            Toast.makeText(MainActivity.this, "closure playing", Toast.LENGTH_SHORT).show();
        }
    }
}
