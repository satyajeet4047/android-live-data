package com.example.livedataexample;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

public class DisplayCountViewModel extends ViewModel {

     FollowerCountRepo mFollowerCountRepo;

     public DisplayCountViewModel(){
         mFollowerCountRepo = new FollowerCountRepo();
     }

    LiveData<FollowerCount> getFollowerCount() {

       return mFollowerCountRepo.getFollowerCount();
    }

    void addFollower() {

         mFollowerCountRepo.addFollower();
    }

    void removeFollower() {

         mFollowerCountRepo.removeFollower();
    }

}
