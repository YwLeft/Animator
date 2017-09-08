package com.example.asus.rikao09;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ImageView mimage;
    private AnimatorSet animSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initview();
    }

    private void initview() {
        mimage = (ImageView) findViewById(R.id.image);
        mimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectAnimator moveIn = ObjectAnimator.ofFloat(mimage, "translationX", -500f, 0f);
                ObjectAnimator rotate = ObjectAnimator.ofFloat(mimage, "rotation", 0f, 360f);
                ObjectAnimator fadeInOut = ObjectAnimator.ofFloat(mimage, "alpha", 1f, 0f, 1f);
                ObjectAnimator animator = ObjectAnimator.ofFloat(mimage, "scaleY", 1f, 3f, 1f);

                animSet = new AnimatorSet();
                animSet.play(rotate).with(fadeInOut).before(animator).after(moveIn);
                animSet.setDuration(3000);
                animSet.start();
                animSet.addListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        animSet.start();
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                });
            }
        });

    }
}
