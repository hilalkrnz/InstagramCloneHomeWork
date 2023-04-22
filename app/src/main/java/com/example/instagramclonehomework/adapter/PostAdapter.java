package com.example.instagramclonehomework.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.instagramclonehomework.model.PostListData;
import com.example.instagramclonehomework.R;

public class PostAdapter extends RecyclerView.Adapter<PostViewHolder> {

    private final PostListData[] postListData;

    public PostAdapter(PostListData[] postListData) {
        this.postListData = postListData;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View postListItem = layoutInflater.inflate(R.layout.layout_post, parent, false);
        PostViewHolder viewHolder = new PostViewHolder(postListItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        holder.postProfileName.setText(postListData[position].getPostName());
        holder.postImage.setImageResource(postListData[position].getImageId());
}

    @Override
    public int getItemCount() {
        return postListData.length;
    }
}
