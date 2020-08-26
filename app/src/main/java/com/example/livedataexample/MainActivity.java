package com.example.livedataexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    DisplayCountViewModel mDisplayCountViewModel;

    TextView mCountView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCountView = findViewById(R.id.textView);
        mDisplayCountViewModel = ViewModelProviders.of(this).get(DisplayCountViewModel.class);


        observeProfile();
    }

    private void observeProfile() {
        mDisplayCountViewModel.getFollowerCount().observe(this, new  Observer<FollowerCount>() {
            @Override
            public void onChanged(final FollowerCount followStatus) {

                int count = followStatus.followerCount;
                if(count<=0){
                    mCountView.setText(getResources().getString(R.string.no_followers_text));
                } else {
                    mCountView.setText(getResources().getString(R.string.follower_count_text).concat(Integer.toString(count)));
                }
            }
        });
    }

    public void addFollower(View v){
        mDisplayCountViewModel.addFollower();
    }
    public void removeFollower(View v){
        mDisplayCountViewModel.removeFollower();
    }

}
