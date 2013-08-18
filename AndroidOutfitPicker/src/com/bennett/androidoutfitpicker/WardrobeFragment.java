package com.bennett.androidoutfitpicker;

import java.util.List;
import java.util.Random;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Toast;

import com.bennett.androidoutfitpicker.CreateNewGarmentFragmentDialog.NewGarmentDialogListener;
import com.bennett.androidoutfitpicker.database.GarmentsDataSource;
import com.bennett.androidoutfitpicker.models.Garment;

public class WardrobeFragment extends ListFragment implements NewGarmentDialogListener {

	public GarmentsDataSource datasource;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		// Inflate the layout for this fragment
		View V = inflater.inflate(R.layout.wardrobe_view, container, false);


		datasource = new GarmentsDataSource(this.getActivity());
		datasource.open();

		List<Garment> values = datasource.getAllGarments();

		// Use the SimpleCursorAdapter to show the
		// elements in a ListView
		ArrayAdapter<Garment> adapter = new ArrayAdapter<Garment>(this.getActivity(),
				android.R.layout.simple_list_item_1, values);
		setListAdapter(adapter);

		Button add = (Button) V.findViewById(R.id.add);
		add.setOnClickListener(new OnClickListener() {
            public void onClick(View v) { addGarment(); }
        });

		Button delete = (Button) V.findViewById(R.id.delete);
		delete.setOnClickListener(new OnClickListener() {
            public void onClick(View v) { deleteGarment(); }
        });

		return V;
	}
	

	private void addGarment(){
		
		/***TODO add user interface funsies here ***/
		//i.e. Pop up a dialog where users can enter a garment?
		 // DialogFragment.show() will take care of adding the fragment
	    // in a transaction.  We also want to remove any currently showing
	    // dialog, so make our own transaction and take care of that here.


	    showNewGarmentDialog();
	}
	
	//TODO replace String desc with GarmentAttrs object
	private void addNewGarmentToDataSource(String desc){

		ArrayAdapter<Garment> adapter = (ArrayAdapter<Garment>) getListAdapter();
		Garment Garment = null;
		
		Garment = datasource.createGarment(desc);
		adapter.add(Garment);
		adapter.notifyDataSetChanged();
		
	}

	/*** Deleting a garment should happen when someone presses and holds on a garment ***/
	private void deleteGarment(){
		
		ArrayAdapter<Garment> adapter = (ArrayAdapter<Garment>) getListAdapter();
		Garment Garment = null;

		if (getListAdapter().getCount() > 0) {
			Garment = (Garment) getListAdapter().getItem(0);
			datasource.deleteGarment(Garment);
			adapter.remove(Garment);
		}
		adapter.notifyDataSetChanged();
	}
	
    private void showNewGarmentDialog() {
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        CreateNewGarmentFragmentDialog newGarmentDialog = new CreateNewGarmentFragmentDialog();
        newGarmentDialog.setTargetFragment(this, 1);;
        newGarmentDialog.show(ft, "fragment_edit_name");
    }

	
    @Override
    public void onFinishCreateGarmentDialog(String inputText) {
    	addNewGarmentToDataSource(inputText);
    }




	@Override
	public void onResume() {
		datasource.open();
		super.onResume();
	}

	@Override
	public void onPause() {
		datasource.close();
		super.onPause();
	}
}
