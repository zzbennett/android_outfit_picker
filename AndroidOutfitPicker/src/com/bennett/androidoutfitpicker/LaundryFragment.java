package com.bennett.androidoutfitpicker;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
 
public class LaundryFragment extends Fragment {
 
     @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
          // Inflate the layout for this fragment
          View V = inflater.inflate(R.layout.laundry_view, container, false);
 
            return V;
        }
}