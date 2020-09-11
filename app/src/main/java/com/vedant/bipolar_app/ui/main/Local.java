package com.vedant.bipolar_app.ui.main;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vedant.bipolar_app.R;

import java.io.File;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class Local extends Fragment {
    public Local() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.fragment_local, container, false);

        RecyclerView recyclerView;
        RecyclerViewAdapter recyclerViewAdapter;
        Uri fileUri;


        File storage;
        String[] storagePaths;


        recyclerView = rootview.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        //if you face lack in scrolling then add following lines
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemViewCacheSize(20);
        recyclerView.setDrawingCacheEnabled(true);
        recyclerView.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);
        recyclerView.setNestedScrollingEnabled(false);

        recyclerViewAdapter = new RecyclerViewAdapter(getActivity());

        recyclerView.setAdapter(recyclerViewAdapter);

        storagePaths = StorageUtil.getStorageDirectories(getActivity());

        for (String path : storagePaths) {
            storage = new File(path);
            Method.load_Directory_Files(storage);
        }

        recyclerViewAdapter.notifyDataSetChanged();



        return rootview;
    }


    }
