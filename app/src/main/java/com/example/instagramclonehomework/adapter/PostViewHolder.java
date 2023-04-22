package com.example.instagramclonehomework.adapter;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.instagramclonehomework.R;

public class PostViewHolder extends RecyclerView.ViewHolder {

    public AppCompatTextView postProfileName;
    public AppCompatImageView postImage;

    public PostViewHolder(@NonNull View itemView) {
        super(itemView);
        this.postProfileName = itemView.findViewById(R.id.postProfileName);
        this.postImage = itemView.findViewById(R.id.postImage);
    }
}
