package com.qtechie.passwordmanager.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.qtechie.passwordmanager.R;
import com.qtechie.passwordmanager.model.PasswordModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Admin on 03-03-2018.
 */

public class PasswordRecyclerViewAdapter extends RecyclerView.Adapter<PasswordRecyclerViewAdapter.PasswordViewHolder> {
    List<PasswordModel> passwordModelList = new ArrayList<>();

    public PasswordRecyclerViewAdapter(List<PasswordModel> passwordModelList) {
        this.passwordModelList = passwordModelList;
    }

    @Override
    public PasswordViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View viewHolder = LayoutInflater.from(parent.getContext()).inflate(R.layout.pwd_list_row, parent, false);
        return new PasswordViewHolder(viewHolder);
    }

    @Override
    public void onBindViewHolder(PasswordViewHolder holder, int position) {
        PasswordModel model = passwordModelList.get(position);
        holder.title.setText(model.title);
    }

    @Override
    public int getItemCount() {
        return passwordModelList.size();
    }

    public class PasswordViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tV_category)
        public TextView category;

        @BindView(R.id.tV_title)
        public TextView title;

        @BindView(R.id.tV_username)
        public TextView username;
        @BindView(R.id.tV_pwd)
        public TextView password;
        @BindView(R.id.tV_ques1)
        public TextView security_ques1;
        @BindView(R.id.tV_ques2)
        public TextView security_ques2;
        @BindView(R.id.tV_ans1)
        public TextView security_ans1;
        @BindView(R.id.tV_ans2)
        public TextView security_ans2;

        public PasswordViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            title = itemView.findViewById(R.id.tV_title);
        }
    }
}
