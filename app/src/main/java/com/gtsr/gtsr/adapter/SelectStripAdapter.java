package com.gtsr.gtsr.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.gtsr.gtsr.R;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SelectStripAdapter extends RecyclerView.Adapter<SelectStripAdapter.StripHolder> {
    int selectedPosition = -1;
    Context context;

    public SelectStripAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public StripHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.test_strip_itemview, parent, false);
        return new StripHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StripHolder holder, int position) {

        if (selectedPosition == position) {
            Log.e("if", "" + position);
            holder.image.setVisibility(View.VISIBLE);
        } else {
            Log.e("else", "" + position);
            holder.image.setVisibility(View.GONE);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selectedPosition != position) {
                    selectedPosition = position;
                    notifyDataSetChanged();
                } else {
                    selectedPosition = -1;
                    notifyDataSetChanged();
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return 2;
    }

    public class StripHolder extends RecyclerView.ViewHolder {
        ImageView image;
        public StripHolder(@NonNull View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.image);

        }
    }
}
