package com.qtechie.passwordmanager.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.qtechie.passwordmanager.R;
import com.qtechie.passwordmanager.adapter.PasswordRecyclerViewAdapter;
import com.qtechie.passwordmanager.model.PasswordModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PasswordFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PasswordFragment extends Fragment {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    public PasswordFragment() {
        // Required empty public constructor
    }

    public static PasswordFragment newInstance() {
        PasswordFragment fragment = new PasswordFragment();
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
        return inflater.inflate(R.layout.fragment_password, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        ButterKnife.bind(this, view);
        List<PasswordModel> passwordModelList = new ArrayList<>();

        PasswordRecyclerViewAdapter passwordRecyclerViewAdapter = new PasswordRecyclerViewAdapter(passwordModelList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(passwordRecyclerViewAdapter);

        loadItems(passwordModelList);
        passwordRecyclerViewAdapter.notifyDataSetChanged();
    }

    private void loadItems(List<PasswordModel> passwordModelList) {
        passwordModelList.add(new PasswordModel("", "my title", "", "", "", "", "", ""));
        passwordModelList.add(new PasswordModel("", "my title2", "", "", "", "", "", ""));
        passwordModelList.add(new PasswordModel("", "my title3", "", "", "", "", "", ""));
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
