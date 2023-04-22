package com.example.instagramclonehomework;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.instagramclonehomework.adapter.PostAdapter;
import com.example.instagramclonehomework.model.PostListData;

public class HomeFragment extends Fragment {

    public HomeFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        PostListData[] postListData = new PostListData[]{
                new PostListData("Melek Kızıl", R.drawable.cat),
                new PostListData("Hayat Demir", R.drawable.plain),
                new PostListData("Ayşe Su", R.drawable.sea),
        };

        RecyclerView recyclerView = view.findViewById(R.id.rv_posts);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        PostAdapter adapter = new PostAdapter(postListData);
        recyclerView.setAdapter(adapter);
        return view;
    }


}