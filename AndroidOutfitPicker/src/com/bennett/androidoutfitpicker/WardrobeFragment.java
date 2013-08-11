package com.bennett.androidoutfitpicker;

import java.util.List;
import java.util.Random;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;

import com.bennett.androidoutfitpicker.database.GarmentsDataSource;
import com.bennett.androidoutfitpicker.models.Garment;

public class WardrobeFragment extends ListFragment implements OnClickListener {
	
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
        add.setOnClickListener(this);

	    Button delete = (Button) V.findViewById(R.id.delete);
        delete.setOnClickListener(this);

		return V;
	}
	  // Will be called via the onClick attribute
	  // of the buttons in main.xml
	  public void onClick(View view) {
	    @SuppressWarnings("unchecked")
	    ArrayAdapter<Garment> adapter = (ArrayAdapter<Garment>) getListAdapter();
	    Garment Garment = null;
	    switch (view.getId()) {
	    case R.id.add:
	      String[] Garments = new String[] { "Pants", "Shirt", "Dress" };
	      int nextInt = new Random().nextInt(3);
	      // Save the new Garment to the database
	      Garment = datasource.createGarment(Garments[nextInt]);
	      adapter.add(Garment);
	      break;
	    case R.id.delete:
	      if (getListAdapter().getCount() > 0) {
	        Garment = (Garment) getListAdapter().getItem(0);
	        datasource.deleteGarment(Garment);
	        adapter.remove(Garment);
	      }
	      break;
	    }
	    adapter.notifyDataSetChanged();
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
