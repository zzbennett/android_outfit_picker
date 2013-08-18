package com.bennett.androidoutfitpicker;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager.LayoutParams;
import android.view.inputmethod.EditorInfo;
import android.webkit.WebView.FindListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

public class CreateNewGarmentFragmentDialog extends DialogFragment {

	public interface NewGarmentDialogListener {
        void onFinishCreateGarmentDialog(String inputText);
    }

    private EditText mEditText;

    public CreateNewGarmentFragmentDialog() {
        // Empty constructor required for DialogFragment
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.create_garment_dialog, container);
        mEditText = (EditText) view.findViewById(R.id.txt_your_name);
        getDialog().setTitle("Hello");

        // Show soft keyboard automatically
        mEditText.requestFocus();
        getDialog().getWindow().setSoftInputMode(
                LayoutParams.SOFT_INPUT_STATE_VISIBLE);
        getDialog();
        Button dismissDialogButton = (Button) view.findViewById(R.id.close_new_garment_dialog);
        dismissDialogButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				NewGarmentDialogListener activity = (NewGarmentDialogListener) getTargetFragment();
				activity.onFinishCreateGarmentDialog(mEditText.getText().toString());
				dismiss();
			}
		});

        return view;
    }



}
