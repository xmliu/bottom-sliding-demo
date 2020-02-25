package com.xmliu.bottomsliding;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.sothree.slidinguppanel.SlidingUpPanelLayout;

import static android.content.ContentValues.TAG;

public class MainActivity extends AppCompatActivity {

    private SlidingUpPanelLayout mLayout;
    private ImageView pullIV;
    private View hatView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        hatView = findViewById(R.id.hat_view);
        pullIV = findViewById(R.id.pull_imageview);

        mLayout = findViewById(R.id.sliding_layout);
        mLayout.setFadeOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mLayout.setPanelState(SlidingUpPanelLayout.PanelState.COLLAPSED);
            }
        });
        mLayout.setCoveredFadeColor(Color.parseColor("#00000000"));

        mLayout.addPanelSlideListener(new SlidingUpPanelLayout.PanelSlideListener() {
            @Override
            public void onPanelSlide(View panel, float slideOffset) {
                Log.i(TAG, "onPanelSlide, offset " + slideOffset);
            }

            @Override
            public void onPanelStateChanged(View panel, SlidingUpPanelLayout.PanelState previousState, SlidingUpPanelLayout.PanelState newState) {
                if(mLayout.getPanelState().toString().equals(SlidingUpPanelLayout.PanelState.COLLAPSED.toString())){
                    pullIV.setImageResource(R.drawable.pull_up);
                    hatView.setVisibility(View.GONE);

                }else if(mLayout.getPanelState().toString().equals(SlidingUpPanelLayout.PanelState.EXPANDED.toString())){
                    pullIV.setImageResource(R.drawable.pull_down);
                    hatView.setVisibility(View.VISIBLE);

                }
            }
        });
    }
}
