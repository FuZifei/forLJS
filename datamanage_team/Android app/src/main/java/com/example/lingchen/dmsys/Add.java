package com.example.lingchen.dmsys;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lingchen.dmsys.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Add extends Fragment {


    public Add() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_add, container, false);
    }

    /**
     * A simple {@link Fragment} subclass.
     */
    public static class File extends Fragment {


        public File() {
            // Required empty public constructor
        }


        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            return inflater.inflate(R.layout.fragment_file, container, false);
        }

    }
}
