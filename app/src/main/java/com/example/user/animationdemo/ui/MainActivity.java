package com.example.user.animationdemo.ui;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.user.animationdemo.R;

public class MainActivity extends AppCompatActivity {

    DisplayAnimationFragment lAnimationFragment;
    OptonAnimationFragment lGridViewFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



         lAnimationFragment=new DisplayAnimationFragment();
         lGridViewFragment= new OptonAnimationFragment();


        FragmentManager lFingerprintManager=getFragmentManager();
        FragmentTransaction lFragmentTransaction=lFingerprintManager.beginTransaction();
        lFragmentTransaction.add(R.id.displayAnimationFragment,lAnimationFragment);
        lFragmentTransaction.add(R.id.OptionAnimationFragmentLayot,lGridViewFragment);
        lFragmentTransaction.commit();


    }


}
