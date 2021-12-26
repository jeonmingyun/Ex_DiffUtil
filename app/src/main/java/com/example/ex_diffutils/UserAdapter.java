package com.example.ex_diffutils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.MyViewHolder> {
    Context mContext;
    ArrayList<UserVo> itemList;

    public UserAdapter(Context mContext, ArrayList<UserVo> itemList) {
        this.mContext = mContext;
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        UserVo item = itemList.get(position);

        holder.id.setText(item.getId()+"");
        holder.name.setText(item.getName());
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    protected static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView id, name;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            id = itemView.findViewById(R.id.id);
            name = itemView.findViewById(R.id.name);
        }
    }

    public void updateItems(List<UserVo> itemList) {
        final UserDiffCallback diffCallback = new UserDiffCallback(this.itemList, itemList);
        final DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(diffCallback);

        this.itemList.clear();
        this.itemList.addAll(itemList);
        diffResult.dispatchUpdatesTo(this);
    }

    public void addItem(UserVo item) {
        final UserDiffCallback diffCallback = new UserDiffCallback(this.itemList, itemList);
        final DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(diffCallback);

        this.itemList.add(item);
        diffResult.dispatchUpdatesTo(this);
    }
}
