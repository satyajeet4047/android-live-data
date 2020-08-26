package com.example.livedataexample;

import androidx.lifecycle.LiveData;

public interface IFollowerCount {

    LiveData<FollowerCount> getFollowerCount();

    void addFollower();

    void removeFollower();
}
