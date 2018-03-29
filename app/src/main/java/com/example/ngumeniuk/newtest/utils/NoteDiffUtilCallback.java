package com.example.ngumeniuk.newtest.utils;

import android.support.v7.util.DiffUtil;

import java.util.ArrayList;
import java.util.List;

public class NoteDiffUtilCallback<T extends Differeble> extends DiffUtil.Callback {

    private ArrayList<T> oldList, newList;

    public NoteDiffUtilCallback(ArrayList<T> oldList, ArrayList<T> newList) {
        this.oldList = oldList;
        this.newList = newList;
    }

    @Override
    public int getOldListSize() {
        return oldList.size();
    }

    @Override
    public int getNewListSize() {
        return newList.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return oldList.get(oldItemPosition).getIdToDiff() ==
                newList.get(newItemPosition).getIdToDiff();
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        return oldList.get(oldItemPosition).equals(newList.get(newItemPosition));
    }
}
