package com.bennett.androidoutfitpicker;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
 
public class FashionFragment extends Fragment {
 
     @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
          // Inflate the layout for this fragment
          View V = inflater.inflate(R.layout.fashion_view, container, false);
 
            return V;
        }
}
