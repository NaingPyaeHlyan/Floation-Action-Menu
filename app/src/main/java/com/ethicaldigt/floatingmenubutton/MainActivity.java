package com.ethicaldigt.floatingmenubutton;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private FloatingActionButton fab_main, fab_share, fab_email;
    private Animation ani_open, ani_close, ani_clock, ani_anti_clock;
    private TextView txt_share, txt_mail;
    private Boolean isOpen = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();

        fab_main.setOnClickListener(this);
        fab_share.setOnClickListener(this);
        fab_email.setOnClickListener(this);
    }

    private void initUI(){
        fab_main = findViewById(R.id.fab_main);
        fab_share = findViewById(R.id.fab_share);
        fab_email = findViewById(R.id.fab_mail);

        ani_close = AnimationUtils.loadAnimation(this, R.anim.fab_close);
        ani_open = AnimationUtils.loadAnimation(this, R.anim.fab_open);
        ani_clock = AnimationUtils.loadAnimation(this, R.anim.fab_rotate_clock);
        ani_anti_clock = AnimationUtils.loadAnimation(this, R.anim.fab_rotate_anti_clock);

        txt_mail = findViewById(R.id.textview_mail);
        txt_share = findViewById(R.id.textview_share);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.fab_main:
                fabMainClick();
                break;
            case R.id.fab_share:
                Toast.makeText(this, "Share", Toast.LENGTH_SHORT).show();
                break;
            case R.id.fab_mail:
                Toast.makeText(this, "Email", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    protected void fabMainClick(){
        if (isOpen){
            txt_mail.setVisibility(View.INVISIBLE);
            txt_share.setVisibility(View.INVISIBLE);
            fab_share.startAnimation(ani_close);
            fab_email.startAnimation(ani_close);
            fab_main.startAnimation(ani_anti_clock);
            fab_share.setClickable(false);
            fab_email.setClickable(false);
            isOpen = false;
        } else{
            txt_mail.setVisibility(View.VISIBLE);
            txt_share.setVisibility(View.VISIBLE);
            fab_share.startAnimation(ani_open);
            fab_email.startAnimation(ani_open);
            fab_main.startAnimation(ani_clock);
            fab_share.setClickable(true);
            fab_email.setClickable(true);
            isOpen = true;
        }
    }
}
