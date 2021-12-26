package com.example.ex_diffutils;

import androidx.recyclerview.widget.DiffUtil;

import java.util.List;

public class UserDiffCallback extends DiffUtil.Callback {
    private final List<UserVo> mOldItemList;
    private final List<UserVo> mNewItemList;

    public UserDiffCallback(List<UserVo> oldItemList, List<UserVo>  newItemList) {
        this.mOldItemList = oldItemList;
        this.mNewItemList = newItemList;
    }

    @Override
    public int getOldListSize() {
        return mOldItemList.size();
    }

    @Override
    public int getNewListSize() {
        return mNewItemList.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return mOldItemList.get(oldItemPosition).getId() == mNewItemList.get(
                newItemPosition).getId();
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        final UserVo oldEmployee = mOldItemList.get(oldItemPosition);
        final UserVo newEmployee = mNewItemList.get(newItemPosition);

        return oldEmployee.getName().equals(newEmployee.getName());
    }

    @Override
    public Object getChangePayload(int oldItemPosition, int newItemPosition) {
        // Implement method if you're going to use ItemAnimator
        return super.getChangePayload(oldItemPosition, newItemPosition);
    }
}