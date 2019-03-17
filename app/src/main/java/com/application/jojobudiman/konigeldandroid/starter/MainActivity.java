package com.application.jojobudiman.konigeldandroid.starter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.application.jojobudiman.konigeldandroid.R;

public class MainActivity extends AppCompatActivity {

    private ImageView konilogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        konilogo = (ImageView) findViewById(R.id.imageView);
        Animation transition = AnimationUtils.loadAnimation(this, R.anim.begin);
        konilogo.setAnimation(transition);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(getApplicationContext(), MenuChoice.class));
                finish();
            }
        }, 3000L);
    }
}
