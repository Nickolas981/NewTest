package com.example.ngumeniuk.newtest.widgets.adapters;

import android.annotation.SuppressLint;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;

import com.example.ngumeniuk.newtest.utils.Differeble;
import com.example.ngumeniuk.newtest.utils.NoteDiffUtilCallback;

import java.util.ArrayList;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public abstract class BaseListAdapter<T extends Differeble, VH extends RecyclerView.ViewHolder>
        extends RecyclerView.Adapter<VH> {

    private ArrayList<T> list = new ArrayList<>();

    @SuppressLint("CheckResult")
    void change(ArrayList<T> items) {
        calculateDiff(new NoteDiffUtilCallback<>(list, items))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(diffResult -> {
                    clearList();
                    list.addAll(items);
                    dispatchUpdates(diffResult);
                });
    }

    private void dispatchUpdates(DiffUtil.DiffResult diffResult) {
        diffResult.dispatchUpdatesTo(this);
    }

    void removeAt(int position) {
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

    private Single<DiffUtil.DiffResult> calculateDiff(NoteDiffUtilCallback<T> callback) {
        return Single.just(DiffUtil.calculateDiff(callback));
    }
}
