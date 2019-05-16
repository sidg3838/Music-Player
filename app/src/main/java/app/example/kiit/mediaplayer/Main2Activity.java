package app.example.kiit.mediaplayer;

import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    ProgressBar pb;
    ListView lv;
    MediaPlayer mp,mpp,mppp;
    Button stop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        pb = findViewById(R.id.pb);
        lv = findViewById(R.id.lv);
       mp = MediaPlayer.create(this,R.raw.pt);
       mpp = MediaPlayer.create(this,R.raw.br);
       mppp = MediaPlayer.create(this,R.raw.cl);
       stop = findViewById(R.id.stop);

        String numbers[] = {"PATOLA", "BROWN RANG", "CLOSER"};
        final ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1, numbers);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                pb.setVisibility(View.INVISIBLE);
                lv.setAdapter(stringArrayAdapter);
            }
        }, 1000);
        lv.setAdapter(stringArrayAdapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {

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
                        mp=MediaPlayer.create(Main2Activity.this,R.raw.pt);
                        mp.start();
                    }

                    Toast.makeText(Main2Activity.this, "patola playing", Toast.LENGTH_SHORT).show();
                }
                if (position == 1){
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
                    mpp=MediaPlayer.create(Main2Activity.this,R.raw.br);
                    mpp.start();
                }
                    Toast.makeText(Main2Activity.this, "brown rang playing", Toast.LENGTH_SHORT).show();
                }
                if (position == 2) {
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
                        mppp=MediaPlayer.create(Main2Activity.this,R.raw.cl);
                        mppp.start();
                    }
                    Toast.makeText(Main2Activity.this, "closure playing", Toast.LENGTH_SHORT).show();
                }
            }
        });
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
}

