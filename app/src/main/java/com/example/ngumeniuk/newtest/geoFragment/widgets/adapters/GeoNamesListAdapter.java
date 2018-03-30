package com.example.ngumeniuk.newtest.geoFragment.widgets.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ngumeniuk.newtest.R;
import com.example.ngumeniuk.newtest.geoFragment.data.models.databaseEntities.CityNameModel;
import com.example.ngumeniuk.newtest.widgets.adapters.BaseListAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GeoNamesListAdapter
        extends BaseListAdapter<CityNameModel, GeoNamesListAdapter.ViewHolder> {

    OnLongClickListener listener;

    public GeoNamesListAdapter(OnLongClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.city_view, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(list.get(position), listener);
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.city_name)
        TextView textView;
        View itemView;

        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            this.itemView = itemView;
        }

        void bind(CityNameModel model, OnLongClickListener listener) {
            textView.setText(model.getName());
            itemView.setOnLongClickListener((view) -> {
                listener.onNoteClick(model);
                return false;
            });
        }

    }

    public interface OnLongClickListener {
        void onNoteClick(CityNameModel model);
    }
}
