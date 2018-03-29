package com.example.ngumeniuk.newtest.widgets.adapters;

import android.annotation.SuppressLint;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;

import com.example.ngumeniuk.newtest.utils.Differeble;
import com.example.ngumeniuk.newtest.utils.NoteDiffUtilCallback;

import java.util.ArrayList;

public abstract class BaseListAdapter<T extends Differeble, VH extends RecyclerView.ViewHolder>
        extends RecyclerView.Adapter<VH> {

    protected ArrayList<T> list = new ArrayList<>();

    @SuppressLint("CheckResult")
    public void change(ArrayList<T> items) {
       DiffUtil.DiffResult res = DiffUtil.calculateDiff(new NoteDiffUtilCallback<>(list, items));
       clearList();
       list.addAll(items);
       dispatchUpdates(res);
    }

    private void dispatchUpdates(DiffUtil.DiffResult diffResult) {
        diffResult.dispatchUpdatesTo(this);
    }

    public void removeAt(int position) {
        list.remove(position);
        notifyItemRemoved(position);
    }

    private void clearList() {
        list.clear();
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public long getItemId(int position) {
        return (long) position;
    }

}
