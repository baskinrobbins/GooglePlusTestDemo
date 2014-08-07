package com.doyouevencodebro.googleplustestdemo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.google.android.gms.plus.PlusShare;

/**
 * Created by bryanokeke on 7/28/14.
 */
public class Home extends Fragment {

    LinearLayout mLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mLayout = (LinearLayout) inflater.inflate(R.layout.home_fragment_layout, container, false);

        return mLayout;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Button shareButton = (Button) mLayout.findViewById(R.id.share_button);
        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Launch the Google+ share dialog with attribution to your app.
                Intent shareIntent = new PlusShare.Builder(getActivity())
                        .setType("text/plain")
                        .setText("Welcome to the Google+ platform.")
                        .setContentUrl(Uri.parse("https://developers.google.com/+/"))
                        .getIntent();

                startActivityForResult(shareIntent, 0);
            }
        });
    }
}
