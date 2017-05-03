package com.example.user.animationdemo.ui;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.user.animationdemo.R;
import com.example.user.animationdemo.adapter.GridViewAdapter;

public class OptonAnimationFragment extends Fragment {


    GridView mGridView;
    Context mContext;
    MainActivity mMainActivity;


    String[] mLableTextView = {
            "Slide Animation",
            "Rotat Animation",
            "Bounce Animation",
            "Flip Animation",

    } ;
    int[] mImageId = {
            R.drawable.android_1,
            R.drawable.android_2,
            R.drawable.android_3,
            R.drawable.android_4,

    };

    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {


        ViewGroup root=(ViewGroup) inflater.inflate(R.layout.option_animation_fragment,container,false);

        mContext=container.getContext();



        GridViewAdapter adapter = new GridViewAdapter(root.getContext(), mLableTextView, mImageId);

        mGridView =(GridView) root.findViewById(R.id.gridView);
        mGridView.setAdapter(adapter);
        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                Intent lIntentToSendValue = new Intent("my.action.string");
                lIntentToSendValue.putExtra("image_id", mImageId[position]);
                lIntentToSendValue.putExtra("str_id", mLableTextView[position]);
                getActivity().sendBroadcast(lIntentToSendValue);




            }
        });

        return root;

    }



}
