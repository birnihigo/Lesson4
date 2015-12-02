package com.example.solomon.lesson4;

import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ActionMenuView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class MainActivity extends Activity {
    ImageView ivBart;
    ImageView ivHomer;

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        LinearLayout main_layout = new LinearLayout(this);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.MATCH_PARENT);

        ivBart = new ImageView(this);
        ivBart.setLayoutParams(params);
        ivBart.setImageResource(R.drawable.bart);
        ivBart.setAlpha(1f);
        ivBart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bartFadeOut(v);
            }
        });


        ivHomer = new ImageView(this);
        ivHomer.setLayoutParams(params);
        ivHomer.setImageResource(R.drawable.homer);
        ivHomer.setAlpha(0f);
        ivHomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                homerFadeOut(v);
            }
        });

        main_layout.addView(ivBart, params);
        main_layout.addView(ivHomer, params);
        setContentView(main_layout);

    }
    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR1)
    public void bartFadeOut(View view){
        ivBart.animate().alpha(0f).setDuration(2000);
        ivHomer.animate().alpha(1f).setDuration(2000);
    }
    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR1)
    public void homerFadeOut(View view){
        ivHomer.animate().alpha(0f).setDuration(2000);
        ivBart.animate().alpha(1f).setDuration(2000);
    }
}
