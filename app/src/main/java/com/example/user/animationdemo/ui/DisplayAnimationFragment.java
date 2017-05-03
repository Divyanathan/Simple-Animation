package com.example.user.animationdemo.ui;

import android.app.Fragment;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

import com.example.user.animationdemo.R;

/**
 * Created by user on 23/04/17.
 */

public class DisplayAnimationFragment extends Fragment {


    ImageView mSlideAnimationView;
    ImageView mFlipAnimationView;
    ImageView mRotateAnimationView;
    ImageView mBounceAnimationView;
    Animation mAnimation;
    Animation mAnimation2;
    Context mContext;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mContext = container.getContext();

        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.display_animation_fragment, container, false);


        mSlideAnimationView = (ImageView) root.findViewById(R.id.sliceAnimationImageView);

         mFlipAnimationView= (ImageView) root.findViewById(R.id.FlipAnimationImage);
         mRotateAnimationView= (ImageView) root.findViewById(R.id.RotateAnimationImage);
         mBounceAnimationView= (ImageView) root.findViewById(R.id.BounceImage);


        BroadcastReceiver lMyBroadCastReciver = new MyBroadCastReciver();
        IntentFilter intentFilter = new IntentFilter("my.action.string");
        getActivity().registerReceiver(lMyBroadCastReciver, intentFilter);


        return root;
    }


    public void fadeIn(Context pContext, int pImageId,String pLable) {


        mSlideAnimationView.clearAnimation();
        mSlideAnimationView.setVisibility(View.GONE);

        mFlipAnimationView.clearAnimation();
        mFlipAnimationView.setVisibility(View.GONE);

        mRotateAnimationView.clearAnimation();
        mRotateAnimationView.setVisibility(View.GONE);

        mBounceAnimationView.clearAnimation();
        mBounceAnimationView.setVisibility(View.GONE);


        if (pImageId == R.drawable.android_1) {

            mSlideAnimationView.setVisibility(View.INVISIBLE);
            mSlideAnimationView.setBackgroundResource(pImageId);



            AnimationSet animationSet = new AnimationSet(true);
            animationSet.setFillAfter(true);
            TranslateAnimation a = new TranslateAnimation(
                    Animation.ABSOLUTE,0f, Animation.ABSOLUTE,800f,
                    Animation.ABSOLUTE,50, Animation.ABSOLUTE,50);
            a.setDuration(1000);

            AlphaAnimation lFadin=new AlphaAnimation(1.0f,0.2f);
            lFadin.setDuration(1000);
            animationSet.addAnimation(lFadin);
            animationSet.addAnimation(a);




            mSlideAnimationView.startAnimation(animationSet);


           /* mAnimation = AnimationUtils.loadAnimation(getActivity(), R.anim.slid_animation);
            mSlideAnimationView.startAnimation(mAnimation);*/


        }else if(pImageId == R.drawable.android_2){

            mRotateAnimationView.setVisibility(View.VISIBLE);
            mBounceAnimationView.setVisibility(View.VISIBLE);
            mBounceAnimationView.setBackgroundResource(pImageId);
            mRotateAnimationView.setBackgroundResource(pImageId);
            mAnimation = AnimationUtils.loadAnimation(getActivity(), R.anim.rotate_anty_cloclwise_animation);

            mRotateAnimationView.startAnimation(mAnimation);
            mAnimation2 = AnimationUtils.loadAnimation(getActivity(), R.anim.rotate_clockwise_animation);
            mBounceAnimationView.startAnimation(mAnimation2);

        }else if(pImageId == R.drawable.android_3){

            mBounceAnimationView.setVisibility(View.VISIBLE);
            mBounceAnimationView.setBackgroundResource(pImageId);
            mAnimation = AnimationUtils.loadAnimation(getActivity(), R.anim.bounce_animation);
            mBounceAnimationView.startAnimation(mAnimation);

        }else if(pImageId == R.drawable.android_4){

            mFlipAnimationView.setVisibility(View.INVISIBLE);
            mFlipAnimationView.setBackgroundResource(R.drawable.flip);
            mAnimation = AnimationUtils.loadAnimation(getActivity(), R.anim.flip_animation);
            mFlipAnimationView.startAnimation(mAnimation);


        }




    }

    class MyBroadCastReciver extends BroadcastReceiver {


        @Override
        public void onReceive(Context context, Intent intent) {

            fadeIn(context, intent.getIntExtra("image_id", 0),intent.getStringExtra("str_id"));

//            Toast.makeText(context, intent.getIntExtra("image_id",0), Toast.LENGTH_SHORT).show();
        }
    }


}
