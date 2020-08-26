package com.example.livedataexample;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.Objects;

public class FollowerCountRepo implements IFollowerCount {

    private  LiveData<FollowerCount> mFollowerCount;

    @Override
    public LiveData<FollowerCount> getFollowerCount() {

        if(mFollowerCount != null){
            return mFollowerCount;
        }

        mFollowerCount = new MutableLiveData<>();

        return mFollowerCount;

    }

    @Override
    public void addFollower() {

        if(mFollowerCount == null) {

            mFollowerCount = new MutableLiveData<>();

        }
        ((MutableLiveData<FollowerCount>) mFollowerCount).setValue(getFollowObject(true));


    }

    @Override
    public void removeFollower() {

        if(mFollowerCount == null) {

            mFollowerCount = new MutableLiveData<>();

        }
        ((MutableLiveData<FollowerCount>) mFollowerCount).setValue(getFollowObject(false));

    }

    private FollowerCount getFollowObject(boolean isAddition) {

        int numberOfFollowers =  mFollowerCount.getValue() != null ? mFollowerCount.getValue().followerCount : 0;
        return new FollowerCount(isAddition ? numberOfFollowers+1 : numberOfFollowers -1);
    }
}
