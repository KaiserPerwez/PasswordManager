package com.qtechie.passwordmanager.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.BottomSheetDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.qtechie.passwordmanager.R;

public class BottomSheetDialogAddPasswordFragment extends BottomSheetDialogFragment {

    public BottomSheetDialogAddPasswordFragment() {
        // Required empty public constructor
    }

    public static BottomSheetDialogAddPasswordFragment newInstance(String param1, String param2) {
        BottomSheetDialogAddPasswordFragment fragment = new BottomSheetDialogAddPasswordFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bottom_sheet_dialog_add_password, container, false);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
