package com.chsh.cheshmaknativeinrecyclerview;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import me.cheshmak.cheshmakplussdk.advertise.CheshmakNativeBannerAd;
import me.cheshmak.cheshmakplussdk.advertise.NativeBannerCallback;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {

    private List<String> mData;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;
    private Activity activity;

    // data is passed into the constructor
    MyRecyclerViewAdapter(Activity activity, List<String> data) {
        this.mInflater = LayoutInflater.from(activity);
        this.mData = data;
        this.activity = activity;
    }

    // inflates the row layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.recyclerview_row, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    // total number of rows
    @Override
    public int getItemCount() {
        return mData.size();
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder {
        ViewGroup adContainer ;

        ViewHolder(View itemView) {
            super(itemView);
            adContainer = itemView.findViewById(R.id.nativeAdContainer);
            CheshmakNativeBannerAd cheshmakNativeBannerAd = new CheshmakNativeBannerAd(activity,
                    adContainer, R.layout.ad_unified, new NativeBannerCallback() {
                @Override
                public void onAdLoaded() {
                    Log.d("native banner", "onAdLoaded");
                }

                @Override
                public void onAdOpened() {
                    Log.d("native banner", "onAdOpened");
                }

                @Override
                public void onAdFailedToLoad() {
                    Log.d("native banner", "onAdFailedToLoad");
                }

                @Override
                public void onAdClosed() {
                    Log.d("native banner", "onAdClosed");
                }
            });
        }

    }

    // convenience method for getting data at click position
    String getItem(int id) {
        return mData.get(id);
    }

    // allows clicks events to be caught
    void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}